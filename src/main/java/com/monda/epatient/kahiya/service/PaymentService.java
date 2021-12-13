package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.req.UpdatePaymentReq;
import com.monda.epatient.kahiya.model.PaymentEntity;
import com.monda.epatient.kahiya.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void updateMetadata(UpdatePaymentReq req) {
        Long orderId = PaymentEntity.extractId(req.getOrderNumber());
        PaymentEntity payment = paymentRepository.getOne(orderId);
        payment.addMetadata("paymentId", req.getPaymentId());

        paymentRepository.save(payment);
    }

    public void updateMetadata(String orderIdAsString, Map<String, Object> metadata) {
        Long orderId = PaymentEntity.extractId(orderIdAsString);
        PaymentEntity payment = paymentRepository.getOne(orderId);
        metadata.forEach((key, value) -> {
            payment.addMetadata(key, value);
        });
    }
}
