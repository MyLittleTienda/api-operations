package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationTypeModel, Long> {
}
