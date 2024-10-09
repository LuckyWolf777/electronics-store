package com.example.electronicsstore.service.worker;

import com.example.electronicsstore.models.entity.Worker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface WorkerService {
    Worker create (Worker worker);
    List<Worker> getAllWorkers();
}
