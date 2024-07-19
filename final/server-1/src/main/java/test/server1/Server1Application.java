package test.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server1Application {

	public static void main(String[] args) {
		SpringApplication.run(Server1Application.class, args);
	}

}
