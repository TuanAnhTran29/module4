package com.service;

import com.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailService implements IEmailService {
    List<Email> emails= new ArrayList<>();
    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public void save(Email email) {
        emails.add(email);
    }

    @Override
    public Email findById(int id) {
        for (Email e: emails) {
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Email email) {
        for (Email e: emails) {
            if (e.getId() == id){
                emails.set(emails.indexOf(e),email);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Email e: emails) {
            if (e.getId() == id){
                emails.remove(e);
            }
        }
    }
}
