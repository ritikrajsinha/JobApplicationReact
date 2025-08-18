package com.ritik.RestDemo;

import com.ritik.RestDemo.model.JobPost;
import com.ritik.RestDemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class jobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<JobPost> getAllJobs()
    {
        return jobService.getAllJobs();
    }


    @GetMapping("jobs/{postId}")
    public JobPost getJobById(@PathVariable int postId)
    {
        return jobService.getJobById(postId);
    }

    @PostMapping("jobs")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @PutMapping("jobs")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        jobService.updateJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("jobs/{postId}")
    public void deleteById(@PathVariable int postId)
    {
        jobService.deleteByID(postId);

    }
}
