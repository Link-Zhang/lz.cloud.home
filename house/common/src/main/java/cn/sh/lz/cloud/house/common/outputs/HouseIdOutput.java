package cn.sh.lz.cloud.house.common.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 16:36 on 4/12/19.
 */
@Data
@AllArgsConstructor
public class HouseIdOutput {
    @JsonProperty("idList")
    @ApiModelProperty(value = "房屋ID列表", required = true)
    private List<BigInteger> idList;
}
