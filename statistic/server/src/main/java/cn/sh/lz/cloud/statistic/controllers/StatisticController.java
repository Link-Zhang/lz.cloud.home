package cn.sh.lz.cloud.statistic.controllers;

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

import cn.sh.lz.cloud.statistic.common.dtos.StatisticDTO;
import cn.sh.lz.cloud.statistic.common.entities.Statistic;
import cn.sh.lz.cloud.statistic.common.inputs.StatisticInput;
import cn.sh.lz.cloud.statistic.common.outputs.StatisticOutput;
import cn.sh.lz.cloud.statistic.common.utils.ConvertUtil;
import cn.sh.lz.cloud.statistic.common.vos.StatisticFindVO;
import cn.sh.lz.cloud.statistic.common.vos.StatisticVO;
import cn.sh.lz.cloud.statistic.services.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 18:30 on 6/10/19.
 */
@RestController
@RequestMapping(path = "/api/v1/statistic")
@Api(value = "统计微服务", consumes = "application/json")
public class StatisticController {
    @Value("${cn.sh.lz.cloud.statistic.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private StatisticService statisticService;

    @ApiOperation(value = "获取统计", notes = "获取统计(默认10条)")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    StatisticOutput find(StatisticInput statisticInput) {
        Integer size = Optional.ofNullable(statisticInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = Sort.by(statisticInput.getSortDirection(), statisticInput.getSortProperties());
        ConvertUtil<StatisticFindVO, StatisticDTO> convertUtilIn = new ConvertUtil<>();
        StatisticDTO statisticDTO = convertUtilIn.convert(statisticInput.getStatisticFindVO(), StatisticDTO.class);
        Page<Statistic> statisticPage = statisticService.findAllPaginated(statisticDTO, PageRequest.of(statisticInput.getPage(), size, sort));
        ConvertUtil<Statistic, StatisticVO> convertUtilOut = new ConvertUtil<>();
        List<StatisticVO> list = convertUtilOut.convert(statisticPage.getContent(), StatisticVO.class);
        return new StatisticOutput(list);
    }

    @ApiOperation(value = "统计微服务测试", notes = "统计微服务测试")
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }
}
