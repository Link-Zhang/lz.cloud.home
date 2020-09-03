package cn.sh.lz.cloud.vcommunity.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 09:35 on 5/31/19.
 */
@Data
public class VCommunityVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "社区ID", example = "5011000004005")
    private BigInteger communityId;

    @JsonProperty("name")
    @ApiModelProperty(notes = "社区名称", position = 1, example = "晶波坊")
    private String communityName;

    @JsonProperty("houseCount")
    @ApiModelProperty(notes = "房屋数量", position = 2, example = "12")
    private BigInteger communityHouseCount;

    @JsonProperty("avgTotalPrice")
    @ApiModelProperty(notes = "平均总价", position = 3, example = "303")
    private Double communityAvgTotalPrice;

    @JsonProperty("avgUnitPrice")
    @ApiModelProperty(notes = "平均单价", position = 4, example = "48130")
    private Double communityAvgUnitPrice;

    @JsonProperty("maxTotalPrice")
    @ApiModelProperty(notes = "最高总价", position = 5, example = "370")
    private Double communityMaxTotalPrice;

    @JsonProperty("maxStructureArea")
    @ApiModelProperty(notes = "最大建筑面积", position = 6, example = "78.87")
    private Double communityMaxStructureArea;

    @JsonProperty("maxDownPayment")
    @ApiModelProperty(notes = "最高首付", position = 7, example = "130")
    private Long communityMaxDownPayment;

    @JsonProperty("minUnitPrice")
    @ApiModelProperty(notes = "最低单价", position = 8, example = "44053")
    private Long communityMinUnitPrice;

    @JsonProperty("minTotalPrice")
    @ApiModelProperty(notes = "最低总价", position = 9, example = "228")
    private Double communityMinTotalPrice;

    @JsonProperty("minStructureArea")
    @ApiModelProperty(notes = "最小建筑面积", position = 10, example = "49.15")
    private Double communityMinStructureArea;

    @JsonProperty("minDownPayment")
    @ApiModelProperty(notes = "最低首付", position = 11, example = "80")
    private Long communityMinDownPayment;

    @JsonProperty("maxUnitPrice")
    @ApiModelProperty(notes = "最高单价", position = 12, example = "53711")
    private Long communityMaxUnitPrice;
}
