package br.com.academy.hrpayroll.service;

import br.com.academy.hrpayroll.feignclient.WorkerFeignClient;
import br.com.academy.hrpayroll.model.PaymentResponse;
import br.com.academy.hrpayroll.model.WorkerResponse;
import br.com.academy.hrpayroll.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${hr-worker.url.worker}")
    private String workerHost;

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public ResponseEntity<PaymentResponse> getPayment(Long workerId, Integer days) {

        ResponseEntity<WorkerResponse> responseEntity = workerFeignClient.findById(workerId);

        if (HttpStatus.NOT_FOUND.name().equals(responseEntity.getStatusCode().name())) {
            throw new NotFoundException("Worker not Found!");
        }

        WorkerResponse workerResponse = responseEntity.getBody();

        return ResponseEntity.ok(PaymentResponse
                .builder()
                .days(days)
                .dailyIncome(workerResponse.getDailyIncome())
                .name(workerResponse.getName())
                .total(calculateTotal(workerResponse.getDailyIncome(), days))
                .build());
    }

    private Double calculateTotal(Double dailyIncome, Integer days) {
        return dailyIncome * days;
    }
}
