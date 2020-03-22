package com.kodgemisi.staj2020.dao;

import com.kodgemisi.staj2020.domain.JobApplication;
import com.kodgemisi.staj2020.domain.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Long> {

	//@Query("SELECT distinct a from JobApplication a inner join JobListing b on job_listing_id=:id")
	@Query("SELECT  a from JobApplication a inner join JobListing b on job_listing_id=:id")
	List<JobApplication> showJobListingApp(@Param("id") Long id);

}

