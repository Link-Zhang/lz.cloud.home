package cn.sh.lz.cloud.house.common.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 18:26 on 4/15/19.
 */
@Data
public class HouseAvgUnitPriceInput {
    @JsonProperty("district")
    @ApiModelProperty(value = "市辖区")
    private String district;

    @JsonProperty("price")
    @ApiModelProperty(value = "总价上限")
    private Double price = 250.0;
}
