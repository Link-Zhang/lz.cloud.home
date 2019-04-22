package cn.sh.lz.cloud.house.common.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 15:46 on 4/17/19.
 */
@Data
public class HouseCountInput {
    @JsonProperty("district")
    @ApiModelProperty(value = "市辖区")
    private String district;
}
