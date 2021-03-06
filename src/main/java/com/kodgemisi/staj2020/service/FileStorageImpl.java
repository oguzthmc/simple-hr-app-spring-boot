package com.kodgemisi.staj2020.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageImpl implements FileStorage {

	private final Path rootLocation = Paths.get("filestorage");

	@Override
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		}
		catch (Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	@Override
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new RuntimeException("FAIL!");
			}
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("Error! -> message = " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		}
		catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

}