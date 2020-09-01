package cn.sh.lz.cloud.vcommunity.repositories;

import cn.sh.lz.cloud.vcommunity.common.entities.VCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * Created by Link at 17:23 on 5/30/19.
 */
public interface VCommunityRepository extends JpaRepository<VCommunity, BigInteger>, JpaSpecificationExecutor<VCommunity> {
}
