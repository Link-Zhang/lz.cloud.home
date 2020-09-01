package cn.sh.lz.cloud.statistic.services;

import cn.sh.lz.cloud.statistic.common.dtos.StatisticDTO;
import cn.sh.lz.cloud.statistic.common.entities.Statistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Link at 18:56 on 6/10/19.
 */
public interface StatisticService {
    Page<Statistic> findAllPaginated(StatisticDTO statisticDTO, Pageable pageable);
}
