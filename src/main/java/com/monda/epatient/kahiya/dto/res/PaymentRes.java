package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.PaymentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRes {
    private Long id;

    private String orderNumber;

    private Double amount;

    private Boolean paid;

    private LocalDateTime generatedDate;

    private LocalDateTime requestDate;

    private LocalDateTime resultDate;

    private PaymentEntity.PaymentProvider paymentProvider;

    private AppointmentRes appointment;

    private PrescriptionRes prescription;

    public static PaymentRes buildSimple(PaymentEntity payment) {
        PaymentRes res = null;

        if(payment != null) {
            res = new PaymentRes();
            res.id = payment.getId();
            res.orderNumber = payment.generateOrderNumber();
            res.amount = payment.getAmount();
            res.paid = payment.getPaid();
            res.generatedDate = payment.getGeneratedDate();
            res.requestDate = payment.getRequestDate();
            res.resultDate = payment.getResultDate();
            res.paymentProvider = payment.getPaymentProvider();
        }

        return res;
    }

    public static PaymentRes buildDetail(PaymentEntity payment) {
        PaymentRes res = null;

        if(payment != null) {
            res = new PaymentRes();
            res.id = payment.getId();
            res.orderNumber = payment.generateOrderNumber();
            res.amount = payment.getAmount();
            res.paid = payment.getPaid();
            res.generatedDate = payment.getGeneratedDate();
            res.requestDate = payment.getRequestDate();
            res.resultDate = payment.getResultDate();
            res.paymentProvider = payment.getPaymentProvider();
            res.appointment = AppointmentRes.build(payment.getAppointment());
            res.prescription = PrescriptionRes.buildDetail(payment.getPrescription());
        }

        return res;
    }
}
