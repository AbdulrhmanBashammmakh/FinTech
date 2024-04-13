package com.alibou.security.project.entity.pch;

import com.alibou.security.project.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class PchDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Double price=0.0;
    @Column(nullable = false)
    private int qty=1;
    private Double amt;
    private Long pchHeadId;

//    @Column(nullable = false)
//    private Long gen;

}
