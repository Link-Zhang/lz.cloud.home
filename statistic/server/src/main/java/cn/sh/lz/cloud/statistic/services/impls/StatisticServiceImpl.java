package cn.sh.lz.cloud.statistic.services.impls;

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

import cn.sh.lz.cloud.statistic.common.dtos.StatisticDTO;
import cn.sh.lz.cloud.statistic.common.entities.Statistic;
import cn.sh.lz.cloud.statistic.repositories.StatisticRepository;
import cn.sh.lz.cloud.statistic.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * Created by Link at 18:56 on 6/10/19.
 */
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;

    @Value("${cn.sh.lz.cloud.statistic.default.start.year}")
    private int START_YEAR;

    @Value("${cn.sh.lz.cloud.statistic.default.start.month}")
    private int START_MONTH;

    @Value("${cn.sh.lz.cloud.statistic.default.start.day}")
    private int START_DAY;

    @Value("${cn.sh.lz.cloud.statistic.default.end.year}")
    private int END_YEAR;

    @Value("${cn.sh.lz.cloud.statistic.default.end.month}")
    private int END_MONTH;

    @Value("${cn.sh.lz.cloud.statistic.default.end.day}")
    private int END_DAY;

    private Specification<Statistic> getStatisticSpecification(StatisticDTO statisticDTO) {
        Assert.notNull(statisticDTO, "The given statisticDTO must not be null!");
        Assert.notNull(statisticDTO.getStatisticHouseDistrict(), "The given statisticDTO.getStatisticHouseDistrict must not be null!");
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, START_YEAR);
        gc.set(Calendar.MONTH, START_MONTH - 1);
        gc.set(Calendar.DAY_OF_MONTH, START_DAY);
        Date startUpdateTime = Optional.ofNullable(statisticDTO.getStartUpdateTime()).orElse(gc.getTime());
        gc.set(Calendar.YEAR, END_YEAR);
        gc.set(Calendar.MONTH, END_MONTH - 1);
        gc.set(Calendar.DAY_OF_MONTH, END_DAY);
        Date endUpdateTime = Optional.ofNullable(statisticDTO.getEndUpdateTime()).orElse(gc.getTime());
        return (Specification<Statistic>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            predicateList.add(criteriaBuilder.like(root.get("statisticHouseDistrict").as(String.class), "%" + statisticDTO.getStatisticHouseDistrict().trim() + "%"));
            predicateList.add(criteriaBuilder.between(root.get("statisticUpdateTime").as(Date.class), startUpdateTime, endUpdateTime));
            Predicate[] predicate = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicate));
        };
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Statistic> findAllPaginated(StatisticDTO statisticDTO, Pageable pageable) {
        Assert.notNull(statisticDTO, "The given statisticDTO must not be null!");
        Assert.notNull(pageable, "The given pageable must not be null!");
        return statisticRepository.findAll(getStatisticSpecification(statisticDTO), pageable);
    }
}
