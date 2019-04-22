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
public class HouseDistrictOutput {
    @JsonProperty("houseDistrictList")
    @ApiModelProperty(value = "房屋市辖区列表", required = true)
    private List<String> districtList;
}
