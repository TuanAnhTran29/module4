package com.service;

import com.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration song);

    MedicalDeclaration findById(int id);

    void update(int id, MedicalDeclaration song);

    void remove(int id);
}
