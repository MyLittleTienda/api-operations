package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationStatusRepository extends JpaRepository<OperationStatusModel, Long> {
}
