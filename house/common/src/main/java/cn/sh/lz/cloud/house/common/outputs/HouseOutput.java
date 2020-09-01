package cn.sh.lz.cloud.house.common.outputs;

import cn.sh.lz.cloud.house.common.vos.HouseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Link at 16:36 on 4/12/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseOutput {
    @JsonProperty("houseVOList")
    @ApiModelProperty(notes = "房屋列表", required = true)
    private List<HouseVO> houseVOList;
}
