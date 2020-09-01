package cn.sh.lz.cloud.statistic.feign.controller;

import cn.sh.lz.cloud.statistic.clients.StatisticClient;
import cn.sh.lz.cloud.statistic.common.inputs.StatisticInput;
import cn.sh.lz.cloud.statistic.common.outputs.StatisticOutput;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Link at 18:33 on 6/10/19.
 */
@CrossOrigin(origins = "*", allowCredentials = "true")
@RequestMapping("/feign/statistic")
@RestController
public class FeignController {
    private final DiscoveryClient discoveryClient;

    private final StatisticClient statisticClient;

    @Autowired
    public FeignController(DiscoveryClient discoveryClient, StatisticClient statisticClient) {
        this.discoveryClient = discoveryClient;
        this.statisticClient = statisticClient;
    }

    @ApiOperation(value = "统计信息", notes = "获取统计信息")
    @GetMapping(value = "/")
    public StatisticOutput find(StatisticInput statisticInput) {
        return statisticClient.find(statisticInput);
    }

    @ApiOperation(value = "统计微服务测试", notes = "进行统计微服务测试")
    @GetMapping(value = "/hello")
    public String hello() {
        return statisticClient.hello();
    }

    @ApiOperation(value = "统计微服务实例", notes = "获取统计微服务实例")
    @GetMapping(value = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("statistic");
    }
}
