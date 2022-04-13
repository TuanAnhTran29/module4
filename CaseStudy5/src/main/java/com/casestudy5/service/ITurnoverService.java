package com.casestudy5.service;

import com.casestudy5.model.Turnover;

import java.util.Optional;

public interface ITurnoverService extends IGeneralService<Turnover> {

    Optional<Turnover> findByUserId(Long id);

    void save(Long uid, Turnover turnover);
}
