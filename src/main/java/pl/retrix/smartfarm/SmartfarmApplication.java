package pl.retrix.smartfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//TODO: http://blog.mloza.pl/spring-boot-interakcja-z-baza-danych-czyli-spring-data-jpa/
//TODO: Wszystko angielskie Exception zmienić na polskie

@SpringBootApplication
public class SmartfarmApplication {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartfarmApplication.class, args);
	}

}

