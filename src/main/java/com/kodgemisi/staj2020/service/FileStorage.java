package com.kodgemisi.staj2020.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface FileStorage {
	void store(MultipartFile file);
	Resource loadFile(String filename);
	void deleteAll();
	void init();

}