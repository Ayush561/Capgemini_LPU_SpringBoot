package com.capgemini.FileUploadingDownloading.Controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.FileUploadingDownloading.Entity.FileData;
import com.capgemini.FileUploadingDownloading.Repo.FileRepository;

@RestController
@RequestMapping("/files")
public class FileController {
	
	private FileRepository repository;
	//Dependency Injection
	public FileController(FileRepository repository) {
		this.repository = repository;
	}



	@PostMapping("/upload")
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFiletype(file.getContentType());
		data.setData(file.getBytes());
		
		FileData saved=repository.save(data);
		return saved;
		
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable int id) {
		FileData data = repository.findById(id).orElseThrow(()->new RuntimeException("File not found"));  //It will give raw data from the table.
		
		
		//But we want the Blob value to be converted to image and image should be converted to URL
		//return ResponseEntity.ok().body(data); //this will give the raw data on the browser, it will just give the info about the image and not the actual image.
		//To get the actual image we use
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION,"inline:filename=/"+data.getFilename())
//				.header(HttpHeaders.CONTENT_TYPE,data.getFiletype())
//				.body(data.getData());
		
		//Above one will show the image on the browser but if we want to download the image from the browser we use
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=/"+data.getFilename())
				.header(HttpHeaders.CONTENT_TYPE,data.getFiletype())
				.body(data.getData());
		
	}

}
