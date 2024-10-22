package org.generation.itly.esempiCorso.Collecting;

import java.util.ArrayList;
import java.util.List;

public class Iteration {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("farina", 3));
        products.add(new Product("cock", 3));
        products.add(new Product("piselli", 4));
        System.out.println(products.size());

        Product product = products.get(2);

    }
}
