package cn.sh.lz.cloud.history.repositories;

import cn.sh.lz.cloud.history.common.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * Created by Link at 14:07 on 5/20/19.
 */
public interface HistoryRepository extends JpaRepository<History, BigInteger>, JpaSpecificationExecutor<History> {
}
