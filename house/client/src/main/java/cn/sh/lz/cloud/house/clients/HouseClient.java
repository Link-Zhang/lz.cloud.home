package cn.sh.lz.cloud.house.clients;

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

import cn.sh.lz.cloud.house.common.inputs.*;
import cn.sh.lz.cloud.house.common.outputs.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

/**
 * Created by Link at 14:44 on 6/4/19.
 */
@FeignClient(name = "house", fallback = HouseClient.HouseClientFallback.class)
public interface HouseClient {
    @GetMapping(value = "/api/v1/house/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseOutput find(HouseInput houseInput);

    @GetMapping(value = "/api/v1/house/avgTotalPrice", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseAvgTotalPriceOutput findAvgTotalPrice(HouseAvgTotalPriceInput houseAvgTotalPriceInput);

    @GetMapping(value = "/api/v1/house/avgUnitPrice", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseAvgUnitPriceOutput findAvgUnitPrice(HouseAvgUnitPriceInput houseAvgUnitPriceInput);

    @GetMapping(value = "/api/v1/house/certificate", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseCertificateOutput findCertificate();

    @GetMapping(value = "/api/v1/house/communityName", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseCommunityNameOutput findCommunityName(HouseCommunityNameInput houseCommunityNameInput);

    @GetMapping(value = "/api/v1/house/count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseCountOutput findCount(HouseCountInput houseCountInput);

    @GetMapping(value = "/api/v1/house/decoration", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseDecorationOutput findDecoration();

    @GetMapping(value = "/api/v1/house/direction", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseDirectionOutput findDirection();

    @GetMapping(value = "/api/v1/house/district", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseDistrictOutput findDistrict();

    @GetMapping(value = "/api/v1/house/floor", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseFloorOutput findFloor();

    @GetMapping(value = "/api/v1/house/hasElevator", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseHasElevatorOutput findHasElevator();

    @GetMapping(value = "/api/v1/house/hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String hello();

    @GetMapping(value = "/api/v1/house/id", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseIdOutput findId(HouseIdInput houseIdInput);

    @GetMapping(value = "/api/v1/house/isUnique", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseIsUniqueOutput findIsUnique();

    @GetMapping(value = "/api/v1/house/propertyOwnership", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HousePropertyOwnershipOutput findPropertyOwnership();

    @GetMapping(value = "/api/v1/house/tradingOwnership", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseTradingOwnershipOutput findTradingOwnership();

    @GetMapping(value = "/api/v1/house/tradingSituation", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseTradingSituationOutput findTradingSituation();

    @GetMapping(value = "/api/v1/house/type", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseTypeOutput findType();

    @GetMapping(value = "/api/v1/house/usage", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseUsageOutput findUsage();

    @GetMapping(value = "/api/v1/house/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseByIdOutput findById(@PathVariable(value = "id") BigInteger id);

    @GetMapping(value = "/api/v1/house/{id}/history", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id);

    @Component
    static class HouseClientFallback implements HouseClient {
        @Override
        public HouseOutput find(HouseInput houseInput) {
            System.out.println("【house微服务中的find服务降级!】");
            return null;
        }

        @Override
        public HouseAvgTotalPriceOutput findAvgTotalPrice(HouseAvgTotalPriceInput houseAvgTotalPriceInput) {
            System.out.println("【house微服务中的findAvgTotalPrice服务降级!】");
            return null;
        }

        @Override
        public HouseAvgUnitPriceOutput findAvgUnitPrice(HouseAvgUnitPriceInput houseAvgUnitPriceInput) {
            System.out.println("【house微服务中的findAvgUnitPrice服务降级!】");
            return null;
        }

        @Override
        public HouseCertificateOutput findCertificate() {
            System.out.println("【house微服务中的findCertificate服务降级!】");
            return null;
        }

        @Override
        public HouseCommunityNameOutput findCommunityName(HouseCommunityNameInput houseCommunityNameInput) {
            System.out.println("【house微服务中的findCommunityName服务降级!】");
            return null;
        }

        @Override
        public HouseCountOutput findCount(HouseCountInput houseCountInput) {
            System.out.println("【house微服务中的findCount服务降级!】");
            return null;
        }

        @Override
        public HouseDecorationOutput findDecoration() {
            System.out.println("【house微服务中的findDecoration服务降级!】");
            return null;
        }

        @Override
        public HouseDirectionOutput findDirection() {
            System.out.println("【house微服务中的findDirection服务降级!】");
            return null;
        }

        @Override
        public HouseDistrictOutput findDistrict() {
            System.out.println("【house微服务中的findDistrict服务降级!】");
            return null;
        }

        @Override
        public HouseFloorOutput findFloor() {
            System.out.println("【house微服务中的findFloor服务降级!】");
            return null;
        }

        @Override
        public HouseHasElevatorOutput findHasElevator() {
            System.out.println("【house微服务中的findHasElevator服务降级!】");
            return null;
        }

        @Override
        public String hello() {
            System.out.println("【house微服务中的hello服务降级!】");
            return null;
        }

        @Override
        public HouseIdOutput findId(HouseIdInput houseIdInput) {
            System.out.println("【house微服务中的findId服务降级!】");
            return null;
        }

        @Override
        public HouseIsUniqueOutput findIsUnique() {
            System.out.println("【house微服务中的findIsUnique服务降级!】");
            return null;
        }

        @Override
        public HousePropertyOwnershipOutput findPropertyOwnership() {
            System.out.println("【house微服务中的findPropertyOwnership服务降级!】");
            return null;
        }

        @Override
        public HouseTradingOwnershipOutput findTradingOwnership() {
            System.out.println("【house微服务中的findTradingOwnership服务降级!】");
            return null;
        }

        @Override
        public HouseTradingSituationOutput findTradingSituation() {
            System.out.println("【house微服务中的findTradingSituation服务降级!】");
            return null;
        }

        @Override
        public HouseTypeOutput findType() {
            System.out.println("【house微服务中的findType服务降级!】");
            return null;
        }

        @Override
        public HouseUsageOutput findUsage() {
            System.out.println("【house微服务中的findUsage服务降级!】");
            return null;
        }

        @Override
        public HouseByIdOutput findById(BigInteger id) {
            System.out.println("【house微服务中的findById服务降级!】");
            return null;
        }

        @Override
        public HouseHistoryByIdOutput findHistoryByHouseId(BigInteger id) {
            System.out.println("【house微服务中的findHistoryByHouseId服务降级!】");
            return null;
        }
    }
}
