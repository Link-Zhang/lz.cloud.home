package cn.sh.lz.cloud.history;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 13:37 on 5/20/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "cn.sh.lz.cloud.history.clients")
@ComponentScan(basePackages = {"cn.sh.lz.cloud.history"})
public class HistoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoryApplication.class, args);
    }
}
