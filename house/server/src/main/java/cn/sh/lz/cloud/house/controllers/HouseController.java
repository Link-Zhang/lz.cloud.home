package cn.sh.lz.cloud.house.controllers;

import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.inputs.HouseInput;
import cn.sh.lz.cloud.house.common.outputs.HouseHistoryByIdOutput;
import cn.sh.lz.cloud.house.common.outputs.HouseOutput;
import cn.sh.lz.cloud.house.common.utils.ConvertUtil;
import cn.sh.lz.cloud.house.common.vos.HouseFindVO;
import cn.sh.lz.cloud.house.common.vos.HouseVO;
import cn.sh.lz.cloud.house.services.HouseService;
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

/**
 * Created by Link at 15:22 on 4/11/19.
 */
@RestController
@RequestMapping(path = "/api/v1/house")
@Api(value = "房屋微服务", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HouseController {
    @Value("${cn.sh.lz.cloud.house.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation(value = "获取房屋", notes = "获取房屋(默认10条)")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseOutput find(HouseInput houseInput) {
        Integer size = Optional.ofNullable(houseInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(houseInput.getSortDirection(), houseInput.getSortProperties());
        ConvertUtil<HouseFindVO, HouseDTO> convertUtilIn = new ConvertUtil<>();
        HouseDTO houseDTO = convertUtilIn.convert(houseInput.getHouseFindVO(), HouseDTO.class);
        Page<House> housePage = houseService.findAllPaginated(houseDTO, PageRequest.of(houseInput.getPage(), size, sort));
        ConvertUtil<House, HouseVO> convertUtilOut = new ConvertUtil<>();
        List<HouseVO> list = convertUtilOut.convert(housePage.getContent(), HouseVO.class);
        return new HouseOutput(list);
    }

    @ApiOperation(value = "房屋微服务测试", notes = "房屋微服务测试")
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }

    @ApiOperation(value = "获取指定ID房屋的历史价格", notes = "获取指定ID房屋的历史价格")
    @GetMapping(path = "/{id}/history", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id) {
        List<History> historyList = houseService.findHistoryByHouseId(id);
        ConvertUtil<History, HistoryVO> convertUtil = new ConvertUtil<>();
        List<HistoryVO> list = convertUtil.convert(historyList, HistoryVO.class);
        return new HouseHistoryByIdOutput(list);
    }
}
