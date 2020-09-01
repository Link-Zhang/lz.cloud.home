package cn.sh.lz.cloud.vcommunity.controllers;

import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.vos.HouseVO;
import cn.sh.lz.cloud.vcommunity.common.dtos.VCommunityFindDTO;
import cn.sh.lz.cloud.vcommunity.common.entities.VCommunity;
import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityInput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityHouseByIdOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityOutput;
import cn.sh.lz.cloud.vcommunity.common.utils.ConvertUtil;
import cn.sh.lz.cloud.vcommunity.common.vos.VCommunityFindVO;
import cn.sh.lz.cloud.vcommunity.common.vos.VCommunityVO;
import cn.sh.lz.cloud.vcommunity.services.VCommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 17:19 on 5/30/19.
 */
@RestController
@RequestMapping(path = "/api/v1/vcommunity")
@Api(value = "社区微服务", consumes = "application/json")
public class VCommunityController {
    @Value("${cn.sh.lz.cloud.vcommunity.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    private final VCommunityService vCommunityService;

    private final HttpServletRequest request;

    @Autowired
    public VCommunityController(VCommunityService vCommunityService, HttpServletRequest request) {
        this.vCommunityService = vCommunityService;
        this.request = request;
    }

    @ApiOperation(value = "获取社区", notes = "获取社区(默认10条)")
    @GetMapping(path = "/")
    public @ResponseBody
    VCommunityOutput findAll(VCommunityInput vCommunityInput) {
        Integer size = Optional.ofNullable(vCommunityInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = Sort.by(vCommunityInput.getSortDirection(), vCommunityInput.getSortProperties());
        PageRequest pageRequest = PageRequest.of(vCommunityInput.getPage(), size, sort);
        ConvertUtil<VCommunityFindVO, VCommunityFindDTO> convertUtilIn = new ConvertUtil<>();
        VCommunityFindDTO vCommunityFindDTO = convertUtilIn.convert(vCommunityInput.getVcommunityFindVO(), VCommunityFindDTO.class);
        Page<VCommunity> vCommunityPage = vCommunityService.findAllPaginated(vCommunityFindDTO, pageRequest);
        ConvertUtil<VCommunity, VCommunityVO> convertUtilOut = new ConvertUtil<>();
        List<VCommunityVO> list = convertUtilOut.convert(vCommunityPage.getContent(), VCommunityVO.class);
        return new VCommunityOutput(list);
    }

    @ApiOperation(value = "社区微服务测试", notes = "社区微服务测试")
    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }

    @ApiOperation(value = "获取指定ID社区的房屋", notes = "获取指定ID社区的房屋")
    @GetMapping(path = "/{id}/house")
    public @ResponseBody
    VCommunityHouseByIdOutput findHouseByCommunityId(@PathVariable("id") BigInteger id) {
        List<House> houseList = vCommunityService.findHouseByCommunityId(id);
        ConvertUtil<House, HouseVO> convertUtil = new ConvertUtil<>();
        List<HouseVO> list = convertUtil.convert(houseList, HouseVO.class);
        return new VCommunityHouseByIdOutput(list);
    }
}
