package com.monda.epatient.kahiya.dto.req;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentReq {
    private String orderNumber;

    private String paymentId;
}
