package com.repo.customerrepo;

import com.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepo extends PagingAndSortingRepository<Province,Long> {
}
