package cn.sh.lz.cloud.house.services;

import cn.sh.lz.cloud.house.common.dtos.HouseAvgTotalPriceDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseAvgUnitPriceDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseCountDTO;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


public interface HouseService {
    Page<House> findAllPaginated(HouseDTO houseDTO, Pageable pageable);

    List<HouseAvgTotalPriceDTO> findAvgTotalPrice(String district);

    List<HouseAvgUnitPriceDTO> findAvgUnitPrice(String district, Double price);

    List<String> findDistinctCertificate();

    List<String> findDistinctCommunityName(String district, Integer limit);

    List<HouseCountDTO> findCount(String district);

    List<String> findDistinctDecoration();

    List<String> findDistinctDirection();

    List<String> findDistinctDistrict();

    List<String> findDistinctFloor();

    List<String> findDistinctHasElevator();

    List<String> findDistinctIsUnique();

    List<String> findDistinctPropertyOwnership();

    List<String> findDistinctTradingOwnership();

    List<String> findDistinctTradingSituation();

    List<String> findDistinctType();

    List<String> findDistinctUsage();

    Optional<House> findByHouseId(BigInteger id);
}
