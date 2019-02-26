package com.goat.repository;

import com.goat.domain.OperLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenLogRepository extends CrudRepository<OperLog, Long> {

}

