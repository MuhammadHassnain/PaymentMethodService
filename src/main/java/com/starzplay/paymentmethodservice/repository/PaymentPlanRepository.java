package com.starzplay.paymentmethodservice.repository;


import com.starzplay.paymentmethodservice.entity.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Long> {
}
