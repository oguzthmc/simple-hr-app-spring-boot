package com.kodgemisi.staj2020.service;

import com.kodgemisi.staj2020.dao.JobApplicationRepository;
import com.kodgemisi.staj2020.dao.JobListingRepository;
import com.kodgemisi.staj2020.domain.JobApplication;
import com.kodgemisi.staj2020.domain.JobListing;
import com.kodgemisi.staj2020.domain.JobListingDTO;
import com.kodgemisi.staj2020.exception.JobListingNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class JobListingServiceImpl implements JobListingService {


    private final JobListingRepository jobListingRepository;

    private final JobApplicationRepository jobApplicationRepository;

    @Override
    public List<JobListing> findJobListing() {
        return jobListingRepository.findAll();
    }

    // TODO: log basılabilir.
    @Override
    public JobListing findJob(Long id) throws JobListingNotFoundException {
        Optional<JobListing> jobListing = jobListingRepository.findById(id);
        return jobListing.orElseThrow(JobListingNotFoundException::new);
    }

    // TODO: builder pattern kullanılabilir. 
    // TODO: ayrı bir save metodu hazırlanıp, çağrılabilir. 
    @Override
    public void createJobListing(JobListingDTO jobListingDTO) {
        JobListing jobListing = new JobListing(
                jobListingDTO.getJobTitle(),
                jobListingDTO.getJobDescription(),
                jobListingDTO.getNumberOfPeopleToHire(),
                jobListingDTO.getLastAppDate());
        jobListingRepository.save(jobListing);
    }

    // TODO: JobListingDTO aracılığı ile alınmalıdır. 
    @Override
    public void updateJobListing(JobListing jobListing) {
        jobListingRepository.save(jobListing);
    }

    // TODO: cascade incelenip, düzenlenebilir.
    @Override
    public void deleteJobListing(Long id) {
        if(jobApplicationRepository.existsById(id)){
        jobApplicationRepository.deleteById(id);
        }
        jobListingRepository.deleteById(id);
    }

    @Override
    public List<JobApplication> showJobListingApp(Long id) {
        List<JobApplication> jobApp = jobListingRepository.showJobListingApp(id);
        if (jobApp == null) {
            throw new JobListingNotFoundException();
        }
        return jobApp;
    }

}
