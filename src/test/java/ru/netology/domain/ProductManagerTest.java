package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "book1", 5000, "author1");
    Product product2 = new Book(2, "book2", 1000, "author2");
    Product product3 = new Book(3, "book3", 3000, "author3");
    Product product4 = new Smartphone(4, "smartphone1", 55_000, "manufacturer1");
    Product product5 = new Smartphone(5, "smartphone2", 65_000, "manufacturer2");
    Product product6 = new Smartphone(6, "smartphone3", 95_000, "manufacturer3");


    @BeforeEach
    public void addProduct() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }


    @Test
    public void searchProductOneBook() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("book1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductThreeBook() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductNoBook() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("radio");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductOneSmartphone() {
        Product[] expected = {product4};
        Product[] actual = manager.searchBy("smartphone1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductThreeSmartphone() {
        Product[] expected = {product4, product5, product6};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }

}