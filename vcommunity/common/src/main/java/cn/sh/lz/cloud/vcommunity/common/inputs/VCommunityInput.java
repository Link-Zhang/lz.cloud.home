package cn.sh.lz.cloud.vcommunity.common.inputs;

import cn.sh.lz.cloud.vcommunity.common.vos.VCommunityFindVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

/**
 * Created by Link at 09:34 on 5/31/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VCommunityInput {
    @ApiModelProperty(notes = "vcommunityFindVO")
    private VCommunityFindVO vcommunityFindVO;

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
    private String sortProperties = "communityId";
}
