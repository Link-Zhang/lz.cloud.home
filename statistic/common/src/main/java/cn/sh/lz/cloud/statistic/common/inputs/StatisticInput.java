package cn.sh.lz.cloud.statistic.common.inputs;

import cn.sh.lz.cloud.statistic.common.vos.StatisticFindVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * Created by Link at 09:48 on 4/12/19.
 */
@Data
public class StatisticInput {
    @ApiModelProperty(notes = "statisticFindVO")
    private StatisticFindVO statisticFindVO = new StatisticFindVO();

    @JsonProperty("page")
    @ApiModelProperty(notes = "分页页数")
    private Integer page = 0;

    @JsonProperty("limit")
    @ApiModelProperty(notes = "分页总数")
    private Integer limit;

    @JsonProperty("sortDirection")
    @ApiModelProperty(notes = "排序方向")
    private Sort.Direction sortDirection = Sort.Direction.ASC;

    @JsonProperty("sortProperties")
    @ApiModelProperty(notes = "排序属性")
    private String sortProperties = "statisticUpdateTime";
}
