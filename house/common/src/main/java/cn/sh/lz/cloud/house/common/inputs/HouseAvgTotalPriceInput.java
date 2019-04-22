package cn.sh.lz.cloud.house.common.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 10:41 on 4/15/19.
 */
@Data
public class HouseAvgTotalPriceInput {
    @JsonProperty("district")
    @ApiModelProperty(value = "市辖区")
    private String district;
}
