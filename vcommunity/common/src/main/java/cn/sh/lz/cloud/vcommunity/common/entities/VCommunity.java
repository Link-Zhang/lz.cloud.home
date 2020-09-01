package cn.sh.lz.cloud.vcommunity.common.entities;

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

/**
 * Created by Link at 16:36 on 5/30/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel()
@Table(name = "vcommunity")
public class VCommunity {
    @Id
    @Column(nullable = false, name = "community_id")
    @ApiModelProperty(notes = "The View Community ID", example = "5011000004005", required = true)
    private BigInteger communityId;

    @Column(nullable = false, name = "community_district")
    @ApiModelProperty(notes = "The View Community District", position = 1, example = "浦东", required = true)
    private String communityDistrict;

    @Column(nullable = false, name = "community_name")
    @ApiModelProperty(notes = "The View Community Name", position = 2, example = "晶波坊", required = true)
    private String communityName;

    @Column(nullable = false, name = "community_house_count")
    @ApiModelProperty(notes = "The View Community House Count", position = 3, example = "12", required = true)
    private BigInteger communityHouseCount;

    @Column(nullable = false, name = "community_avg_total_price ")
    @ApiModelProperty(notes = "The View Community House Avg Total Price", position = 4, example = "303", required = true)
    private Double communityAvgTotalPrice;

    @Column(nullable = false, name = "community_avg_unit_price ")
    @ApiModelProperty(notes = "The View Community House Avg Unit Price", position = 5, example = "48130", required = true)
    private Double communityAvgUnitPrice;

    @Column(nullable = false, name = "community_max_total_price ")
    @ApiModelProperty(notes = "The View Community House Max Total Price", position = 6, example = "370", required = true)
    private Double communityMaxTotalPrice;

    @Column(nullable = false, name = "community_max_structure_area ")
    @ApiModelProperty(notes = "The View Community House Max Structure Area", position = 7, example = "78.87", required = true)
    private Double communityMaxStructureArea;

    @Column(nullable = false, name = "community_max_down_payment ")
    @ApiModelProperty(notes = "The View Community House Max Down Payment", position = 8, example = "130", required = true)
    private Long communityMaxDownPayment;

    @Column(nullable = false, name = "community_min_unit_price ")
    @ApiModelProperty(notes = "The View Community House Min Unit Price", position = 9, example = "44053", required = true)
    private Long communityMinUnitPrice;

    @Column(nullable = false, name = "community_min_total_price ")
    @ApiModelProperty(notes = "The View Community House Min Total Price", position = 10, example = "228", required = true)
    private Double communityMinTotalPrice;

    @Column(nullable = false, name = "community_min_structure_area ")
    @ApiModelProperty(notes = "The View Community House Min Structure Area", position = 11, example = "49.15", required = true)
    private Double communityMinStructureArea;

    @Column(nullable = false, name = "community_min_down_payment ")
    @ApiModelProperty(notes = "The View Community House Min Down Payment", position = 12, example = "80", required = true)
    private Long communityMinDownPayment;

    @Column(nullable = false, name = "community_max_unit_price ")
    @ApiModelProperty(notes = "The View Community House Max Unit Price", position = 13, example = "53711", required = true)
    private Long communityMaxUnitPrice;
}
