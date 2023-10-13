package com.devsuperior.desafio0101;

import com.devsuperior.desafio0101.model.Order;
import com.devsuperior.desafio0101.sevices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio0101Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Desafio0101Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados do pedido");
        System.out.println("Código: ");
        Integer code = sc.nextInt();

        System.out.println("Valor: ");
        double basic = sc.nextDouble();

        System.out.println("Valor do desconto: ");
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);

        double total = orderService.total(order);

        System.out.println("Pedido Código " + code);
        System.out.println("Valor total: R$ " + String.format(Locale.US, "%,.2f", total));

        sc.close();
    }
}
