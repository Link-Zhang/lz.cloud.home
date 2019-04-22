package cn.sh.lz.cloud.house.common.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 15:14 on 4/17/19.
 */
@Data
public class HouseCommunityNameInput {
    @JsonProperty("district")
    @ApiModelProperty(value = "市辖区")
    private String district;

    @JsonProperty("limit")
    @ApiModelProperty(value = "分页总数")
    private Integer limit;
}
