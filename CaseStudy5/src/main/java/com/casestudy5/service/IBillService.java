package com.casestudy5.service;

import com.casestudy5.model.Bill;

public interface IBillService extends IGeneralService<Bill> {

    Iterable<Bill> findAllByUserId(Long id);
}
