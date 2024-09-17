package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void removeProductExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(2, "планшет", 3000);
        Product product3 = new Product(3, "мотоцикл", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductNotExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(2, "планшет", 3000);
        Product product3 = new Product(3, "мотоцикл", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundExeption.class, () -> {
            repo.remove(100);
        });
    }

    @Test
    public void addProductNotExistIdTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "смартфон", 20_000);
        Product product2 = new Product(2, "планшет", 5_000);
        Product product3 = new Product(3, "мотоцикл", 2_000_000);
        Product product4 = new Product(4, "книга", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}