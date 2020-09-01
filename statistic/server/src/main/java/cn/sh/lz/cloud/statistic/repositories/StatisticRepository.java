package cn.sh.lz.cloud.statistic.repositories;

import cn.sh.lz.cloud.statistic.common.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * Created by Link at 18:54 on 6/10/19.
 */
public interface StatisticRepository extends JpaRepository<Statistic, BigInteger>, JpaSpecificationExecutor<Statistic> {
}
