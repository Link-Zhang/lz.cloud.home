package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

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
public class HouseVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "房屋ID",example = "107000005011")
    private BigInteger houseId;

    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "浦东")
    private String houseDistrict;

    @JsonProperty("communityName")
    @ApiModelProperty(notes = "小区名称", position = 2, example = "西门锦绣苑")
    private String houseCommunityName;

    @JsonProperty("usage")
    @ApiModelProperty(notes = "房屋用途", position = 3,example = "普通住宅")
    private String houseUsage;

    @JsonProperty("tradingSituation")
    @ApiModelProperty(notes = "交易情况", position = 4, example = "暂无数据")
    private String houseTradingSituation;

    @JsonProperty("isUnique")
    @ApiModelProperty(notes = "唯一情况", position = 5, example = "不唯一")
    private String houseIsUnique;

    @JsonProperty("structureArea")
    @ApiModelProperty(notes = "建筑面积", position = 6, example = "108.76")
    private Double houseStructureArea;

    @JsonProperty("totalPrice")
    @ApiModelProperty(notes = "房屋总价", position = 7, example = "295")
    private Double houseTotalPrice;

    @JsonProperty("downPayment")
    @ApiModelProperty(notes = "房屋首付", position = 8, example = "104")
    private Long houseDownPayment;

    @JsonProperty("unitPrice")
    @ApiModelProperty(notes = "房屋单价", position = 9, example = "27124")
    private Long houseUnitPrice;

    @JsonProperty("type")
    @ApiModelProperty(notes = "房屋户型", position = 10, example = "2室2厅1厨1卫")
    private String houseType;

    @JsonProperty("floor")
    @ApiModelProperty(notes = "房屋楼层", position = 11, example = "中楼层 (共12层)")
    private String houseFloor;

    @JsonProperty("direction")
    @ApiModelProperty(notes = "房屋朝向", position = 12, example = "南")
    private String houseDirection;

    @JsonProperty("decoration")
    @ApiModelProperty(notes = "装修情况", position = 13, example = "毛坯")
    private String houseDecoration;

    @JsonProperty("hasElevator")
    @ApiModelProperty(notes = "配备电梯", position = 14, example = "有")
    private String houseHasElevator;

    @JsonProperty("age")
    @ApiModelProperty(notes = "楼龄情况", position = 15, example = "2008年建/板楼")
    private String houseAge;

    @JsonProperty("tradingOwnership")
    @ApiModelProperty(notes = "交易权属", position = 16, example = "动迁安置房")
    private String houseTradingOwnership;

    @JsonProperty("propertyOwnership")
    @ApiModelProperty(notes = "产权所属", position = 17, example = "非共有")
    private String housePropertyOwnership;

    @JsonProperty("mortgage")
    @ApiModelProperty(notes = "抵押情况", position = 18, example = "无抵押")
    private String houseMortgage;

    @JsonProperty("certificate")
    @ApiModelProperty(notes = "房本备件", position = 19, example = "未上传房本照片")
    private String houseCertificate;

    @JsonProperty("url")
    @ApiModelProperty(notes = "房屋URL", position = 20, example = "https://sh.lianjia.com/ershoufang/107000005011.html")
    private String houseUrl;

    @JsonProperty("communityId")
    @ApiModelProperty(notes = "小区ID", position = 21, example = "5011000010458")
    private BigInteger houseCommunityId;

    @JsonProperty("communityLongitude")
    @ApiModelProperty(notes = "小区经度", position = 22, example = "121.7457808")
    private BigDecimal houseCommunityLongitude;

    @JsonProperty("communityLatitude")
    @ApiModelProperty(notes = "小区经度", position = 23, example = "31.052967")
    private BigDecimal houseCommunityLatitude;

    @JsonProperty("agentName")
    @ApiModelProperty(notes = "房屋经纪人", position = 24, example = "姜贞玲")
    private String houseAgentName;

    @JsonProperty("agentPhone")
    @ApiModelProperty(notes = "经纪人电话", position = 25, example = "13641928757")
    private String houseAgentPhone;
}
