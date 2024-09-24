package com.mubeendev3.OnlineBankingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

//@SpringBootApplication
public class OnlineBankingSystemApplication {

	public static void main(String[] args) {
//		SpringApplication.run(OnlineBankingSystemApplication.class, args);
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		List<String> names = List.of("Mubeen", "Mateen", "Ali");

		List<String> namesWithPrefix = names.stream().map(n -> "Mr. " + n).toList();
		namesWithPrefix.forEach(System.out::println);

//		Stream<String> result = numbers.stream().map(n -> n % 2 == 0 ? n + " Even Number" : n + " Odd Number");
//		result.forEach(System.out::println);
	}

}
