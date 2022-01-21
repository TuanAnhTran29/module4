package com.service;

import com.model.MedicalDeclaration;

import java.util.ArrayList;
import java.util.List;

public class MedicalDeclarationService implements IMedicalDeclarationService {
    List<MedicalDeclaration> medicalDeclarations= new ArrayList<>();
    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarations;
    }

    @Override
    public void save(MedicalDeclaration song) {
        medicalDeclarations.add(song);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        MedicalDeclaration song= null;
        for (MedicalDeclaration s: medicalDeclarations) {
            if (s.getId() == id){
                song=s;
                break;
            }
        }
        return song;
    }

    @Override
    public void update(int id, MedicalDeclaration song) {
        for (MedicalDeclaration s:medicalDeclarations) {
            if (s.getId() == id) {
                medicalDeclarations.set(medicalDeclarations.indexOf(s),song);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (MedicalDeclaration s: medicalDeclarations) {
            if (s.getId() == id){
                medicalDeclarations.remove(s);
            }
        }
    }
}
