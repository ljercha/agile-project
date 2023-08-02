package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEmployee {
    private String email;
    private String password;
    private String role;

    @JsonCreator
    public RequestEmployee(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("role") String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
