package com.kodgemisi.staj2020.service;

import com.kodgemisi.staj2020.dao.FileInfoRepository;
import com.kodgemisi.staj2020.dao.JobApplicationRepository;
import com.kodgemisi.staj2020.domain.FileInfo;
import com.kodgemisi.staj2020.domain.JobApplication;
import com.kodgemisi.staj2020.domain.JobApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobApplicationServiceImpl implements JobApplicationService {

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private FileInfoRepository fileInfoRepository;

	@Override
	public JobApplication createJopApplication(JobApplicationDTO jobApplicationDTO) {
		JobApplication jobApplication = new JobApplication(jobApplicationDTO.getName(), jobApplicationDTO.getEmail(), jobApplicationDTO.getPhone(),
														   jobApplicationDTO.getAddress(), jobApplicationDTO.getThoughtsOnJob(),
														   jobApplicationDTO.getJobListing());

		jobApplicationRepository.save(jobApplication);
		return jobApplication;

	}

	@Override
	public void createFileInfo(FileInfo fileInfo) {
		fileInfoRepository.save(fileInfo);
	}

}
