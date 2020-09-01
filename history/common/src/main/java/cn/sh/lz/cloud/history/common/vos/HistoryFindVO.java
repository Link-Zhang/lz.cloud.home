package cn.sh.lz.cloud.history.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 14:49 on 5/20/19.
 */
@Data
public class HistoryFindVO {
    @JsonProperty("historyHouseId")
    @ApiModelProperty(notes = "房屋ID")
    private BigInteger historyHouseId;

    @JsonProperty("historyHouseDistrict")
    @ApiModelProperty(notes = "市辖区")
    private String historyHouseDistrict;

    @JsonProperty("downRangeHouseTotalPrice")
    @ApiModelProperty(notes = "房屋总价降价超过X万元")
    private Double downRangeHouseTotalPrice;

    @JsonProperty("downRangeHouseDownPayment")
    @ApiModelProperty(notes = "房屋首付降价超过X万元")
    private Long downRangeHouseDownPayment;

    @JsonProperty("downRangeHouseUnitPrice")
    @ApiModelProperty(notes = "房屋单价降价超过X元")
    private Long downRangeHouseUnitPrice;
}
