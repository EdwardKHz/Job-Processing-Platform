package com.edwardkh.jpp.controller;

import com.edwardkh.jpp.model.Job;
import com.edwardkh.jpp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public Job createJob(@RequestParam String type) {
        return jobService.createJob(type);
    }

    @GetMapping("/jobs")
    public List<Job> listJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable UUID id) {
        return jobService.getJobById(id);
    }
}
