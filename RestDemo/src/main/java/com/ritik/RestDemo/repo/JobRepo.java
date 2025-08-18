package com.ritik.RestDemo.repo;

import com.ritik.RestDemo.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class JobRepo {


        List<JobPost> jobs = new ArrayList<>(Arrays.asList(

                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),


                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),


                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),


                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App")),
                new JobPost(6, "Naruto App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        // method to return all JobPosts
        public List<JobPost> getAllJobs() {
            return jobs;
        }

        // method to save a job post object into arrayList
        public void addJob(JobPost job) {
            jobs.add(job);
            System.out.println(jobs);

        }

    public JobPost getJobById(int postId) {
            for(int i=0;i<jobs.size();i++)
            {
                if(jobs.get(i).getPostId()==postId)
                {
                    return jobs.get(i);
                }
            }
            return null;
    }

    public JobPost updateJob(JobPost jobPost) {
            for(int i=0;i<jobs.size();i++)
            {
                if(jobs.get(i).getPostId()==jobPost.getPostId())
                {
                    jobs.get(i).setPostDesc(jobPost.getPostDesc());
                    jobs.get(i).setPostProfile(jobPost.getPostProfile());
                    jobs.get(i).setReqExperience(jobPost.getReqExperience());
                    jobs.get(i).setPostTechStack(jobPost.getPostTechStack());
                }
            }
            return null;
    }

    public void deleteById(int postId) {
        for(int i=0;i<jobs.size();i++)
        {
            if(jobs.get(i).getPostId()==postId)
            {
                jobs.remove(jobs.get(i));
            }
        }
    }
}


