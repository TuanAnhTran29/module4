package com.casestudy5.service.serviceDTO;

import com.casestudy5.dto.custom.CartWithInventoryDTO;
import com.casestudy5.dto.custom.CartWithInventoryDTO1;
import com.casestudy5.repo.DTORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDTO implements IServiceDTO{

    @Autowired
    private DTORepo dtoRepo;

    @Override
    public List<CartWithInventoryDTO> getAllCartWithInventory(Long id,Integer quantity) {
        return dtoRepo.getAllCartWithInventory(id,quantity);
    }

    @Override
    public List<CartWithInventoryDTO1> findAll(Long id,Integer quantity) {
        return dtoRepo.getAll(id,quantity);
    }


}
