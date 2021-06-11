package com.zyb.cbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * javadoc CbcApplication
 * <p>
 *     call back center
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 4:31 PM
 * @version 1.0.0
 **/
@SpringBootApplication
@EnableAsync
public class CbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbcApplication.class, args);
	}

}
