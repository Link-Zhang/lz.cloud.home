package cn.sh.lz.cloud.house.common.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Link at 15:15 on 4/17/19.
 */
@Data
@AllArgsConstructor
public class HouseCommunityNameOutput {
    @JsonProperty("HouseCommunityNameList")
    @ApiModelProperty(value = "小区名称列表", required = true)
    private List<String> communityNameList;
}
