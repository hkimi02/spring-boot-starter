package iset.gestion.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
@SpringBootApplication
public class SpringCatMvcApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringCatMvcApplication.class, args);
	}
}
