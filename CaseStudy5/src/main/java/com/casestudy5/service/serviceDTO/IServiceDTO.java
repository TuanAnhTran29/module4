package com.casestudy5.service.serviceDTO;

import com.casestudy5.dto.custom.CartWithInventoryDTO;
import com.casestudy5.dto.custom.CartWithInventoryDTO1;

import java.util.List;

public interface IServiceDTO {
    List<CartWithInventoryDTO> getAllCartWithInventory(Long id,Integer quantity);

    List<CartWithInventoryDTO1> findAll(Long id,Integer quantity);
}
