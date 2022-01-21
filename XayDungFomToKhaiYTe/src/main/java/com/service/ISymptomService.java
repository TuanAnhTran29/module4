package com.service;

import com.model.MedicalDeclaration;
import com.model.Symptom;

import java.util.List;

public interface ISymptomService {
    List<Symptom> findAll();

    void save(Symptom song);

    Symptom findById(int id);

    void update(int id, Symptom song);

    void remove(int id);
}
