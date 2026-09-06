package com.edwardkh.jpp.controller;

import com.edwardkh.jpp.model.Job;
import com.edwardkh.jpp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping()
    public Job createJob(@RequestParam String type) {
        return jobService.createJob(type);
    }

    @GetMapping()
    public List<Job> listJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable UUID id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/{id}/process")
    public Job processJob(@PathVariable UUID id) {
        return jobService.processJob(id);
    }
}
