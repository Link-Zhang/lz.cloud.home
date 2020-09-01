package cn.sh.lz.cloud.statistic;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 18:30 on 6/10/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = "cn.sh.lz.cloud.statistic.clients")
@ComponentScan(basePackages = {"cn.sh.lz.cloud.statistic"})
public class StatisticApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticApplication.class, args);
    }
}
