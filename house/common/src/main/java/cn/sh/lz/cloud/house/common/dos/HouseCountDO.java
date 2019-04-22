package cn.sh.lz.cloud.house.common.dos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Link at 15:50 on 4/17/19.
 */
@Data
@AllArgsConstructor
public class HouseCountDO {
    private String houseDistrict;

    private Long houseCount;
}
