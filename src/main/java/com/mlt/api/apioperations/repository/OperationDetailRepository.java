package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationDetailRepository extends JpaRepository<OperationDetailModel, Long> {
}
