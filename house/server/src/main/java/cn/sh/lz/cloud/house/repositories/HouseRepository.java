package cn.sh.lz.cloud.house.repositories;

import cn.sh.lz.cloud.house.common.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * Created by Link at 16:45 on 4/11/19.
 */
public interface HouseRepository extends JpaRepository<House, BigInteger>, JpaSpecificationExecutor<House> {
}
