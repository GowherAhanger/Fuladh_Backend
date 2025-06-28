package com.gowher.Fuladh.DTOs;

public class RegisterDTO {
    private String fullName;
    private String emailId;
    private String password;
   // private String confirmPassword;

    public RegisterDTO() {
    }

    public RegisterDTO(String fullName, String emailId, String password, String confirmPassword) {
        this.fullName = fullName;
        this.emailId = emailId;
        this.password = password;
       // this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

