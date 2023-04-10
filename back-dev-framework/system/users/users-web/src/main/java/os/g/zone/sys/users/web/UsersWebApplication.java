package os.g.zone.sys.users.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class UsersWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersWebApplication.class, args);
    }

}
