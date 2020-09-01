package cn.sh.lz.cloud.history.common.dtos;

import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 15:15 on 5/20/19.
 */
@Data
public class HistoryFindDTO {
    private BigInteger historyHouseId;

    private String historyHouseDistrict;

    private Double downRangeHouseTotalPrice;

    private Long downRangeHouseDownPayment;

    private Long downRangeHouseUnitPrice;
}
