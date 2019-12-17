package org.javastart.zajecia232.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @GetMapping("/test")
    public String getTemplate(Model model) {
        User user = new User("Marcin", "ABC");
        model.addAttribute("example", "To jest przykładowy teskt");
        model.addAttribute("user", user);
        model.addAttribute("number", ThreadLocalRandom.current().nextInt(-5, 5));

        List<User> numbers = Stream.iterate(0, number -> number + 1)
            .limit(10)
            .map(number -> new User("Imie: " + number.toString(), "Nazwisko: " +  number.toString()))
            .collect(Collectors.toList());
        model.addAttribute("list", numbers);
        return "hello";
    }

    public class User {

        private String firstName;
        private String lastName;

        public User(final String firstName, final String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(final String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(final String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
        }
    }

    public static void main(String[] args) {
        final List<Product> products = List.of(new Product(11.0), new Product(12.0));
        final double sum = products.stream()
            .mapToDouble(Product::getPrice)
            .sum();
    }

    public static class Product {

        private double price;

        public Product(final double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(final double price) {
            this.price = price;
        }
    }
}
