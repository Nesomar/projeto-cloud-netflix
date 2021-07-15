package br.com.academy.hrpayroll.service;

import br.com.academy.hrpayroll.model.PaymentResponse;
import br.com.academy.hrpayroll.model.WorkerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.url.worker}")
    private String workerHost;

    public ResponseEntity<PaymentResponse> getPayment(Long workerId, Integer days) {

        String url = String.format(workerHost, workerId.toString());

        WorkerResponse workerResponse = restTemplate.getForObject(url, WorkerResponse.class);

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
