package com.localmart.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public void init();
	public void save(MultipartFile file);
	public org.springframework.core.io.Resource loadFile(String fileName);
	
}
