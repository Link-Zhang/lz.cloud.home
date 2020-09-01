package cn.sh.lz.cloud.statistic.common.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Link at 09:58 on 4/12/19.
 */
@Data
public class StatisticFindVO {
    @JsonProperty("statisticHouseDistrict")
    @ApiModelProperty(notes = "市辖区", example = "上海")
    private String statisticHouseDistrict = "上海";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("startUpdateTime")
    @ApiModelProperty(notes = "开始时间", example = "2020-01-01")
    private Date startUpdateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("endUpdateTime")
    @ApiModelProperty(notes = "终止时间", example = "2020-12-31")
    private Date endUpdateTime;
}
