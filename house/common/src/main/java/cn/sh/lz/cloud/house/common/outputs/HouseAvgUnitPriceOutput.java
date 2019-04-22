package cn.sh.lz.cloud.house.common.outputs;

import cn.sh.lz.cloud.house.common.vos.HouseAvgUnitPriceVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Link at 16:12 on 4/12/19.
 */
@Data
@AllArgsConstructor
public class HouseAvgUnitPriceOutput {
    @JsonProperty("houseAvgUnitPriceList")
    @ApiModelProperty(value = "平均单价列表", required = true)
    private List<HouseAvgUnitPriceVO> avgUnitPriceList;
}
