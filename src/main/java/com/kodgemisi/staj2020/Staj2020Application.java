package com.kodgemisi.staj2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Staj2020Application {

	public static void main(String[] args) {
		SpringApplication.run(Staj2020Application.class, args);
	}

	//CommandLineRunner ile beraber uygulama kalkarken bu dosyaları silip yeniden olusturması sağlanır.
//	@Override
//	public void run(String... args) {
//		fileStorage.deleteAll();
//		fileStorage.init();
//	}

}

