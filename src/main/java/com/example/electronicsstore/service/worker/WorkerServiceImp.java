package com.example.electronicsstore.service.worker;

import com.example.electronicsstore.models.entity.Worker;
import com.example.electronicsstore.repository.worker.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class WorkerServiceImp implements WorkerService{
    private final WorkerRepository workRepo;
    @Autowired
    public WorkerServiceImp(WorkerRepository workRepo) {
        this.workRepo = workRepo;
    }

    @Override
    public Worker create(Worker worker) {
        workRepo.save(worker);
        return worker;
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workRepo.findAll();
    }
}
