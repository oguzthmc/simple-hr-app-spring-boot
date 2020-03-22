package com.kodgemisi.staj2020.service;

import com.kodgemisi.staj2020.domain.FileInfo;
import com.kodgemisi.staj2020.domain.JobApplication;
import com.kodgemisi.staj2020.domain.JobApplicationDTO;

public interface JobApplicationService {

	JobApplication createJopApplication(JobApplicationDTO jobApplicationDTO);

	void createFileInfo(FileInfo fileInfo);
}
