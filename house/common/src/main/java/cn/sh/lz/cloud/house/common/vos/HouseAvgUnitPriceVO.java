package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Link at 13:47 on 4/15/19.
 */
@Data
public class HouseAvgUnitPriceVO {
    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", example = "静安", required = true)
    private String houseDistrict;

    @JsonProperty("avgUnitPrice")
    @ApiModelProperty(notes = "平均单价", position = 1, example = "61202", required = true)
    private Double houseAvgUnitPrice;
}
