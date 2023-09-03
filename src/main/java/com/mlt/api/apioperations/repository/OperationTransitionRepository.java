package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationTransitionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTransitionRepository extends JpaRepository<OperationTransitionModel, Long> {
}
