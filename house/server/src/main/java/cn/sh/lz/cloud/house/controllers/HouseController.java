package cn.sh.lz.cloud.house.controllers;

import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */

/***
 *  佛曰:
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          不见满街漂亮妹，哪个归得程序员？
 */

/***
 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
 * │Esc│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│| \│~ `│
 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┤
 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ Del │
 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤
 * │ Ctrl │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Return │
 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┬────┤
 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│Shift│ Fn │
 * └─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┴────┘
 *       │ Alt│ ⌘ ◇│                       │◇ ⌘ │ Alt│
 *       └────┴────┴───────────────────────┴────┴────┘
 *
 *                  Happy Hacking Key Board
 */

/**
 * Created by Link at 15:22 on 4/11/19.
 */
@RestController
@RequestMapping(path = "/api/v1/house")
@Api(value = "房屋微服务", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HouseController {
    @Value("${cn.sh.lz.cloud.house.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation(value = "获取房屋", notes = "获取房屋(默认10条)")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseOutput find(HouseInput houseInput) {
        Integer size = Optional.ofNullable(houseInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(houseInput.getSortDirection(), houseInput.getSortProperties());
        ConvertUtil<HouseFindVO, HouseDTO> convertUtilIn = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtilIn.convert(houseInput.getHouseFindVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseInput.getPage(), size, sort));
        ConvertUtil<House, HouseVO> convertUtilOut = new ConvertUtil<>();
        List<HouseVO> list = convertUtilOut.convert(housePage.getContent(), HouseVO.class);
        return new HouseOutput(list);
    }

    @ApiOperation(value = "获取房屋平均总价", notes = "获取房屋平均总价")
    @GetMapping(path = "/avgTotalPrice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseAvgTotalPriceOutput findAvgTotalPrice(HouseAvgTotalPriceInput houseAvgTotalPriceInput) {
        List<HouseAvgTotalPriceDTO> list = houseService.findAvgTotalPrice(houseAvgTotalPriceInput.getDistrict());
        ConvertUtil<HouseAvgTotalPriceDTO, HouseAvgTotalPriceVO> convertUtil = new ConvertUtil<>();
        return new HouseAvgTotalPriceOutput(convertUtil.convert(list, HouseAvgTotalPriceVO.class));
    }

    @ApiOperation(value = "获取房屋平均单价", notes = "获取房屋平均单价(默认总价250万以内)")
    @GetMapping(path = "/avgUnitPrice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseAvgUnitPriceOutput findAvgUnitPrice(HouseAvgUnitPriceInput houseAvgUnitPriceInput) {
        List<HouseAvgUnitPriceDTO> list = houseService.findAvgUnitPrice(houseAvgUnitPriceInput.getDistrict(), houseAvgUnitPriceInput.getPrice());
        ConvertUtil<HouseAvgUnitPriceDTO, HouseAvgUnitPriceVO> convertUtil = new ConvertUtil<>();
        return new HouseAvgUnitPriceOutput(convertUtil.convert(list, HouseAvgUnitPriceVO.class));
    }

    @ApiOperation(value = "获取房屋房本备件情况", notes = "获取房屋房本备件情况")
    @GetMapping(path = "/certificate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseCertificateOutput findCertificate() {
        List<String> list = houseService.findDistinctCertificate();
        return new HouseCertificateOutput(list);
    }

    @ApiOperation(value = "获取房屋小区名称", notes = "获取房屋小区名称(默认10条)")
    @GetMapping(path = "/communityName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseCommunityNameOutput findCommunityName(HouseCommunityNameInput houseCommunityNameInput) {
        List<String> list = houseService.findDistinctCommunityName(houseCommunityNameInput.getDistrict(), houseCommunityNameInput.getLimit());
        return new HouseCommunityNameOutput(list);
    }

    @ApiOperation(value = "获取房屋数量", notes = "获取房屋数量")
    @GetMapping(path = "/count", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseCountOutput findCount(HouseCountInput houseCountInput) {
        List<HouseCountDTO> list = houseService.findCount(houseCountInput.getDistrict());
        ConvertUtil<HouseCountDTO, HouseCountVO> convertUtil = new ConvertUtil<>();
        return new HouseCountOutput(convertUtil.convert(list, HouseCountVO.class));
    }

    @ApiOperation(value = "获取房屋装修情况", notes = "获取房屋装修情况")
    @GetMapping(path = "/decoration", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseDecorationOutput findDecoration() {
        List<String> list = houseService.findDistinctDecoration();
        return new HouseDecorationOutput(list);
    }

    @ApiOperation(value = "获取房屋朝向情况", notes = "获取房屋朝向情况")
    @GetMapping(path = "/direction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseDirectionOutput findDirection() {
        List<String> list = houseService.findDistinctDirection();
        return new HouseDirectionOutput(list);
    }

    @ApiOperation(value = "获取房屋市辖区", notes = "获取房屋市辖区")
    @GetMapping(path = "/district", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseDistrictOutput findDistrict() {
        List<String> list = houseService.findDistinctDistrict();
        return new HouseDistrictOutput(list);
    }

    @ApiOperation(value = "获取房屋楼层情况", notes = "获取房屋楼层情况")
    @GetMapping(path = "/floor", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseFloorOutput findFloor() {
        List<String> list = houseService.findDistinctFloor();
        return new HouseFloorOutput(list);
    }

    @ApiOperation(value = "获取房屋电梯配备情况", notes = "获取房屋电梯配备情况")
    @GetMapping(path = "/hasElevator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseHasElevatorOutput findHasElevator() {
        List<String> list = houseService.findDistinctHasElevator();
        return new HouseHasElevatorOutput(list);
    }

    @ApiOperation(value = "房屋微服务测试", notes = "房屋微服务测试")
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }

    //    set Timeout to 3000ms
    @ApiOperation(value = "获取房屋ID", notes = "获取房屋ID(默认10条)")
    @GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseIdOutput findId(HouseIdInput houseIdInput) {
        Integer size = Optional.ofNullable(houseIdInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(houseIdInput.getSortDirection(), houseIdInput.getSortProperties());
        ConvertUtil<HouseIdVO, HouseDTO> convertUtil = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtil.convert(houseIdInput.getHouseIdVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseIdInput.getPage(), size, sort));
        List<House> list = housePage.getContent();
        List<BigInteger> rList = list.parallelStream().map(House::getHouseId).collect(Collectors.toList());
        return new HouseIdOutput(rList);
    }

    @ApiOperation(value = "获取房屋唯一情况", notes = "获取房屋唯一情况")
    @GetMapping(path = "/isUnique", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseIsUniqueOutput findIsUnique() {
        List<String> list = houseService.findDistinctIsUnique();
        return new HouseIsUniqueOutput(list);
    }

    @ApiOperation(value = "获取房屋产权所属情况", notes = "获取房屋产权所属情况")
    @GetMapping(path = "/propertyOwnership", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HousePropertyOwnershipOutput findPropertyOwnership() {
        List<String> list = houseService.findDistinctPropertyOwnership();
        return new HousePropertyOwnershipOutput(list);
    }

    @ApiOperation(value = "获取房屋交易权属情况", notes = "获取房屋交易权属情况")
    @GetMapping(path = "/tradingOwnership", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseTradingOwnershipOutput findTradingOwnership() {
        List<String> list = houseService.findDistinctTradingOwnership();
        return new HouseTradingOwnershipOutput(list);
    }

    @ApiOperation(value = "获取房屋交易情况", notes = "获取交易情况")
    @GetMapping(path = "/tradingSituation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseTradingSituationOutput findTradingSituation() {
        List<String> list = houseService.findDistinctTradingSituation();
        return new HouseTradingSituationOutput(list);
    }

    @ApiOperation(value = "获取房屋户型情况", notes = "获取房屋户型情况")
    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseTypeOutput findType() {
        List<String> list = houseService.findDistinctType();
        return new HouseTypeOutput(list);
    }

    @ApiOperation(value = "获取房屋用途情况", notes = "获取房屋用途情况")
    @GetMapping(path = "/usage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseUsageOutput findUsage() {
        List<String> list = houseService.findDistinctUsage();
        return new HouseUsageOutput(list);
    }

    @ApiOperation(value = "获取指定ID的房屋", notes = "获取指定ID的房屋")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseByIdOutput findById(@PathVariable(value = "id") BigInteger id) {
        Optional<House> optional = houseService.findByHouseId(id);
        ConvertUtil<House, HouseVO> convertUtil = new ConvertUtil<>();
        if (optional.isPresent()) {
            return new HouseByIdOutput(convertUtil.convert(optional.get(), HouseVO.class));
        } else {
            HouseVO houseVO = new HouseVO();
            return new HouseByIdOutput(houseVO);
        }
    }

    @ApiOperation(value = "获取指定ID房屋的历史价格", notes = "获取指定ID房屋的历史价格")
    @GetMapping(path = "/{id}/history", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id) {
        List<History> historyList = houseService.findHistoryByHouseId(id);
        ConvertUtil<History, HistoryVO> convertUtil = new ConvertUtil<>();
        List<HistoryVO> list = convertUtil.convert(historyList, HistoryVO.class);
        return new HouseHistoryByIdOutput(list);
    }
}
