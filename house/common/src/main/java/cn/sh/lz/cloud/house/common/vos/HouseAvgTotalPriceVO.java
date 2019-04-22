package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 13:47 on 4/15/19.
 */
@Data
public class HouseAvgTotalPriceVO {
    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", example = "静安", required = true)
    private String houseDistrict;

    @JsonProperty("avgTotalPrice")
    @ApiModelProperty(notes = "平均总价", position = 1, example = "315.00", required = true)
    private Double houseAvgTotalPrice;
}
