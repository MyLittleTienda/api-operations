package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationStatusRepository extends JpaRepository<OperationStatusModel, Long> {

    Optional<OperationStatusModel> findByDescriptionIgnoreCase(String description);

}
