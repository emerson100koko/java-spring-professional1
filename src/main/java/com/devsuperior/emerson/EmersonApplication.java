package com.devsuperior.emerson;


import Services.OrderService;
import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class EmersonApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(EmersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTRADA (dados do pedido: codigo, valor basico, porcemtagem de desconto");
		System.out.println();
		Integer code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println();
		System.out.println("Pedido Codigo " + order.getCode() + "\nValor total: R$"
				+ String.format("%.2f", orderService.total(order)));
	}
}
