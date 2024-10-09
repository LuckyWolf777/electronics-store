package com.example.electronicsstore.repository.worker;

import com.example.electronicsstore.models.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {



}
