package cn.sh.lz.cloud.house.feign.controller;

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

import cn.sh.lz.cloud.house.clients.HouseClient;
import cn.sh.lz.cloud.house.common.inputs.*;
import cn.sh.lz.cloud.house.common.outputs.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 14:51 on 6/4/19.
 */
@CrossOrigin(origins = "*", allowCredentials = "true")
@RequestMapping("/feign/house")
@RestController
public class FeignController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private HouseClient houseClient;

    @ApiOperation(value = "房屋", notes = "获取房屋(默认10条)")
    @GetMapping(value = "/")
    public HouseOutput find(HouseInput houseInput) {
        return houseClient.find(houseInput);
    }

    @ApiOperation(value = "房屋平均总价", notes = "获取房屋平均总价")
    @GetMapping(value = "/avgTotalPrice")
    public HouseAvgTotalPriceOutput findAvgTotalPrice(HouseAvgTotalPriceInput houseAvgTotalPriceInput) {
        return houseClient.findAvgTotalPrice(houseAvgTotalPriceInput);
    }

    @ApiOperation(value = "房屋平均单价", notes = "获取房屋平均单价(默认总价250万以内)")
    @GetMapping(value = "/avgUnitPrice")
    public HouseAvgUnitPriceOutput findAvgUnitPrice(HouseAvgUnitPriceInput houseAvgUnitPriceInput) {
        return houseClient.findAvgUnitPrice(houseAvgUnitPriceInput);
    }

    @ApiOperation(value = "房屋房本备件", notes = "获取房屋房本备件情况")
    @GetMapping(value = "/certificate")
    public HouseCertificateOutput findCertificate() {
        return houseClient.findCertificate();
    }

    @ApiOperation(value = "社区名称", notes = "获取房屋社区名称(默认10条)")
    @GetMapping(value = "/communityName")
    public HouseCommunityNameOutput findCommunityName(HouseCommunityNameInput houseCommunityNameInput) {
        return houseClient.findCommunityName(houseCommunityNameInput);
    }

    @ApiOperation(value = "房屋数量", notes = "获取房屋数量")
    @GetMapping(value = "/count")
    public HouseCountOutput findCount(HouseCountInput houseCountInput) {
        return houseClient.findCount(houseCountInput);
    }

    @ApiOperation(value = "房屋装修", notes = "获取房屋装修情况")
    @GetMapping(value = "/decoration")
    public HouseDecorationOutput findDecoration() {
        return houseClient.findDecoration();
    }

    @ApiOperation(value = "房屋朝向", notes = "获取房屋朝向情况")
    @GetMapping(value = "/direction")
    public HouseDirectionOutput findDirection() {
        return houseClient.findDirection();
    }

    @ApiOperation(value = "市辖区", notes = "获取房屋市辖区")
    @GetMapping(value = "/district")
    public HouseDistrictOutput findDistrict() {
        return houseClient.findDistrict();
    }

    @ApiOperation(value = "楼层", notes = "获取房屋楼层情况")
    @GetMapping(value = "/floor")
    public HouseFloorOutput findFloor() {
        return houseClient.findFloor();
    }

    @ApiOperation(value = "电梯配备", notes = "获取房屋电梯配备情况")
    @GetMapping(value = "/hasElevator")
    public HouseHasElevatorOutput findHasElevator() {
        return houseClient.findHasElevator();
    }

    @ApiOperation(value = "房屋微服务实例", notes = "获取房屋微服务实例")
    @GetMapping(value = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("house");
    }

    @ApiOperation(value = "房屋微服务测试", notes = "进行房屋微服务测试")
    @GetMapping(value = "/hello")
    public String hello() {
        return houseClient.hello();
    }

    @ApiOperation(value = "房屋ID", notes = "获取房屋ID(默认10条)")
    @GetMapping(value = "/id")
    public HouseIdOutput findId(HouseIdInput houseIdInput) {
        return houseClient.findId(houseIdInput);
    }

    @ApiOperation(value = "唯一情况", notes = "获取房屋唯一情况")
    @GetMapping(value = "/isUnique")
    public HouseIsUniqueOutput findIsUnique() {
        return houseClient.findIsUnique();
    }

    @ApiOperation(value = "产权所属", notes = "获取房屋产权所属情况")
    @GetMapping(value = "/propertyOwnership")
    public HousePropertyOwnershipOutput findPropertyOwnership() {
        return houseClient.findPropertyOwnership();
    }

    @ApiOperation(value = "交易权属", notes = "获取房屋交易权属情况")
    @GetMapping(value = "/tradingOwnership")
    public HouseTradingOwnershipOutput findTradingOwnership() {
        return houseClient.findTradingOwnership();
    }

    @ApiOperation(value = "交易情况", notes = "获取交易情况")
    @GetMapping(value = "/tradingSituation")
    public HouseTradingSituationOutput findTradingSituation() {
        return houseClient.findTradingSituation();
    }

    @ApiOperation(value = "户型", notes = "获取房屋户型情况")
    @GetMapping(value = "/type")
    public HouseTypeOutput findType() {
        return houseClient.findType();
    }

    @ApiOperation(value = "用途", notes = "获取房屋用途情况")
    @GetMapping(value = "/usage")
    public HouseUsageOutput findUsage() {
        return houseClient.findUsage();
    }

    @ApiOperation(value = "指定ID的房屋", notes = "获取指定ID的房屋")
    @GetMapping(value = "/{id}")
    public HouseByIdOutput findById(@PathVariable(value = "id") BigInteger id) {
        return houseClient.findById(id);
    }

    @ApiOperation(value = "指定ID房屋的历史价格", notes = "获取指定ID房屋的历史价格")
    @GetMapping(value = "/{id}/history")
    public HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id) {
        return houseClient.findHistoryByHouseId(id);
    }
}
