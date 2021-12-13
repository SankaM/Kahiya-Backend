package com.monda.epatient.kahiya.dto.req;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private String userName;
    
    private String password;
}
