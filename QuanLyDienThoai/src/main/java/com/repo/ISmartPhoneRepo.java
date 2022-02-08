package com.repo;

import com.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepo extends JpaRepository<SmartPhone,Long> {
}
