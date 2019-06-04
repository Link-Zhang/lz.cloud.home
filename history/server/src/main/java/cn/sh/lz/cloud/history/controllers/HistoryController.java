package cn.sh.lz.cloud.history.controllers;

import cn.sh.lz.cloud.history.common.dtos.HistoryFindDTO;
import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.inputs.HistoryHouseIdInput;
import cn.sh.lz.cloud.history.common.inputs.HistoryInput;
import cn.sh.lz.cloud.history.common.outputs.HistoryHouseIdOutput;
import cn.sh.lz.cloud.history.common.outputs.HistoryOutput;
import cn.sh.lz.cloud.history.common.utils.ConvertUtil;
import cn.sh.lz.cloud.history.common.vos.HistoryFindVO;
import cn.sh.lz.cloud.history.common.vos.HistoryHouseIdFindVO;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import cn.sh.lz.cloud.history.services.HistoryService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
 * Created by Link at 14:03 on 5/23/19.
 */
@RestController
@RequestMapping(path = "/api/v1/history")
@Api(value = "历史微服务", consumes = "application/json")
public class HistoryController {
    @Value("${cn.sh.lz.cloud.history.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HistoryService historyService;

    @ApiOperation(value = "历史微服务测试", notes = "历史微服务测试")
    @GetMapping(path = "/hello", produces = "application/json")
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }

    @ApiOperation(value = "获取历史价格", notes = "获取历史价格(默认10条)")
    @GetMapping(path = "/", produces = "application/json")
    public @ResponseBody
    HistoryOutput find(HistoryInput historyInput) {
        Integer page = historyInput.getPage();
        Integer size = Optional.ofNullable(historyInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(historyInput.getSortDirection(), historyInput.getSortProperties());
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        ConvertUtil<HistoryFindVO, HistoryFindDTO> convertUtilIn = new ConvertUtil<>();
        HistoryFindDTO historyFindDTO = convertUtilIn.convert(historyInput.getHistoryFindVO(), HistoryFindDTO.class);
        Page<History> historyPage = historyService.findAllPaginated(historyFindDTO, pageRequest);
        ConvertUtil<History, HistoryVO> convertUtilOut = new ConvertUtil<>();
        List<HistoryVO> historyVOList = convertUtilOut.convert(historyPage.getContent(), HistoryVO.class);
        return new HistoryOutput(historyVOList);
    }

    @ApiOperation(value = "获取历史价格表中的房屋ID", notes = "获取历史价格表中的房屋ID(默认10条)")
    @GetMapping(path = "/houseId", produces = "application/json")
    public @ResponseBody
    HistoryHouseIdOutput findHouseId(HistoryHouseIdInput historyHouseIdInput) {
        Integer page = historyHouseIdInput.getPage();
        Integer size = Optional.ofNullable(historyHouseIdInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = new Sort(historyHouseIdInput.getSortDirection(), historyHouseIdInput.getSortProperties());
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        ConvertUtil<HistoryHouseIdFindVO, HistoryFindDTO> convertUtilIn = new ConvertUtil<>();
        HistoryFindDTO historyFindDTO = convertUtilIn.convert(historyHouseIdInput.getHistoryHouseIdFindVO(), HistoryFindDTO.class);
        Page<History> historyPage = historyService.findAllPaginated(historyFindDTO, pageRequest);
        List<History> historyList = historyPage.getContent();
        List<BigInteger> list = historyList.parallelStream().map(History::getHistoryHouseId).distinct().collect(Collectors.toList());
        return new HistoryHouseIdOutput(list);
    }

    @ApiOperation(value = "获取指定ID的历史价格", notes = "获取指定ID的历史价格")
    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody
    HistoryOutput findByHistoryId(@PathVariable BigInteger id) {
        Optional<History> historyOptional = historyService.findByHistoryId(id);
        ConvertUtil<History, HistoryVO> convertUtilOut = new ConvertUtil<>();
        List<HistoryVO> list = new ArrayList<>();
        if (historyOptional.isPresent()) {
            HistoryVO historyVO = convertUtilOut.convert(historyOptional.get(), HistoryVO.class);
            list.add(historyVO);
        }
        return new HistoryOutput(list);
    }
}