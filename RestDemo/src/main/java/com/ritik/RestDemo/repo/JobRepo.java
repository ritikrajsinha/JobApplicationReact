package com.ritik.RestDemo.repo;

import com.ritik.RestDemo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostDesc(String postdesc);

    List<JobPost>findByPostDescContainingOrPostProfileContaining(String postDesc,String posrProfile);
}
//public List<JobPost> getAllJobs() {
//    return jobs;
//}
//
//// method to save a job post object into arrayList
//public void addJob(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//
//}
//
//public JobPost getJobById(int postId) {
//    for(int i=0;i<jobs.size();i++)
//    {
//        if(jobs.get(i).getPostId()==postId)
//        {
//            return jobs.get(i);
//        }
//    }
//    return null;
//}
//
//public JobPost updateJob(JobPost jobPost) {
//    for(int i=0;i<jobs.size();i++)
//    {
//        if(jobs.get(i).getPostId()==jobPost.getPostId())
//        {
//            jobs.get(i).setPostDesc(jobPost.getPostDesc());
//            jobs.get(i).setPostProfile(jobPost.getPostProfile());
//            jobs.get(i).setReqExperience(jobPost.getReqExperience());
//            jobs.get(i).setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//    return null;
//}
//
//public void deleteById(int postId) {
//    for(int i=0;i<jobs.size();i++)
//    {
//        if(jobs.get(i).getPostId()==postId)
//        {
//            jobs.remove(jobs.get(i));
//        }
//    }
//}

