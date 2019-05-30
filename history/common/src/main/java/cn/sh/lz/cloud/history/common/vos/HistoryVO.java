package cn.sh.lz.cloud.history.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

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
 * Created by Link at 17:22 on 5/20/19.
 */
@Data
public class HistoryVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "历史ID", example = "1")
    private BigInteger historyId;

    @JsonProperty("houseId")
    @ApiModelProperty(notes = "房屋ID", position = 1, example = "107100152911")
    private BigInteger historyHouseId;

    @JsonProperty("houseDistrict")
    @ApiModelProperty(notes = "市辖区", position = 2, example = "徐汇")
    private String historyHouseDistrict;

    @JsonProperty("houseUrl")
    @ApiModelProperty(notes = "房屋URL", position = 3, example = "https://sh.lianjia.com/ershoufang/107100152911.html")
    private String historyHouseUrl;

    @JsonProperty("oldHouseTotalPrice")
    @ApiModelProperty(notes = "原房屋总价", position = 4, example = "198")
    private Double historyOldHouseTotalPrice;

    @JsonProperty("oldHouseDownPayment")
    @ApiModelProperty(notes = "原房屋首付", position = 5, example = "70")
    private Long historyOldHouseDownPayment;

    @JsonProperty("oldHouseUnitPrice")
    @ApiModelProperty(notes = "原房屋单价", position = 6, example = "53471")
    private Long historyOldHouseUnitPrice;

    @JsonProperty("newHouseTotalPrice")
    @ApiModelProperty(notes = "新房屋总价", position = 7, example = "197")
    private Double historyNewHouseTotalPrice;

    @JsonProperty("newHouseDownPayment")
    @ApiModelProperty(notes = "新房屋首付", position = 8, example = "69")
    private Long historyNewHouseDownPayment;

    @JsonProperty("newHouseUnitPrice")
    @ApiModelProperty(notes = "新房屋单价", position = 9, example = "53201")
    private Long historyNewHouseUnitPrice;

    @JsonProperty("updateTime")
    @ApiModelProperty(notes = "更新时间", position = 10, example = "2019-05-13T17:46:11.000+0000")
    private Date historyUpdateTime;
}
