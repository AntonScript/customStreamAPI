package org.example.customstreamapi.model;

public enum Gender{
    woman("woman"),
    man("man");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
