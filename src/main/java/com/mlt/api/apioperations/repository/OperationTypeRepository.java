package com.mlt.api.apioperations.repository;

import com.mlt.api.apioperations.model.OperationTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationTypeRepository extends JpaRepository<OperationTypeModel, Long> {

    Optional<OperationTypeModel> findByDescriptionIgnoreCase(String description);

}
