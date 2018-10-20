package guru.springframework.repositories;

import guru.springframework.domain.GoodsSource;
import guru.springframework.domain.Order;
import guru.springframework.domain.Product;
import guru.springframework.domain.SalesMan;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GoodsSourceRepository extends CrudRepository<GoodsSource, Integer>{
}
