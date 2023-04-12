package br.com.springaws.services;

import br.com.springaws.domain.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(final Integer id);
    List<Product> listProducts();
}
