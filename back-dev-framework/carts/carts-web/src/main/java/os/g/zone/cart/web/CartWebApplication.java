package os.g.zone.cart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CartWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartWebApplication.class, args);
	}

}
