package com.gamtcode.ecommercespringbootjpa.config;

import com.gamtcode.ecommercespringbootjpa.entities.*;
import com.gamtcode.ecommercespringbootjpa.entities.enums.OrderStatus;
import com.gamtcode.ecommercespringbootjpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Patterns of Enterprise Application Architecture", "This guide presents over 40 design patterns for enterprise applications, covering key topics with examples in Java and C#.", 100.99, "");
        Product p2 = new Product(null, "Smart TV", "Experience stunning 4K visuals and smart features for an ultimate entertainment experience.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Unleash your productivity with high performance, sleek design, and the best of Apple's software.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Get the edge in your games with high frame rates and ultra settings.", 1200.0, "");
        Product p5 = new Product(null, "The Lord of the Rings", "Immerse yourself in the epic fantasy world of Middle Earth with this classic novel.", 90.5, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Frédéric Chopin", "chopin@gmail.com", "(12) 98888-5555", "1234abcd");
        User u2 = new User(null, "Keiko Matsui", "keiko@gmail.com", "(12) 98888-7777", "1234wxyz");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
