package com.team3.tamagochi.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team3.tamagochi.store.ItemFileDTO;


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
	
	//기본 이미지 파일 저장
	public String defaultFileSave(String path) throws Exception {
		
		String filename = UUID.randomUUID().toString() + "_" +"default.gif";
		
		File file = new File(path, "default.gif");
		
		FileInputStream fi = new FileInputStream(file);
		
		file = new File(path, filename);
		
		FileOutputStream fo = new FileOutputStream(file);
		
		FileCopyUtils.copy(fi, fo);
		
		return filename;
	}

	public void fileDelete(ItemFileDTO itemFileDTO, String path) throws Exception {
		
		File file = new File(path, itemFileDTO.getFile_name());
		file.delete();
		
	}
	
}
