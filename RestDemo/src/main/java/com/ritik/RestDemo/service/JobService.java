package com.ritik.RestDemo.service;

import com.ritik.RestDemo.model.JobPost;
import com.ritik.RestDemo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {




        @Autowired
        private JobRepo repo;


        public void addJob(JobPost jobPost) {
            repo.addJob(jobPost);

        }


        //method to return all JobPosts
        public List<JobPost> getAllJobs() {
            return repo.getAllJobs();


        }

    public JobPost getJobById(int postId) {
            return repo.getJobById(postId);
    }

    public JobPost updateJob(JobPost jobPost) {
            return repo.updateJob(jobPost);
    }

    public void deleteByID(int postId) {
            repo.deleteById(postId);
    }
}


