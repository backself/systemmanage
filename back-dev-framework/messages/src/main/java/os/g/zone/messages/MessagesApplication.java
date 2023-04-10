package os.g.zone.messages;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class MessagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagesApplication.class, args);
    }

}
