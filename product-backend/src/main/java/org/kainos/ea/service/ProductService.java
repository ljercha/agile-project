package org.kainos.ea.service;

import org.kainos.ea.exception.*;
import org.kainos.ea.model.Product;
import org.kainos.ea.model.ProductRequest;
import org.kainos.ea.db.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductDao productDao = new ProductDao();
    private final ProductValidator productValidator = new ProductValidator();

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product createProduct(ProductRequest product) throws FailedToCreateProductException, InvalidProductException {
        try {
            String validation = productValidator.isValidProduct(product);

            if (validation != null) {
                throw new InvalidProductException(validation);
            }

            Optional<Product> createdProduct = productDao.createProduct(product);

            return createdProduct.orElseThrow(FailedToCreateProductException::new);
        } catch (SQLException e) {
            logger.error("SQL exception! Error: {}", e.getMessage());

            throw new FailedToCreateProductException();
        }
    }

    public List<Product> getAllProducts() throws FailedToGetProductsException {
        try {
            List<Product> productList = productDao.getAllProducts();

            return productList;
        } catch (SQLException e) {
            logger.error("SQL exception! Error: {}", e.getMessage());

            throw new FailedToGetProductsException();
        }
    }

    public Product getProductById(int id) throws FailedToGetProductException, ProductDoesNotExistException {
        try {
            Product product = productDao.getProductById(id);

            if (product == null) {
                throw new ProductDoesNotExistException();
            }

            return product;
        } catch (SQLException e) {
            logger.error("SQL exception! Error: {}", e.getMessage());

            throw new FailedToGetProductException();
        }
    }
}
