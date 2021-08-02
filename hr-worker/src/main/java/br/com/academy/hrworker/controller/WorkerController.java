package br.com.academy.hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.hrworker.model.WorkerResponse;
import br.com.academy.hrworker.service.WorkerService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	@Autowired
	private WorkerService service;

	@GetMapping
	public ResponseEntity<List<WorkerResponse>> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerResponse> findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
