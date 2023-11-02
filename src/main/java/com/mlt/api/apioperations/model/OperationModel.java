package com.mlt.api.apioperations.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OPERATION")
public class OperationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHOPPING_CART_CODE")
    private String shoppingCartCode;

    @Column(name = "CREATED_AT")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "UPDATED_AT")
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private OperationTypeModel operationType;
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private OperationStatusModel operationStatus;

    @OneToOne
    @JoinColumn(name = "OPERATION_ID")
    private OperationModel operationFor;

    @OneToMany(mappedBy = "operation", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<OperationTransitionModel> transitions;
    @OneToMany(mappedBy = "operation", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<OperationDetailModel> details;

    public void addTransition(OperationTransitionModel transition) {
        this.transitions.add(transition);
    }

    public void addDetail(OperationDetailModel detail) {
        this.details.add(detail);
    }

}
