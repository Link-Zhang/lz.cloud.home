package cn.sh.lz.cloud.history.common.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 13:49 on 5/20/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ApiModel()
@Table(name = "history")
public class History {
    @javax.persistence.Id
    @Column(nullable = false, name = "id")
    @ApiModelProperty(notes = "历史ID", example = "5", required = true)
    private BigInteger historyId;

    @Column(nullable = false, name = "house_id")
    @ApiModelProperty(notes = "房屋ID", position = 1, example = "107102760430", required = true)
    private BigInteger historyHouseId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(notes = "市辖区", position = 2, example = "浦东", required = true)
    private String historyHouseDistrict;

    @Column(nullable = false, name = "house_url")
    @ApiModelProperty(notes = "房屋URL", position = 3, example = "https://m.ke.com/sh/ershoufang/107102760430.html", required = true)
    private String historyHouseUrl;

    @Column(nullable = false, name = "old_house_total_price")
    @ApiModelProperty(notes = "原房屋总价", position = 4, example = "300", required = true)
    private Double historyOldHouseTotalPrice;

    @Column(nullable = false, name = "old_house_down_payment")
    @ApiModelProperty(notes = "原房屋首付", position = 5, example = "105", required = true)
    private Long historyOldHouseDownPayment;

    @Column(nullable = false, name = "old_house_unit_price")
    @ApiModelProperty(notes = "原房屋单价", position = 6, example = "37903", required = true)
    private Long historyOldHouseUnitPrice;

    @Column(nullable = false, name = "new_house_total_price")
    @ApiModelProperty(notes = "新房屋总价", position = 7, example = "298", required = true)
    private Double historyNewHouseTotalPrice;

    @Column(nullable = false, name = "new_house_down_payment")
    @ApiModelProperty(notes = "新房屋首付", position = 8, example = "105", required = true)
    private Long historyNewHouseDownPayment;

    @Column(nullable = false, name = "new_house_unit_price")
    @ApiModelProperty(notes = "新房屋单价", position = 9, example = "37651", required = true)
    private Long historyNewHouseUnitPrice;

    @Column(nullable = false, name = "update_time")
    @ApiModelProperty(notes = "更新时间", position = 10, example = "2020-09-01 12:00:00", required = true)
    private Date historyUpdateTime;
}
