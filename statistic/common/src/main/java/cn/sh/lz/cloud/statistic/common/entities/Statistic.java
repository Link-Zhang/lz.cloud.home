package cn.sh.lz.cloud.statistic.common.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 18:58 on 6/10/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ApiModel()
@Table(name = "statistic")
public class Statistic {
    @javax.persistence.Id
    @Column(nullable = false, name = "id")
    @ApiModelProperty(notes = "统计ID", example = "1", required = true)
    private BigInteger statisticId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "上海", required = true)
    private String statisticHouseDistrict;

    @Column(nullable = false, name = "house_avg_total_price")
    @ApiModelProperty(notes = "房屋平均总价", position = 2, example = "266.96", required = true)
    private Double statisticHouseAvgTotalPrice;

    @Column(nullable = false, name = "house_avg_unit_price")
    @ApiModelProperty(notes = "房屋平均单价", position = 3, example = "45834", required = true)
    private BigInteger statisticHouseAvgUnitPrice;

    @Column(nullable = false, name = "house_sale_count")
    @ApiModelProperty(notes = "在售房屋数量", position = 4, example = "23762", required = true)
    private BigInteger statisticHouseSaleCount;

    @Column(nullable = false, name = "update_time")
    @ApiModelProperty(notes = "更新时间", position = 5, example = "2020-09-01 23:30:00", required = true)
    private Date statisticUpdateTime;
}
