package cn.sh.lz.cloud.house.common.inputs;

import cn.sh.lz.cloud.house.common.vos.HouseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * Created by Link at 09:48 on 4/12/19.
 */
@Data
public class HouseInput {
    @ApiModelProperty(value = "HouseVO")
    private HouseVO houseVO;

    @JsonProperty("page")
    @ApiModelProperty(value = "分页页数")
    private Integer page = 0;

    @JsonProperty("limit")
    @ApiModelProperty(value = "分页总数")
    private Integer limit;

    @JsonProperty("sortDirection")
    @ApiModelProperty(value = "排序方向")
    private Sort.Direction sortDirection = Sort.Direction.ASC;

    @JsonProperty("sortProperties")
    @ApiModelProperty(value = "排序属性")
    private String sortProperties = "houseId";
}
