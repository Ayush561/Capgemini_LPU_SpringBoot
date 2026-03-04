package com.practice.RedisServerForGlobalCache.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.RedisServerForGlobalCache.Entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Integer> {

}
