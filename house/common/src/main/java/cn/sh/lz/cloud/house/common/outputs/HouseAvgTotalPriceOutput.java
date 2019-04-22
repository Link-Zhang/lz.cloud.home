package cn.sh.lz.cloud.house.common.outputs;

import cn.sh.lz.cloud.house.common.vos.HouseAvgTotalPriceVO;
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
public class HouseAvgTotalPriceOutput {
    @JsonProperty("houseAvgTotalPriceList")
    @ApiModelProperty(value = "平均总价列表", required = true)
    private List<HouseAvgTotalPriceVO> avgTotalPriceList;
}
