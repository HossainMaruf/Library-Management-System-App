package com.data;

import java.util.Map;
import java.util.HashMap;

public class Validator {
    private String data, alias;
    Map<String, String> errors = null;

    public Validator() { 
        errors = new HashMap<String, String>();
    }
    public Validator validateText(String text, String alias) {
        this.data = text;
        this.alias = alias;
        return this;
    }
    public Validator validateEmail(String email, String alias) {
        this.data = email;
        this.alias = alias;
        // TODO: email validation logic
        return this;
    } 
    public Validator validatePassword(String password, String alias) {
        this.data = password;
        this.alias = alias;
        return this;
    }
    public Validator min(int minLength) {
        if(data.length() < minLength) {
            errors.put(alias, "Length must be at least " + minLength + " letters");
        }
        return this;
    }
    public Validator max(int maxLength) {
        if(data.length() > maxLength) {
            errors.put(alias, "Length exceed " + maxLength + " letters");
        }
        return this;
    }
    public Validator minMax(int minLength, int maxLength) {
        int length = data.length();
        if(!(length >= minLength && length <= maxLength)) {
            errors.put(alias, "Length must be between " + minLength + " to " + maxLength + " letters" );
        }
        return this;
    }
    public Map<String, String> getErrors() {
        return errors;
    }
}
