package cn.sh.lz.cloud.vcommunity.common.entities;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Link at 16:36 on 5/30/19.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel()
@Table(name = "vcommunity")
public class VCommunity {
    @Id
    @Column(nullable = false, name = "community_id")
    @ApiModelProperty(notes = "The View Community ID", example = "5011000000192", required = true)
    private BigInteger communityId;

    @Column(nullable = false, name = "community_district")
    @ApiModelProperty(notes = "The View Community District", position = 1, example = "虹口", required = true)
    private String communityDistrict;

    @Column(nullable = false, name = "community_name")
    @ApiModelProperty(notes = "The View Community Name", position = 2, example = "新市南路561弄", required = true)
    private String communityName;

    @Column(nullable = false, name = "community_house_count")
    @ApiModelProperty(notes = "The View Community House Count", position = 3, example = "1", required = true)
    private BigInteger communityHouseCount;

    @Column(nullable = false, name = "community_avg_total_price ")
    @ApiModelProperty(notes = "The View Community House Avg Total Price", position = 4, example = "369", required = true)
    private Double communityAvgTotalPrice;

    @Column(nullable = false, name = "community_avg_unit_price ")
    @ApiModelProperty(notes = "The View Community House Avg Unit Price", position = 5, example = "55075.0000", required = true)
    private Double communityAvgUnitPrice;

    @Column(nullable = false, name = "community_max_total_price ")
    @ApiModelProperty(notes = "The View Community House Max Total Price", position = 6, example = "369", required = true)
    private Double communityMaxTotalPrice;

    @Column(nullable = false, name = "community_max_structure_area ")
    @ApiModelProperty(notes = "The View Community House Max Structure Area", position = 7, example = "67", required = true)
    private Double communityMaxStructureArea;

    @Column(nullable = false, name = "community_max_down_payment ")
    @ApiModelProperty(notes = "The View Community House Max Down Payment", position = 8, example = "130", required = true)
    private Long communityMaxDownPayment;

    @Column(nullable = false, name = "community_min_unit_price ")
    @ApiModelProperty(notes = "The View Community House Min Unit Price", position = 9, example = "55075", required = true)
    private Long communityMinUnitPrice;

    @Column(nullable = false, name = "community_min_total_price ")
    @ApiModelProperty(notes = "The View Community House Min Total Price", position = 10, example = "369", required = true)
    private Double communityMinTotalPrice;

    @Column(nullable = false, name = "community_min_structure_area ")
    @ApiModelProperty(notes = "The View Community House Min Structure Area", position = 11, example = "67", required = true)
    private Double communityMinStructureArea;

    @Column(nullable = false, name = "community_min_down_payment ")
    @ApiModelProperty(notes = "The View Community House Min Down Payment", position = 12, example = "130", required = true)
    private Long communityMinDownPayment;

    @Column(nullable = false, name = "community_max_unit_price ")
    @ApiModelProperty(notes = "The View Community House Max Unit Price", position = 13, example = "55075", required = true)
    private Long communityMaxUnitPrice;

    @Column(nullable = false, name = "community_longitude")
    @ApiModelProperty(notes = "The View Community Longitude", position = 14, example = "121.4881876000", required = true)
    private BigDecimal houseCommunityLongitude;

    @Column(nullable = false, name = "community_latitude")
    @ApiModelProperty(notes = "The View Community Latitude", position = 15, example = "31.2982590900", required = true)
    private BigDecimal houseCommunityLatitude;
}
