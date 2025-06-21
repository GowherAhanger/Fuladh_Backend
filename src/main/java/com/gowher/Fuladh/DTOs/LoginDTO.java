package com.gowher.Fuladh.DTOs;

import lombok.Getter;
import lombok.Setter;

// @NoArgsConstructor
// @AllArgsConstructor
// @Data
@Setter
@Getter
public class LoginDTO {
    private String emailId;
    private String password;

    public LoginDTO(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

}
