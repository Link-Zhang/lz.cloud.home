package cn.sh.lz.cloud.vcommunity.controllers;

/***
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */

/***
 *  佛曰:
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          不见满街漂亮妹，哪个归得程序员？
 */

/***
 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
 * │Esc│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│| \│~ `│
 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┤
 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ Del │
 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤
 * │ Ctrl │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Return │
 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┬────┤
 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│Shift│ Fn │
 * └─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┴────┘
 *       │ Alt│ ⌘ ◇│                       │◇ ⌘ │ Alt│
 *       └────┴────┴───────────────────────┴────┴────┘
 *
 *                  Happy Hacking Key Board
 */

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
import org.springframework.http.MediaType;
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

    @Autowired
    private VCommunityService vCommunityService;

    @Autowired
    protected HttpServletRequest request;

    @ApiOperation(value = "获取社区", notes = "获取社区(默认10条)")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    VCommunityOutput findAll(VCommunityInput vCommunityInput) {
        Integer size = Optional.ofNullable(vCommunityInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(vCommunityInput.getSortDirection(), vCommunityInput.getSortProperties());
        PageRequest pageRequest = PageRequest.of(vCommunityInput.getPage(), size, sort);
        ConvertUtil<VCommunityFindVO, VCommunityFindDTO> convertUtilIn = new ConvertUtil<>();
        VCommunityFindDTO vCommunityFindDTO = convertUtilIn.convert(vCommunityInput.getVcommunityFindVO(), VCommunityFindDTO.class);
        Page<VCommunity> vCommunityPage = vCommunityService.findAllPaginated(vCommunityFindDTO, pageRequest);
        ConvertUtil<VCommunity, VCommunityVO> convertUtilOut = new ConvertUtil<>();
        List<VCommunityVO> list = convertUtilOut.convert(vCommunityPage.getContent(), VCommunityVO.class);
        return new VCommunityOutput(list);
    }

    @ApiOperation(value = "社区微服务测试", notes = "社区微服务测试")
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }


    @ApiOperation(value = "获取指定ID社区的房屋", notes = "获取指定ID社区的房屋")
    @GetMapping(path = "/{id}/house", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    VCommunityHouseByIdOutput findHouseByCommunityId(@PathVariable("id") BigInteger id) {
        List<House> houseList = vCommunityService.findHouseByCommunityId(id);
        ConvertUtil<House, HouseVO> convertUtil = new ConvertUtil<>();
        List<HouseVO> list = convertUtil.convert(houseList, HouseVO.class);
        return new VCommunityHouseByIdOutput(list);
    }
}
