package cn.sh.lz.cloud.history.common.inputs;

import cn.sh.lz.cloud.history.common.vos.HistoryFindVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

/**
 * Created by Link at 14:44 on 5/20/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryInput {
    @ApiModelProperty(notes = "historyFindVO")
    private HistoryFindVO historyFindVO;

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
    private String sortProperties = "historyId";
}
