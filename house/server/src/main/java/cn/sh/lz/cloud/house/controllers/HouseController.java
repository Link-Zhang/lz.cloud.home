package cn.sh.lz.cloud.house.controllers;

import cn.sh.lz.cloud.house.common.dtos.HouseAvgTotalPriceDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseAvgUnitPriceDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseCountDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.inputs.*;
import cn.sh.lz.cloud.house.common.outputs.*;
import cn.sh.lz.cloud.house.common.utils.ConvertUtil;
import cn.sh.lz.cloud.house.common.vos.*;
import cn.sh.lz.cloud.house.services.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Link at 15:22 on 4/11/19.
 */
@RestController
@RequestMapping(path = "/api/v1/house")
@Api(value = "房屋微服务", consumes = "application/json")
public class HouseController {
    @Value("${cn.sh.lz.cloud.house.default.size}")
    private Integer DEFAULT_SIZE;

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "获取房屋", notes = "获取房屋(默认10条)")
    @GetMapping(path = "/", produces = "application/json")
    public @ResponseBody
    HouseOutput find(HouseInput houseInput) {
        Integer size = Optional.ofNullable(houseInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(houseInput.getSortDirection(), houseInput.getSortProperties());
        ConvertUtil<HouseVO, HouseDTO> convertUtil = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtil.convert(houseInput.getHouseVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseInput.getPage(), size, sort));
        return new HouseOutput(housePage.getContent());
    }

    @ApiOperation(value = "获取房屋平均总价", notes = "获取房屋平均总价")
    @GetMapping(path = "/avgTotalPrice", produces = "application/json")
    public @ResponseBody
    HouseAvgTotalPriceOutput findAvgTotalPrice(HouseAvgTotalPriceInput houseAvgTotalPriceInput) {
        ConvertUtil<HouseAvgTotalPriceDTO, HouseAvgTotalPriceVO> convertUtil = new ConvertUtil<>();
        List<HouseAvgTotalPriceDTO> list = houseService.findAvgTotalPrice(houseAvgTotalPriceInput.getDistrict());
        return new HouseAvgTotalPriceOutput(convertUtil.convert(list, HouseAvgTotalPriceVO.class));
    }

    @ApiOperation(value = "获取房屋平均单价", notes = "获取房屋平均单价(默认总价250万以内)")
    @GetMapping(path = "/avgUnitPrice", produces = "application/json")
    public @ResponseBody
    HouseAvgUnitPriceOutput findAvgUnitPrice(HouseAvgUnitPriceInput houseAvgUnitPriceInput) {
        ConvertUtil<HouseAvgUnitPriceDTO, HouseAvgUnitPriceVO> convertUtil = new ConvertUtil<>();
        List<HouseAvgUnitPriceDTO> list = houseService.findAvgUnitPrice(houseAvgUnitPriceInput.getDistrict(), houseAvgUnitPriceInput.getPrice());
        return new HouseAvgUnitPriceOutput(convertUtil.convert(list, HouseAvgUnitPriceVO.class));
    }

    @ApiOperation(value = "获取房屋房本备件情况", notes = "获取房屋房本备件情况")
    @GetMapping(path = "/certificate", produces = "application/json")
    public @ResponseBody
    HouseCertificateOutput findCertificate() {
        List<String> list = houseService.findDistinctCertificate();
        return new HouseCertificateOutput(list);
    }

    @ApiOperation(value = "获取房屋小区名称", notes = "获取房屋小区名称(默认10条)")
    @GetMapping(path = "/communityName", produces = "application/json")
    public @ResponseBody
    HouseCommunityNameOutput findCommunityName(HouseCommunityNameInput houseCommunityNameInput) {
        List<String> list = houseService.findDistinctCommunityName(houseCommunityNameInput.getDistrict(), houseCommunityNameInput.getLimit());
        return new HouseCommunityNameOutput(list);
    }

    @ApiOperation(value = "获取房屋数量", notes = "获取房屋数量")
    @GetMapping(path = "/count", produces = "application/json")
    public @ResponseBody
    HouseCountOutput findCount(HouseCountInput houseCountInput) {
        ConvertUtil<HouseCountDTO, HouseCountVO> convertUtil = new ConvertUtil<>();
        List<HouseCountDTO> list = houseService.findCount(houseCountInput.getDistrict());
        return new HouseCountOutput(convertUtil.convert(list, HouseCountVO.class));
    }

    @ApiOperation(value = "获取房屋装修情况", notes = "获取房屋装修情况")
    @GetMapping(path = "/decoration", produces = "application/json")
    public @ResponseBody
    HouseDecorationOutput findDecoration() {
        List<String> list = houseService.findDistinctDecoration();
        return new HouseDecorationOutput(list);
    }

    @ApiOperation(value = "获取房屋朝向情况", notes = "获取房屋朝向情况")
    @GetMapping(path = "/direction", produces = "application/json")
    public @ResponseBody
    HouseDirectionOutput findDirection() {
        List<String> list = houseService.findDistinctDirection();
        return new HouseDirectionOutput(list);
    }

    @ApiOperation(value = "获取房屋市辖区", notes = "获取房屋市辖区")
    @GetMapping(path = "/district", produces = "application/json")
    public @ResponseBody
    HouseDistrictOutput findDistrict() {
        List<String> list = houseService.findDistinctDistrict();
        return new HouseDistrictOutput(list);
    }

    @ApiOperation(value = "获取房屋楼层情况", notes = "获取房屋楼层情况")
    @GetMapping(path = "/floor", produces = "application/json")
    public @ResponseBody
    HouseFloorOutput findFloor() {
        List<String> list = houseService.findDistinctFloor();
        return new HouseFloorOutput(list);
    }

    @ApiOperation(value = "获取房屋电梯配备情况", notes = "获取房屋电梯配备情况")
    @GetMapping(path = "/hasElevator", produces = "application/json")
    public @ResponseBody
    HouseHasElevatorOutput findHasElevator() {
        List<String> list = houseService.findDistinctHasElevator();
        return new HouseHasElevatorOutput(list);
    }

    @ApiOperation(value = "获取房屋ID", notes = "获取房屋ID(默认10条)")
    @GetMapping(path = "/id", produces = "application/json")
    public @ResponseBody
    HouseIdOutput findId(HouseIdInput houseIdInput) {
        Integer size = Optional.ofNullable(houseIdInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(houseIdInput.getSortDirection(), houseIdInput.getSortProperties());
        ConvertUtil<HouseIdVO, HouseDTO> convertUtil = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtil.convert(houseIdInput.getIdVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseIdInput.getPage(), size, sort));
        List<House> list = housePage.getContent();
        List<BigInteger> rList = list.parallelStream().map(House::getHouseId).collect(Collectors.toList());
        return new HouseIdOutput(rList);
    }

    @ApiOperation(value = "获取房屋唯一情况", notes = "获取房屋唯一情况")
    @GetMapping(path = "/isUnique", produces = "application/json")
    public @ResponseBody
    HouseIsUniqueOutput findIsUnique() {
        List<String> list = houseService.findDistinctIsUnique();
        return new HouseIsUniqueOutput(list);
    }

    @ApiOperation(value = "获取房屋产权所属情况", notes = "获取房屋产权所属情况")
    @GetMapping(path = "/propertyOwnership", produces = "application/json")
    public @ResponseBody
    HousePropertyOwnershipOutput findPropertyOwnership() {
        List<String> list = houseService.findDistinctPropertyOwnership();
        return new HousePropertyOwnershipOutput(list);
    }

    @ApiOperation(value = "获取房屋交易权属情况", notes = "获取房屋交易权属情况")
    @GetMapping(path = "/tradingOwnership", produces = "application/json")
    public @ResponseBody
    HouseTradingOwnershipOutput findTradingOwnership() {
        List<String> list = houseService.findDistinctTradingOwnership();
        return new HouseTradingOwnershipOutput(list);
    }

    @ApiOperation(value = "获取房屋交易情况", notes = "获取交易情况")
    @GetMapping(path = "/tradingSituation", produces = "application/json")
    public @ResponseBody
    HouseTradingSituationOutput findTradingSituation() {
        List<String> list = houseService.findDistinctTradingSituation();
        return new HouseTradingSituationOutput(list);
    }

    @ApiOperation(value = "获取房屋户型情况", notes = "获取房屋户型情况")
    @GetMapping(path = "/type", produces = "application/json")
    public @ResponseBody
    HouseTypeOutput findType() {
        List<String> list = houseService.findDistinctType();
        return new HouseTypeOutput(list);
    }

    @ApiOperation(value = "获取房屋用途情况", notes = "获取房屋用途情况")
    @GetMapping(path = "/usage", produces = "application/json")
    public @ResponseBody
    HouseUsageOutput findUsage() {
        List<String> list = houseService.findDistinctUsage();
        return new HouseUsageOutput(list);
    }

    @ApiOperation(value = "获取指定ID的房屋", notes = "获取指定ID的房屋")
    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody
    HouseByIdOutput findById(HouseByIdInput houseByIdInput) {
        Optional<House> optional = houseService.findByHouseId(houseByIdInput.getId());
        return optional.map(HouseByIdOutput::new).orElseGet(() -> new HouseByIdOutput(new House()));
    }
}
