package cn.sh.lz.cloud.statistic.common.entities;

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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 18:58 on 6/10/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ApiModel()
@Table(name = "statistic")
public class Statistic {
    @javax.persistence.Id
    @Column(nullable = false, name = "id")
    @ApiModelProperty(notes = "统计ID", example = "1", required = true)
    private BigInteger statisticId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "嘉定", required = true)
    private String statisticHouseDistrict;

    @Column(nullable = false, name = "house_avg_total_price")
    @ApiModelProperty(notes = "房屋平均总价", position = 2, example = "245.58", required = true)
    private Double statisticHouseAvgTotalPrice;

    @Column(nullable = false, name = "house_avg_unit_price ")
    @ApiModelProperty(notes = "房屋平均单价", position = 3, example = "32316", required = true)
    private BigInteger statisticHouseAvgUnitPrice;

    @Column(nullable = false, name = "house_sale_count ")
    @ApiModelProperty(notes = "在售房屋数量", position = 4, example = "3096", required = true)
    private BigInteger statisticHouseSaleCount;

    @Column(nullable = false, name = "update_time")
    @ApiModelProperty(notes = "更新时间", position = 5, example = "2019-05-13 22:00:01", required = true)
    private Date statisticUpdateTime;
}
