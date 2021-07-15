package br.com.academy.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academy.hrworker.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
