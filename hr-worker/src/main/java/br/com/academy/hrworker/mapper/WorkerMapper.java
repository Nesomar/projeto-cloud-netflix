package br.com.academy.hrworker.mapper;

import org.modelmapper.ModelMapper;

import br.com.academy.hrworker.entity.Worker;
import br.com.academy.hrworker.model.WorkerResponse;

public class WorkerMapper {

	public static WorkerResponse toModel(Object entity) {
		var modelMapper = new ModelMapper();
		return modelMapper.map(entity, WorkerResponse.class);
	}

	public static Worker toEntity(Object model) {
		var modelMapper = new ModelMapper();
		return modelMapper.map(model, Worker.class);
	}
}
