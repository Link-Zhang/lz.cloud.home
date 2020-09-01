package cn.sh.lz.cloud.history.common.outputs;

import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Link at 14:47 on 5/20/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryOutput {
    @JsonProperty("historyVOList")
    @ApiModelProperty(notes = "历史列表", required = true)
    private List<HistoryVO> historyVOList;
}
