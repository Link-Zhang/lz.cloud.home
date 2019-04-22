package cn.sh.lz.cloud.house.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Link at 16:09 on 4/17/19.
 */
@Data
// Data Fixed
@AllArgsConstructor
public class HouseAvgTotalPriceDTO {
    private String houseDistrict;

    private Double houseAvgTotalPrice;
}
