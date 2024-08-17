package com.team3.tamagochi.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public String fileSave(MultipartFile files, String path) throws Exception {

		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		String filename = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();

		file = new File(file, filename);

		files.transferTo(file);

		return filename;
	}
	
}
