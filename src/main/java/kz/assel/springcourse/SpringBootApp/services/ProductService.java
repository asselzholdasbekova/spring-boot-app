package kz.assel.springcourse.SpringBootApp.services;

import kz.assel.springcourse.SpringBootApp.models.Product;
import kz.assel.springcourse.SpringBootApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    public final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(int id){
        Optional<Product> product =  productRepository.findById(id);

        return product.orElse(null);
    }

    @Transactional
    public void add(Product product){
        productRepository.save(product);
    }

    @Transactional
    public void delete(int id){
        productRepository.deleteById(id);
    }
}
