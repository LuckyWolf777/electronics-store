package com.example.electronicsstore.controller.worker;

import com.example.electronicsstore.models.entity.Worker;
import com.example.electronicsstore.service.worker.WorkerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api/v1/worker")
public class WorkerController {
    private final WorkerServiceImp workerServ;

    public WorkerController(WorkerServiceImp workerServ) {
        this.workerServ = workerServ;
    }

    @PostMapping("/new")
    public Worker create(@RequestBody Worker worker) {
        workerServ.create(worker);
        return worker;
    }

    @GetMapping("/show")
    public List<Worker> show() {
        return workerServ.getAllWorkers();
    }
}
