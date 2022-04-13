package com.casestudy5.repo;

import com.casestudy5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {

    Boolean existsByName(String name);

    @Query(value = "select * from products inner join product_category pc on products.id = pc.product_id inner join categories c on pc.category_id = c.id where products.id= ?1", nativeQuery = true)
    Optional<Product> findProductAndCategoryById(Long id);

    @Query(value = "select * from products where status= 'Selling'",nativeQuery = true)
    Iterable<Product> findAllProduct();

    @Query(value = "select * from products where name like %?1% and status = 'selling'", nativeQuery = true)
    List<Product> findAllProductByName(String name);
}
