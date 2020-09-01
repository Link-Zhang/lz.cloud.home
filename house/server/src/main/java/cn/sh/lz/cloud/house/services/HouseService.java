package cn.sh.lz.cloud.house.services;

import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 16:48 on 4/11/19.
 */
public interface HouseService {
    Page<House> findAllPaginated(HouseDTO houseDTO, Pageable pageable);

    List<History> findHistoryByHouseId(BigInteger id);
}
