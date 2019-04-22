package cn.sh.lz.cloud.house.common.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Link at 10:45 on 4/18/19.
 */
@Data
@AllArgsConstructor
public class HouseUsageOutput {
    @JsonProperty("houseUsageList")
    @ApiModelProperty(value = "房屋用途情况列表", required = true)
    private List<String> usageList;
}
