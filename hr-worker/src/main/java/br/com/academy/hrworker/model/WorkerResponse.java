package br.com.academy.hrworker.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResponse implements Serializable {

	private static final long serialVersionUID = 2364898435063772950L;
	
	private Long id;
	private String name;
	private String dailyIncome;

}
