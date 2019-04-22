package cn.sh.lz.cloud.house.common.outputs;

import cn.sh.lz.cloud.house.common.entities.House;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Link at 16:36 on 4/12/19.
 */
@Data
@AllArgsConstructor
public class HouseByIdOutput {
    @JsonProperty("house")
    @ApiModelProperty(value = "房屋", required = true)
    private House house;
}
