package cn.sh.lz.cloud.house.repositories;

import cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO;
import cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO;
import cn.sh.lz.cloud.house.common.dos.HouseCountDO;
import cn.sh.lz.cloud.house.common.entities.House;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

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
 * Created by Link at 16:45 on 4/11/19.
 */

// todo change it to async
public interface HouseRepository extends JpaRepository<House, BigInteger>, JpaSpecificationExecutor<House> {
    @Query("SELECT NEW cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO(h.houseDistrict, AVG(h.houseTotalPrice)) FROM House AS h GROUP BY h.houseDistrict ORDER BY AVG(h.houseTotalPrice) ASC ")
    List<HouseAvgTotalPriceDO> findAvgTotalPrice();

    @Query("SELECT NEW cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO(h.houseDistrict,AVG(h.houseTotalPrice)) FROM House AS h WHERE h.houseDistrict LIKE :district")
    List<HouseAvgTotalPriceDO> findDistrictAvgTotalPrice(@Param("district") String district);

    @Query("SELECT NEW cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO(h.houseDistrict, AVG(h.houseUnitPrice)) FROM House AS h WHERE h.houseTotalPrice <=:totalPrice GROUP BY h.houseDistrict ORDER BY AVG(h.houseUnitPrice) ASC")
    List<HouseAvgUnitPriceDO> findAvgUnitPrice(@Param("totalPrice") Double totalPrice);

    @Query("SELECT NEW cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO(h.houseDistrict,AVG(h.houseUnitPrice)) FROM House AS h WHERE h.houseDistrict LIKE :district AND h.houseTotalPrice<=:totalPrice ORDER BY AVG(h.houseUnitPrice) ASC")
    List<HouseAvgUnitPriceDO> findDistrictAvgUnitPrice(@Param("district") String district, @Param("totalPrice") Double totalPrice);

    @Query("SELECT distinct h.houseCertificate FROM House AS h")
    List<String> findDistinctCertificate();

    @Query("SELECT distinct h.houseCommunityName FROM House AS h")
    List<String> findDistinctCommunityName(Pageable pageable);

    @Query("SELECT distinct h.houseCommunityName FROM House AS h WHERE h.houseDistrict LIKE :district")
    List<String> findDistinctCommunityName(@Param("district") String district, Pageable pageable);

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseCountDO(h.houseDistrict, COUNT(h.houseId)) FROM House AS h GROUP BY h.houseDistrict order by COUNT(h.houseId) ASC")
    List<HouseCountDO> findCount();

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseCountDO(h.houseDistrict, COUNT(h.houseId)) FROM House AS h WHERE h.houseDistrict LIKE :district")
    List<HouseCountDO> findDistrictCount(@Param("district") String district);

    @Query("SELECT distinct h.houseDecoration FROM House AS h")
    List<String> findDistinctDecoration();

    @Query("SELECT distinct h.houseDirection FROM House AS h")
    List<String> findDistinctDirection();

    @Query("SELECT distinct h.houseDistrict FROM House AS h")
    List<String> findDistinctDistrict();

    @Query("SELECT distinct h.houseFloor FROM House AS h ORDER BY  h.houseFloor ASC")
    List<String> findDistinctFloor();

    @Query("SELECT distinct h.houseHasElevator FROM House AS h")
    List<String> findDistinctHasElevator();

    @Query("SELECT distinct h.houseIsUnique FROM House AS h")
    List<String> findDistinctIsUnique();

    @Query("SELECT distinct h.housePropertyOwnership FROM House AS h")
    List<String> findDistinctPropertyOwnership();

    @Query("SELECT distinct h.houseTradingOwnership FROM House AS h")
    List<String> findDistinctTradingOwnership();

    @Query("SELECT distinct h.houseTradingSituation FROM House AS h")
    List<String> findDistinctTradingSituation();

    @Query("SELECT distinct h.houseType FROM House AS h ORDER BY h.houseType ASC")
    List<String> findDistinctType();

    @Query("SELECT distinct h.houseUsage FROM House AS h")
    List<String> findDistinctUsage();
}
