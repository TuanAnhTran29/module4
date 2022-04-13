package com.casestudy5.repo;

import com.casestudy5.dto.custom.CartWithInventoryDTO;
import com.casestudy5.dto.custom.CartWithInventoryDTO1;
import com.casestudy5.dto.custom.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DTORepo extends JpaRepository<CommonEntity, Long> {

    @Query(value = "select cart.id as cartId, cart.quantity as quantity, p.id as productId, p.inventory as productInventory from cart inner join products p on cart.product_id = p.id where ((:cid is null ) or (cart.id= :cid)) and ((:quantity is null ) or (cart.quantity= :quantity))", nativeQuery = true)
    List<CartWithInventoryDTO> getAllCartWithInventory(@Param("cid") Long id, @Param("quantity") Integer quantity);

    @Query("select new com.casestudy5.dto.custom.CartWithInventoryDTO1(c.id,c.quantity,p.id,p.inventory) from Cart c inner join Product p on c.product.id=p.id where ((:cid is null) or (c.id= :cid)) and ((:quantity is null ) or (c.quantity= :quantity))")
    List<CartWithInventoryDTO1> getAll(@Param("cid") Long id, @Param("quantity") Integer quantity);
}
