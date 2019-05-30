package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
 * Created by Link at 09:58 on 4/12/19.
 */
@Data
public class HouseFindVO {
    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区")
    private String houseDistrict;

    @JsonProperty("communityName")
    @ApiModelProperty(notes = "小区名称")
    private String houseCommunityName;

    @JsonProperty("usage")
    @ApiModelProperty(notes = "房屋用途")
    private String houseUsage;

    @JsonProperty("tradingSituation")
    @ApiModelProperty(notes = "交易情况")
    private String houseTradingSituation;

    @JsonProperty("isUnique")
    @ApiModelProperty(notes = "是否唯一")
    private String houseIsUnique;

    @JsonProperty("leStructureArea")
    @ApiModelProperty(notes = "最大建筑面积")
    private Double houseLeStructureArea;

    @JsonProperty("geStructureArea")
    @ApiModelProperty(notes = "最小建筑面积")
    private Double houseGeStructureArea;

    @JsonProperty("leTotalPrice")
    @ApiModelProperty(notes = "最高房屋总价")
    private Double houseLeTotalPrice;

    @JsonProperty("geTotalPrice")
    @ApiModelProperty(notes = "最低房屋总价")
    private Double houseGeTotalPrice;

    @JsonProperty("leDownPayment")
    @ApiModelProperty(notes = "最高房屋首付")
    private Long houseLeDownPayment;

    @JsonProperty("geDownPayment")
    @ApiModelProperty(notes = "最低房屋首付")
    private Long houseGeDownPayment;

    @JsonProperty("leUnitPrice")
    @ApiModelProperty(notes = "最高房屋单价")
    private Long houseLeUnitPrice;

    @JsonProperty("geUnitPrice")
    @ApiModelProperty(notes = "最低房屋单价")
    private Long houseGeUnitPrice;

    @JsonProperty("type")
    @ApiModelProperty(notes = "房屋户型")
    private String houseType;

    @JsonProperty("floor")
    @ApiModelProperty(notes = "房屋楼层")
    private String houseFloor;

    @JsonProperty("direction")
    @ApiModelProperty(notes = "房屋朝向")
    private String houseDirection;

    @JsonProperty("decoration")
    @ApiModelProperty(notes = "装修情况")
    private String houseDecoration;

    @JsonProperty("hasElevator")
    @ApiModelProperty(notes = "配备电梯")
    private String houseHasElevator;

    @JsonProperty("age")
    @ApiModelProperty(notes = "楼龄情况")
    private String houseAge;

    @JsonProperty("tradingOwnership")
    @ApiModelProperty(notes = "交易权属")
    private String houseTradingOwnership;

    @JsonProperty("propertyOwnership")
    @ApiModelProperty(notes = "产权所属")
    private String housePropertyOwnership;

    @JsonProperty("mortgage")
    @ApiModelProperty(notes = "抵押情况")
    private String houseMortgage;

    @JsonProperty("certificate")
    @ApiModelProperty(notes = "房本备件")
    private String houseCertificate;

    @JsonProperty("communityId")
    @ApiModelProperty(notes = "小区Id")
    private String houseCommunityId;
}
