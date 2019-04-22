package cn.sh.lz.cloud.house.common.outputs;

import cn.sh.lz.cloud.house.common.vos.HouseCountVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Link at 15:56 on 4/17/19.
 */
@Data
@AllArgsConstructor
public class HouseCountOutput {
    @JsonProperty("houseCountList")
    @ApiModelProperty(value = "房屋数量列表", required = true)
    private List<HouseCountVO> countList;
}
