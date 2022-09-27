package kz.assel.springcourse.SpringBootApp.repositories;

import kz.assel.springcourse.SpringBootApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
