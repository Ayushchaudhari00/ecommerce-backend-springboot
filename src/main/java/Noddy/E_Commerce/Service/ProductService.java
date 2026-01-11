package Noddy.E_Commerce.Service;

import Noddy.E_Commerce.Entity.Product;
import Noddy.E_Commerce.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
    public Product updateProduct(Long id, Product newData) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(newData.getName());
        product.setPrice(newData.getPrice());
        product.setStock(newData.getStock());
        product.setImageUrl(newData.getImageUrl());

        return productRepo.save(product);
    }
}
