package cn.sh.lz.cloud.history.services.impls;

import cn.sh.lz.cloud.history.common.dtos.HistoryFindDTO;
import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.repositories.HistoryRepository;
import cn.sh.lz.cloud.history.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
 * Created by Link at 14:02 on 5/23/19.
 */

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<History> findAllPaginated(HistoryFindDTO historyFindDTO, Pageable pageable) {
        Assert.notNull(pageable, "The given pageable must not be null!");
        if (Optional.ofNullable(historyFindDTO).isPresent()) {
            Double downRangeHouseTotalPrice = Optional.ofNullable(historyFindDTO.getDownRangeHouseTotalPrice()).filter(i -> i > 0).orElse(null);
            Long downRangeHouseDownPayment = Optional.ofNullable(historyFindDTO.getDownRangeHouseDownPayment()).filter(i -> i > 0).orElse(null);
            Long downRangeHouseUnitPrice = Optional.ofNullable(historyFindDTO.getDownRangeHouseUnitPrice()).filter(i -> i > 0).orElse(null);
            Specification<History> specification = (Specification<History>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmpty(historyFindDTO.getHistoryHouseId())) {
                    predicateList.add(criteriaBuilder.equal(root.get("historyHouseId").as(BigInteger.class), historyFindDTO.getHistoryHouseId()));
                }
                if (!StringUtils.isEmpty(historyFindDTO.getHistoryHouseDistrict())) {
                    predicateList.add(criteriaBuilder.like(root.get("historyHouseDistrict").as(String.class), "%" + historyFindDTO.getHistoryHouseDistrict().trim() + "%"));
                }
                if (null != downRangeHouseTotalPrice) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseTotalPrice").as(Double.class), root.get("historyNewHouseTotalPrice").as(Double.class)), downRangeHouseTotalPrice));
                }
                if (null != downRangeHouseDownPayment) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseDownPayment").as(Long.class), root.get("historyNewHouseDownPayment").as(Long.class)), downRangeHouseDownPayment));
                }
                if (null != downRangeHouseUnitPrice) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseUnitPrice").as(Long.class), root.get("historyNewHouseUnitPrice").as(Long.class)), downRangeHouseUnitPrice));
                }
                Predicate[] predicate = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicate));
            };
            return historyRepository.findAll(specification, pageable);
        } else {
            return historyRepository.findAll(pageable);
        }
    }
}
