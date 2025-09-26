package com.data;

import java.util.List;
import java.util.ArrayList;

public class Validator {
    private String data;
    List<String> errors = null;

    public Validator() { 
        errors = new ArrayList<String>();
    }
    public Validator validateText(String text) {
        this.data = text;
        return this;
    }
    public Validator validateEmail(String email) {
        this.data = email;
        // TODO: email validation logic
        return this;
    } 
    public Validator validatePassword(String password) {
        this.data = password;
        return this;
    }
    public Validator min(int minLength) {
        if(data.length() < minLength) {
            errors.add("Length must be at least " + minLength + " letters");
        }
        return this;
    }
    public Validator max(int maxLength) {
        if(data.length() > maxLength) {
            errors.add("Length exceed " + maxLength + " letters");
        }
        return this;
    }
    public Validator minMax(int minLength, int maxLength) {
        int length = data.length();
        if(!(length >= minLength && length <= maxLength)) {
            errors.add("Length must be between " + minLength + " to " + maxLength + " letters" );
        }
        return this;
    }
    public List<String> getErrors() {
        return errors;
    }
}
