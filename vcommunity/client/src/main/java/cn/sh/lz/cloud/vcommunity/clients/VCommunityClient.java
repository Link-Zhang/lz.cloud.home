package cn.sh.lz.cloud.vcommunity.clients;

import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityInput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityHouseByIdOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

/**
 * Created by Link at 09:24 on 6/4/19.
 */
@FeignClient(name = "vcommunity", fallback = VCommunityClient.VCommunityClientFallback.class)
public interface VCommunityClient {
    @GetMapping(value = "/api/v1/vcommunity/")
    VCommunityOutput findAll(VCommunityInput vCommunityInput);

    @GetMapping(value = "/api/v1/vcommunity/hello")
    String hello();

    @GetMapping(value = "/api/v1/vcommunity/{id}/house")
    VCommunityHouseByIdOutput findHouseByCommunityId(@PathVariable("id") BigInteger id);

    @Component
    class VCommunityClientFallback implements VCommunityClient {
        @Override
        public VCommunityOutput findAll(VCommunityInput vCommunityInput) {
            System.out.println("【vcommunity微服务中的findAll服务降级!】");
            return null;
        }

        @Override
        public String hello() {
            System.out.println("【vcommunity微服务中的hello服务降级!】");
            return null;
        }

        @Override
        public VCommunityHouseByIdOutput findHouseByCommunityId(BigInteger id) {
            System.out.println("【vcommunity微服务中的findHouseByCommunityId服务降级!】");
            return null;
        }
    }
}
