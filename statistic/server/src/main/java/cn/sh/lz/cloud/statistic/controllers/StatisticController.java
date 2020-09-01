package cn.sh.lz.cloud.statistic.controllers;

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

    private final HttpServletRequest request;

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(HttpServletRequest request, StatisticService statisticService) {
        this.request = request;
        this.statisticService = statisticService;
    }

    @ApiOperation(value = "获取统计", notes = "获取统计(默认10条)")
    @GetMapping(path = "/")
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
    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }
}
