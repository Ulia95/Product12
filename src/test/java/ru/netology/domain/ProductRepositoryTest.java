package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product product1 = new Book(1, "book1", 5000, "author1");
    Product product2 = new Book(2, "book2", 1000, "author2");
    Product product3 = new Book(3, "book3", 3000, "author3");
    Product product4 = new Smartphone(4, "smartphone1", 55_000, "manufacturer1");
    Product product5 = new Smartphone(5, "smartphone2", 65_000, "manufacturer2");
    Product product6 = new Smartphone(6, "smartphone3", 95_000, "manufacturer3");

    @Test
    public void shouldSaveProducts() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findOneProduct() {

        repo.save(product2);
        Product[] expected = {product2,};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemovedById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.removeById(3);

        Product[] expected = {product1, product2, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void Test4() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Assertions.assertThrows(NotFoundException.class,() -> {
            repo.removeById(10);
        });

    }

}
