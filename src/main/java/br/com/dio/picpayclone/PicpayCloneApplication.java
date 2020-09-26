package br.com.dio.picpayclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PicpayCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayCloneApplication.class, args);
	}

}
