package com.ritik.RestDemo;

import com.ritik.RestDemo.model.JobPost;
import com.ritik.RestDemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class jobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs()
    {
        return jobService.getAllJobs();
    }


    @GetMapping("jobs/{postId}")
    public JobPost getJobById(@PathVariable int postId)
    {
        return jobService.getJobById(postId);
    }

    @GetMapping("jobs/keyword/{keyword}")
    public List<JobPost> getJobById(@PathVariable String keyword)
    {
        return jobService.search(keyword);
    }

    @PostMapping("jobs")
    public String addJob(@RequestBody JobPost jobPost)
    {
        jobService.addJob(jobPost);
//        return jobService.getJobById(jobPost.getPostId());
        return "data created successfully";
    }

    @PutMapping("jobs")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        jobService.updateJob(jobPost);
     return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("jobs/{postId}")
    public String deleteById(@PathVariable int postId)
    {
        jobService.deleteByID(postId);
        return "data successfully deleted";

    }

    @GetMapping("jobs/desc/{postdesc}")
    public List<JobPost> findJobBydesc(@PathVariable String postdesc)
    {
        return jobService.findBypostDesc(postdesc);
    }


    @GetMapping("/load")
    public String LoadData()
    {
        jobService.load();
        return "Success";
    }
}
