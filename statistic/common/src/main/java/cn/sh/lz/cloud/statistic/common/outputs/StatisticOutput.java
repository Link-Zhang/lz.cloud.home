package cn.sh.lz.cloud.statistic.common.outputs;

import cn.sh.lz.cloud.statistic.common.vos.StatisticVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Link at 19:12 on 6/10/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticOutput {
    @JsonProperty("statisticVOList")
    @ApiModelProperty(notes = "统计信息列表", required = true)
    private List<StatisticVO> statisticVOList;
}
