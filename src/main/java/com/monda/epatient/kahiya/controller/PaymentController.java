package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.req.UpdatePaymentReq;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/update-status")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper updateStatus(@RequestBody UpdatePaymentReq req) {
        paymentService.updateMetadata(req);
        return new ResponseWrapper<>(true, null, null);
    }

    @PostMapping(value = "/payment/payhere-notify")
    @ResponseStatus(code = HttpStatus.OK)
    public void payhereNotify(@RequestBody Map<String, Object> metadata) {
        if(metadata == null || metadata.size() == 0) {
            return;
        }

        Object orderId = metadata.get("order_id");
        if(orderId != null) {
            paymentService.updateMetadata(orderId.toString(), metadata);
        }
    }
}
