package cn.sh.lz.cloud.house.clients;

import cn.sh.lz.cloud.house.common.inputs.HouseInput;
import cn.sh.lz.cloud.house.common.outputs.HouseHistoryByIdOutput;
import cn.sh.lz.cloud.house.common.outputs.HouseOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

/**
 * Created by Link at 14:44 on 6/4/19.
 */
@FeignClient(name = "house", fallback = HouseClient.HouseClientFallback.class)
public interface HouseClient {
    @GetMapping(value = "/api/v1/house/")
    HouseOutput find(HouseInput houseInput);

    @GetMapping(value = "/api/v1/house/hello")
    String hello();

    @GetMapping(value = "/api/v1/house/{id}/history")
    HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id);

    @Component
    class HouseClientFallback implements HouseClient {
        @Override
        public HouseOutput find(HouseInput houseInput) {
            System.out.println("【house微服务中的find服务降级!】");
            return null;
        }

        @Override
        public String hello() {
            System.out.println("【house微服务中的hello服务降级!】");
            return null;
        }

        @Override
        public HouseHistoryByIdOutput findHistoryByHouseId(BigInteger id) {
            System.out.println("【house微服务中的findHistoryByHouseId服务降级!】");
            return null;
        }
    }
}
