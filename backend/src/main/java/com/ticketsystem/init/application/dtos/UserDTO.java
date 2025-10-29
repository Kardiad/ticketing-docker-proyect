package com.ticketsystem.init.application.dtos;

public class UserDTO {
    
    private Long id;
    private String username;
    private String password;

    public UserDTO() { }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(Long id, String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
