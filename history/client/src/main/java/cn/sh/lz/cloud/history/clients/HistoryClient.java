package cn.sh.lz.cloud.history.clients;


import cn.sh.lz.cloud.history.common.inputs.HistoryInput;
import cn.sh.lz.cloud.history.common.outputs.HistoryOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Link at 13:53 on 6/4/19.
 */
@FeignClient(name = "history", fallback = HistoryClient.HistoryClientFallback.class)
public interface HistoryClient {
    @GetMapping(value = "/api/v1/history/")
    HistoryOutput find(HistoryInput historyInput);

    @GetMapping(value = "/api/v1/history/hello")
    String hello();

    @Component
    class HistoryClientFallback implements HistoryClient {
        @Override
        public HistoryOutput find(HistoryInput historyInput) {
            System.out.println("【history微服务中的find服务降级!】");
            return null;
        }

        @Override
        public String hello() {
            System.out.println("【history微服务中的hello服务降级!】");
            return null;
        }
    }
}
