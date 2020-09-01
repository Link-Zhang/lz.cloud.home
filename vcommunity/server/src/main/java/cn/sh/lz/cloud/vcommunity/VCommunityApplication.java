package cn.sh.lz.cloud.vcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 17:17 on 5/30/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"cn.sh.lz.cloud.vcommunity.clients", "cn.sh.lz.cloud.house.clients"})
@ComponentScan(basePackages = {"cn.sh.lz.cloud.vcommunity", "cn.sh.lz.cloud.house"})
public class VCommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(VCommunityApplication.class, args);
    }
}
