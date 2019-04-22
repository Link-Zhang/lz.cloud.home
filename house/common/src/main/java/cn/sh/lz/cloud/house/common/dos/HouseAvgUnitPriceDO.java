package cn.sh.lz.cloud.house.common.dos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Link at 16:00 on 4/12/19.
 */
@Data
@AllArgsConstructor
public class HouseAvgUnitPriceDO {
    private String houseDistrict;

    private Double houseAvgUnitPrice;
}
