package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import guru.springframework.domain.Product;

public interface ProfitJpaSpecificationExecutor extends  JpaSpecificationExecutor<Product>,JpaRepository<Product, Integer> {

}
