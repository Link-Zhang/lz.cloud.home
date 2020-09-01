package cn.sh.lz.cloud.vcommunity.common.outputs;

import cn.sh.lz.cloud.vcommunity.common.vos.VCommunityVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Link at 10:50 on 5/31/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VCommunityOutput {
    @JsonProperty("vcommunityVOList")
    @ApiModelProperty(notes = "社区列表", required = true)
    private List<VCommunityVO> vcommunityVOList;
}
