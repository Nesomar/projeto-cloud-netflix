package br.com.academy.hrworker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.academy.hrworker.entity.Worker;
import br.com.academy.hrworker.mapper.WorkerMapper;
import br.com.academy.hrworker.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academy.hrworker.model.WorkerResponse;
import br.com.academy.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public static final String WORKER_NOT_FOUND = "Worker not found!";

	public ResponseEntity<List<WorkerResponse>> findAll() {

		List<Worker> workerList = repository.findAll();

		return ResponseEntity.ok(workerList.stream().map(WorkerMapper::toModel).collect(Collectors.toList()));
	}

    public ResponseEntity<WorkerResponse> findById(Long id) {

		Optional<Worker> optionalWorker = repository.findById(id);

		if (optionalWorker.isEmpty()) {
			throw new NotFoundException(WORKER_NOT_FOUND);
		}

		return ResponseEntity.ok(WorkerMapper.toModel(optionalWorker.get()));
    }
}
