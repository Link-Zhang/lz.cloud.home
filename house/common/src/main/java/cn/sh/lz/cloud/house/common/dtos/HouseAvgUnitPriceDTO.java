package cn.sh.lz.cloud.house.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Link at 15:41 on 4/12/19.
 */
@Data
// Data Fixed
@AllArgsConstructor
public class HouseAvgUnitPriceDTO {
    private String houseDistrict;

    private Double houseAvgUnitPrice;
}
