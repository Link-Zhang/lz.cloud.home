package cn.sh.lz.cloud.house;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 15:06 on 4/11/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"cn.sh.lz.cloud.house.clients", "cn.sh.lz.cloud.history.clients"})
@ComponentScan(basePackages = {"cn.sh.lz.cloud.house", "cn.sh.lz.cloud.history"})
public class HouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }
}
