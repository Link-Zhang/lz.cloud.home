package cn.sh.lz.cloud.house.common.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 16:37 on 4/12/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel()
@Table(name = "house")
public class House {
    @Id
    @Column(nullable = false, name = "house_id")
    @ApiModelProperty(notes = "房屋ID", example = "107102472292", required = true)
    private BigInteger houseId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "浦东", required = true)
    private String houseDistrict;

    @Column(nullable = false, name = "house_community_name")
    @ApiModelProperty(notes = "小区名称", position = 2, example = "晶波坊", required = true)
    private String houseCommunityName;

    @Column(nullable = false, name = "house_structure_area")
    @ApiModelProperty(notes = "建筑面积", position = 3, example = "78.7", required = true)
    private Double houseStructureArea;

    @Column(nullable = false, name = "house_total_price")
    @ApiModelProperty(notes = "房屋总价", position = 4, example = "370", required = true)
    private Double houseTotalPrice;

    @Column(nullable = false, name = "house_down_payment")
    @ApiModelProperty(notes = "房屋首付", position = 5, example = "130", required = true)
    private Long houseDownPayment;

    @Column(nullable = false, name = "house_unit_price")
    @ApiModelProperty(notes = "房屋单价", position = 6, example = "47014", required = true)
    private Long houseUnitPrice;

    @Column(nullable = false, name = "house_type")
    @ApiModelProperty(notes = "房屋户型", position = 7, example = "3室2厅", required = true)
    private String houseType;

    @Column(nullable = false, name = "house_url")
    @ApiModelProperty(notes = "房屋URL", position = 8, example = "https://m.ke.com/sh/ershoufang/107102472292.html", required = true)
    private String houseUrl;

    @Column(nullable = false, name = "house_community_id")
    @ApiModelProperty(notes = "小区ID", position = 9, example = "5011000004005", required = true)
    private BigInteger houseCommunityId;

    @Column(nullable = false, name = "house_state")
    @ApiModelProperty(notes = "房屋状态", position = 10, example = "已更新", required = true)
    private String houseState;

    @Column(nullable = false, name = "first_update")
    @ApiModelProperty(notes = "首次更新时间", position = 11, example = "2020-09-01 17:32:18", required = true)
    private Date firstUpdate;

    @Column(nullable = false, name = "last_update")
    @ApiModelProperty(notes = "上次更新时间", position = 12, example = "2019-04-11 01:37:34", required = true)
    private Date lastUpdate;
}
