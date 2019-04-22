package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 15:57 on 4/17/19.
 */
@Data
public class HouseCountVO {
    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", example = "静安", required = true)
    private String houseDistrict;

    @JsonProperty("count")
    @ApiModelProperty(notes = "房屋数量", position = 1, example = "100", required = true)
    private Long houseCount;
}
