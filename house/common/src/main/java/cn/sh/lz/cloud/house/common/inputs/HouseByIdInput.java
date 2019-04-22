package cn.sh.lz.cloud.house.common.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 14:34 on 4/19/19.
 */
@Data
public class HouseByIdInput {
    @JsonProperty("id")
    @ApiModelProperty(value = "房屋Id")
    private BigInteger id;
}
