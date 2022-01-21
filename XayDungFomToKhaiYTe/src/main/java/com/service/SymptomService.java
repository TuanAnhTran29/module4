package com.service;

import com.model.MedicalDeclaration;
import com.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomService implements ISymptomService {
    static final List<Symptom> symptoms= new ArrayList<>();

    static {
        symptoms.add(new Symptom("Sốt"));
        symptoms.add(new Symptom("Ho"));
        symptoms.add(new Symptom("Khó thở"));
        symptoms.add(new Symptom("Đau họng"));
        symptoms.add(new Symptom("Nôn/buồn nôn"));
        symptoms.add(new Symptom("Tiêu chảy"));
        symptoms.add(new Symptom("Xuất huyết ngoài da"));
        symptoms.add(new Symptom("Nổi ban ngoài da"));
    }

    @Override
    public List<Symptom> findAll() {
        return symptoms;
    }

    @Override
    public void save(Symptom song) {
        symptoms.add(song);
    }

    @Override
    public Symptom findById(int id) {
            Symptom song= null;
            for (Symptom s: symptoms) {
                if (s.getId() == id){
                    song=s;
                    break;
                }
            }
            return song;
    }

    @Override
    public void update(int id, Symptom song) {
        for (Symptom s:symptoms) {
            if (s.getId() == id) {
                symptoms.set(symptoms.indexOf(s),song);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Symptom s: symptoms) {
            if (s.getId() == id){
                symptoms.remove(s);
            }
        }
    }
}
