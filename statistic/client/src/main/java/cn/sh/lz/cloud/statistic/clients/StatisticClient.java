package cn.sh.lz.cloud.statistic.clients;

import cn.sh.lz.cloud.statistic.common.inputs.StatisticInput;
import cn.sh.lz.cloud.statistic.common.outputs.StatisticOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Link at 18:37 on 6/10/19.
 */
@FeignClient(name = "statistic", fallback = StatisticClient.StatisticClientFallback.class)
public interface StatisticClient {
    @GetMapping(value = "/api/v1/statistic/")
    StatisticOutput find(StatisticInput statisticInput);

    @GetMapping(value = "/api/v1/statistic/hello")
    String hello();

    @Component
    class StatisticClientFallback implements StatisticClient {
        @Override
        public StatisticOutput find(StatisticInput statisticInput) {
            System.out.println("【statistic微服务中的find服务降级!】");
            return null;
        }

        @Override
        public String hello() {
            System.out.println("【statistic微服务中的hello服务降级!】");
            return null;
        }
    }
}
