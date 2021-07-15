package br.com.academy.hrpayroll.controller;

import br.com.academy.hrpayroll.model.PaymentResponse;
import br.com.academy.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return service.getPayment(workerId, days);
    }
}
