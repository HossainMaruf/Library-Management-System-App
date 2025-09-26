package com.data;

import java.util.List;
import java.util.ArrayList;

public class Validator {
    private String data;
    private int minLength;
    private String minLengthError;
    private int maxLength;
    private String maxLengthError;

    List<String> errors = null;

    public Validator(String data) { 
        this.data = data;
        errors = new ArrayList<String>();
    }
    public boolean validateText(String name) {

    }
    public Validator min(int minLength) {
        this.minLength = minLength;
        if(data.length() < minLength) {
            errors.add("Length must be at least " + minLength + " letters");
        }
        return this;
    }
    public Validator max(int maxLength) {
        this.maxLength = maxLength;
        if(data.length() > maxLength) {
            errors.add("Length exceed " + maxLength + " letters");
        }
        return this;
    }
    public boolean hasError() {
        return !errors.isEmpty();
    }
    public List<String> getErrors() {
        return errors;
    }
}
