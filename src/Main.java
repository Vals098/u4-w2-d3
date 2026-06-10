import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Product> products = List.of(
                new Product(1, "Java Book", "Books", 120),
                new Product(2, "Mouse", "Electronics", 30),
                new Product(3, "Spring Boot", "Books", 150),
                new Product(4, "Shadowhunters Book", "Books", 90),
                new Product(5, "Toy Car", "Boys", 30),
                new Product(6, "Premium Cat Dry Food", "Pet Food", 50),
                new Product(7, "Hat", "Boys", 5)
        );


        Customer c1 = new Customer(1, "Giorgio", 3);
        Customer c2 = new Customer(2, "Serena", 1);


        List<Order> orders = List.of(
                new Order(
                        1,
                        "DELIVERED",
                        LocalDate.of(2021, 2, 15),
                        LocalDate.of(2021, 2, 20),
                        List.of(products.get(0), products.get(1)),
                        c2
                )
        );


//        Es 1
//        products.stream().forEach(System.out::println);

        List<Product> CheapBooks = products.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() < 100).toList();
        System.out.println(CheapBooks);

//        Es 2
        List<Order> BabyProducts = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
        System.out.println(BabyProducts);

//        Es 3
//        creando un nuovo oggetto con map()
//        List<Product> BoyProducts = products.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice() * 0.9)).toList();
//        modificando l'oggetto iniziale con setPrice
        List<Product> boyProducts = products.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .toList();

        boyProducts.forEach(product ->
                product.setPrice(product.getPrice() * 0.9)
        );

        System.out.println(BoyProducts);
    }

}
