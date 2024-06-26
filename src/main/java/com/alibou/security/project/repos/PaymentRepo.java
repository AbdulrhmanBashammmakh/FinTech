package com.alibou.security.project.repos;

import com.alibou.security.project.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo   extends JpaRepository<Payment, Long> {
}
