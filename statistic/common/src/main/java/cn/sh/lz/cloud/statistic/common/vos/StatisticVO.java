package cn.sh.lz.cloud.statistic.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


/**
 * Created by Link at 17:22 on 5/20/19.
 */
@Data
public class StatisticVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "统计ID", example = "1")
    private BigInteger statisticId;

    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "上海")
    private String statisticHouseDistrict;

    @JsonProperty("avgTotalPrice")
    @ApiModelProperty(notes = "房屋平均总价", position = 2, example = "266.96")
    private Double statisticHouseAvgTotalPrice;

    @JsonProperty("avgUnitPrice")
    @ApiModelProperty(notes = "房屋平均单价", position = 3, example = "45834")
    private BigInteger statisticHouseAvgUnitPrice;

    @JsonProperty("saleCount")
    @ApiModelProperty(notes = "在售房屋数量", position = 4, example = "23762")
    private BigInteger statisticHouseSaleCount;

    @JsonProperty("updateTime")
    @ApiModelProperty(notes = "更新时间", position = 5, example = "2020-09-01 23:30:00")
    private Date statisticUpdateTime;
}
