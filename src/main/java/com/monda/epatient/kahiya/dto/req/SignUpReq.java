package com.monda.epatient.kahiya.dto.req;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpReq {
    private String email;

    private String userName;
    
    private String password;
}
