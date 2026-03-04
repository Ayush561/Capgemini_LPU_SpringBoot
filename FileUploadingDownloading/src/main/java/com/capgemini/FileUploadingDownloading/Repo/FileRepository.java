package com.capgemini.FileUploadingDownloading.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.FileUploadingDownloading.Entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Integer> {

}

