package cn.sh.lz.cloud.house.repositories;

import cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO;
import cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO;
import cn.sh.lz.cloud.house.common.dos.HouseCountDO;
import cn.sh.lz.cloud.house.common.entities.House;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 16:45 on 4/11/19.
 */

// todo change it to async
public interface HouseRepository extends JpaRepository<House, BigInteger>, JpaSpecificationExecutor<House> {
    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO(h.houseDistrict, AVG(h.houseTotalPrice)) FROM House as h GROUP BY h.houseDistrict order by AVG(h.houseTotalPrice) asc")
    List<HouseAvgTotalPriceDO> findAvgTotalPrice();

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseAvgTotalPriceDO(h.houseDistrict,AVG(h.houseTotalPrice)) FROM House h WHERE h.houseDistrict =:district GROUP BY h.houseDistrict")
    List<HouseAvgTotalPriceDO> findDistrictAvgTotalPrice(@Param("district") String district);

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO(h.houseDistrict, AVG(h.houseUnitPrice)) FROM House as h WHERE h.houseTotalPrice <=:totalPrice GROUP BY h.houseDistrict order by AVG(h.houseUnitPrice) asc")
    List<HouseAvgUnitPriceDO> findAvgUnitPrice(@Param("totalPrice") Double totalPrice);

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseAvgUnitPriceDO(h.houseDistrict,AVG(h.houseUnitPrice)) FROM House h WHERE h.houseDistrict=:district and h.houseTotalPrice<=:totalPrice GROUP BY h.houseDistrict")
    List<HouseAvgUnitPriceDO> findDistrictAvgUnitPrice(@Param("district") String district, @Param("totalPrice") Double totalPrice);

    @Query("SELECT distinct h.houseCertificate FROM House as h")
    List<String> findDistinctCertificate();

    @Query("SELECT distinct h.houseCommunityName FROM House as h")
    List<String> findDistinctCommunityName(Pageable pageable);

    @Query("SELECT distinct h.houseCommunityName FROM House as h WHERE h.houseDistrict=:district")
    List<String> findDistinctCommunityName(@Param("district") String district, Pageable pageable);

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseCountDO(h.houseDistrict, COUNT(h.houseId)) FROM House as h GROUP BY h.houseDistrict order by COUNT(h.houseId) asc")
    List<HouseCountDO> findCount();

    @Query("SELECT new cn.sh.lz.cloud.house.common.dos.HouseCountDO(h.houseDistrict, COUNT(h.houseId)) FROM House as h WHERE h.houseDistrict=:district GROUP BY h.houseDistrict")
    List<HouseCountDO> findDistrictCount(@Param("district") String district);

    @Query("SELECT distinct h.houseDecoration FROM House as h")
    List<String> findDistinctDecoration();

    @Query("SELECT distinct h.houseDirection FROM House as h")
    List<String> findDistinctDirection();

    @Query("SELECT distinct h.houseDistrict FROM House as h")
    List<String> findDistinctDistrict();

    @Query("SELECT distinct h.houseFloor FROM House as h order by h.houseFloor asc")
    List<String> findDistinctFloor();

    @Query("SELECT distinct h.houseHasElevator FROM House as h")
    List<String> findDistinctHasElevator();

    @Query("SELECT distinct h.houseIsUnique FROM House as h")
    List<String> findDistinctIsUnique();

    @Query("SELECT distinct h.housePropertyOwnership FROM House as h")
    List<String> findDistinctPropertyOwnership();

    @Query("SELECT distinct h.houseTradingOwnership FROM House as h")
    List<String> findDistinctTradingOwnership();

    @Query("SELECT distinct h.houseTradingSituation FROM House as h")
    List<String> findDistinctTradingSituation();

    @Query("SELECT distinct h.houseType FROM House as h order by h.houseType asc")
    List<String> findDistinctType();

    @Query("SELECT distinct h.houseUsage FROM House as h")
    List<String> findDistinctUsage();
}
