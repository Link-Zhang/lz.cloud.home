package cn.sh.lz.cloud.house.controllers;

import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.inputs.HouseInput;
import cn.sh.lz.cloud.house.common.outputs.HouseHistoryByIdOutput;
import cn.sh.lz.cloud.house.common.outputs.HouseOutput;
import cn.sh.lz.cloud.house.common.utils.ConvertUtil;
import cn.sh.lz.cloud.house.common.vos.HouseFindVO;
import cn.sh.lz.cloud.house.common.vos.HouseVO;
import cn.sh.lz.cloud.house.services.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 15:22 on 4/11/19.
 */
@RestController
@RequestMapping(path = "/api/v1/house")
@Api(value = "房屋微服务")
public class HouseController {
    @Value("${cn.sh.lz.cloud.house.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    private final HouseService houseService;

    private final HttpServletRequest request;

    @Autowired
    public HouseController(HouseService houseService, HttpServletRequest request) {
        this.houseService = houseService;
        this.request = request;
    }

    @ApiOperation(value = "获取房屋", notes = "获取房屋(默认10条)")
    @GetMapping(path = "/")
    public @ResponseBody
    HouseOutput find(HouseInput houseInput) {
        Integer size = Optional.ofNullable(houseInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = Sort.by(houseInput.getSortDirection(), houseInput.getSortProperties());
        ConvertUtil<HouseFindVO, HouseDTO> convertUtilIn = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtilIn.convert(houseInput.getHouseFindVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseInput.getPage(), size, sort));
        ConvertUtil<House, HouseVO> convertUtilOut = new ConvertUtil<>();
        List<HouseVO> list = convertUtilOut.convert(housePage.getContent(), HouseVO.class);
        return new HouseOutput(list);
    }

    @ApiOperation(value = "房屋微服务测试", notes = "房屋微服务测试")
    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }

    @ApiOperation(value = "获取指定ID房屋的历史价格", notes = "获取指定ID房屋的历史价格")
    @GetMapping(path = "/{id}/history")
    public @ResponseBody
    HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id) {
        List<History> historyList = houseService.findHistoryByHouseId(id);
        ConvertUtil<History, HistoryVO> convertUtil = new ConvertUtil<>();
        List<HistoryVO> list = convertUtil.convert(historyList, HistoryVO.class);
        return new HouseHistoryByIdOutput(list);
    }
}
