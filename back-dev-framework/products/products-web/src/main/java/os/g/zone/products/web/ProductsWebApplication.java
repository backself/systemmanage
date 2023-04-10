package os.g.zone.products.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableDubbo
public class ProductsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsWebApplication.class, args);
	}

}
