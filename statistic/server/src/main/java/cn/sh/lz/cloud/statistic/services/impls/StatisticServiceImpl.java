package cn.sh.lz.cloud.statistic.services.impls;

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
    private final StatisticRepository statisticRepository;

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

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

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
