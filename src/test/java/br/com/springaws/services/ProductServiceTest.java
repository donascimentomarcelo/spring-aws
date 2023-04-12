package br.com.springaws.services;

import br.com.springaws.domain.Product;
import br.com.springaws.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

public class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        this.productRepository = mock(ProductRepository.class);
        this.productService = new ProductServiceImpl(this.productRepository);

    }

    @Test
    public void itShouldRetrieveOneProductById() {
        Product builder = buildProduct();

        when(this.productRepository.findById(anyInt())).thenReturn(Optional.of(builder));

        Product product = this.productService.getProduct(1);

        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals(1, product.getVersion());
        Assertions.assertEquals("Fake name", product.getName());
        Assertions.assertEquals("Fake subtitle", product.getSubtitle());
        
        verify(this.productRepository, atLeastOnce()).findById(anyInt());
    }

    @Test
    public void itShouldRetrieveAllProducts() {
        Product builder = buildProduct();

        ArrayList<Product> products = new ArrayList<>();
        products.add(builder);

        when(this.productRepository.findAll()).thenReturn(products);

        List<Product> productList = this.productService.listProducts();

        Assertions.assertEquals(1, productList.get(0).getId());
        Assertions.assertEquals(1, productList.get(0).getVersion());
        Assertions.assertEquals("Fake name", productList.get(0).getName());
        Assertions.assertEquals("Fake subtitle", productList.get(0).getSubtitle());

        verify(this.productRepository, atLeastOnce()).findAll();
    }

    private static Product buildProduct() {
        return Product.builder()
                .id(1)
                .name("Fake name")
                .subtitle("Fake subtitle")
                .version(1)
                .build();
    }
}
