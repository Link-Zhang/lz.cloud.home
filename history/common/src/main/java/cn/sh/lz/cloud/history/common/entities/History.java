package cn.sh.lz.cloud.history.common.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
 * Created by Link at 13:49 on 5/20/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ApiModel()
@Table(name = "history")
public class History {
    @javax.persistence.Id
    @Column(nullable = false, name = "id")
    @ApiModelProperty(notes = "历史ID", example = "1", required = true)
    private BigInteger historyId;

    @Column(nullable = false, name = "house_id")
    @ApiModelProperty(notes = "房屋ID", position = 1, example = "107100152911", required = true)
    private BigInteger historyHouseId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(notes = "市辖区", position = 2, example = "徐汇", required = true)
    private String historyHouseDistrict;

    @Column(nullable = false, name = "house_url")
    @ApiModelProperty(notes = "房屋URL", position = 3, example = "https://sh.lianjia.com/ershoufang/107100152911.html", required = true)
    private String historyHouseUrl;

    @Column(nullable = false, name = "old_house_total_price")
    @ApiModelProperty(notes = "原房屋总价", position = 4, example = "198", required = true)
    private Double historyOldHouseTotalPrice;

    @Column(nullable = false, name = "old_house_down_payment")
    @ApiModelProperty(notes = "原房屋首付", position = 5, example = "70", required = true)
    private Long historyOldHouseDownPayment;

    @Column(nullable = false, name = "old_house_unit_price")
    @ApiModelProperty(notes = "原房屋单价", position = 6, example = "53471", required = true)
    private Long historyOldHouseUnitPrice;

    @Column(nullable = false, name = "new_house_total_price")
    @ApiModelProperty(notes = "新房屋总价", position = 7, example = "197", required = true)
    private Double historyNewHouseTotalPrice;

    @Column(nullable = false, name = "new_house_down_payment")
    @ApiModelProperty(notes = "新房屋首付", position = 8, example = "69", required = true)
    private Long historyNewHouseDownPayment;

    @Column(nullable = false, name = "new_house_unit_price")
    @ApiModelProperty(notes = "新房屋单价", position = 9, example = "53201", required = true)
    private Long historyNewHouseUnitPrice;

    @Column(nullable = false, name = "update_time")
    @ApiModelProperty(notes = "更新时间", position = 10, example = "2019-05-14 01:46:11", required = true)
    private Date historyUpdateTime;
}
