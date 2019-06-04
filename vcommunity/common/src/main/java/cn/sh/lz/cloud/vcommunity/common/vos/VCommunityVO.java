package cn.sh.lz.cloud.vcommunity.common.vos;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 09:35 on 5/31/19.
 */
@Data
public class VCommunityVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "社区ID", example = "5011000000192")
    private BigInteger communityId;

    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "虹口")
    private String communityDistrict;

    @JsonProperty("name")
    @ApiModelProperty(notes = "社区名称", position = 2, example = "新市南路561弄")
    private String communityName;

    @JsonProperty("houseCount")
    @ApiModelProperty(notes = "房屋数量", position = 3, example = "1")
    private BigInteger communityHouseCount;

    @JsonProperty("avgTotalPrice")
    @ApiModelProperty(notes = "平均总价", position = 4, example = "369")
    private Double communityAvgTotalPrice;

    @JsonProperty("avgUnitPrice")
    @ApiModelProperty(notes = "平均单价", position = 5, example = "55075.0000")
    private Double communityAvgUnitPrice;

    @JsonProperty("maxTotalPrice")
    @ApiModelProperty(notes = "最高总价", position = 6, example = "369")
    private Double communityMaxTotalPrice;

    @JsonProperty("maxStructureArea")
    @ApiModelProperty(notes = "最大建筑面积", position = 7, example = "67")
    private Double communityMaxStructureArea;

    @JsonProperty("maxDownPayment")
    @ApiModelProperty(notes = "最高首付", position = 8, example = "130")
    private Long communityMaxDownPayment;

    @JsonProperty("minUnitPrice")
    @ApiModelProperty(notes = "最低单价", position = 9, example = "55075")
    private Long communityMinUnitPrice;

    @JsonProperty("minTotalPrice")
    @ApiModelProperty(notes = "最低总价", position = 10, example = "369")
    private Double communityMinTotalPrice;

    @JsonProperty("minStructureArea")
    @ApiModelProperty(notes = "最小建筑面积", position = 11, example = "67")
    private Double communityMinStructureArea;

    @JsonProperty("minDownPayment")
    @ApiModelProperty(notes = "最低首付", position = 12, example = "130")
    private Long communityMinDownPayment;

    @JsonProperty("maxUnitPrice")
    @ApiModelProperty(notes = "最高单价", position = 13, example = "55075")
    private Long communityMaxUnitPrice;
}
