package cn.sh.lz.cloud.vcommunity.services;

import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.vcommunity.common.dtos.VCommunityFindDTO;
import cn.sh.lz.cloud.vcommunity.common.entities.VCommunity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 17:24 on 5/30/19.
 */
public interface VCommunityService {
    Page<VCommunity> findAllPaginated(VCommunityFindDTO vCommunityFindDTO, Pageable pageable);

    List<House> findHouseByCommunityId(BigInteger id);
}
