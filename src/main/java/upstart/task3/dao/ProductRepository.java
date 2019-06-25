package upstart.task3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import upstart.task3.domain.Product;
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

}
