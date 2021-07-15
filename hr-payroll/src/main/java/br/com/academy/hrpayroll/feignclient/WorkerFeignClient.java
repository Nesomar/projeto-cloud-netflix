package br.com.academy.hrpayroll.feignclient;

import br.com.academy.hrpayroll.model.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "${hr-worker.name}", path = "${hr-worker.path}", decode404 = true)
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<WorkerResponse> findById(@PathVariable Long id);
}

