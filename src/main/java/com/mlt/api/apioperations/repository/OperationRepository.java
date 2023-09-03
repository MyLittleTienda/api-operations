package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationModel, Long> {
}
