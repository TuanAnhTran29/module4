package com.casestudy5.repo;

import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICartRepo extends JpaRepository<Cart,Long> {

    Cart findByUserAndProduct(User user, Product product);

    List<Cart> findByUser(User user);

    @Transactional
    @Modifying
    @Query(value = "update cart set quantity= ?1 where id= ?2",nativeQuery = true)
    void updateCart(int quantity, Long id);

    @Query(value = "delete from cart where product_id= ?1", nativeQuery = true)
    void deleteCartByProductId(Long id);
}
