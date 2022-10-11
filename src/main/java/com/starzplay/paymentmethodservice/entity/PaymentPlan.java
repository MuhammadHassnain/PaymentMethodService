package com.starzplay.paymentmethodservice.entity;



import com.starzplay.paymentmethodservice.entity.constant.PaymentPeriod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "payment_plan")
@Getter
@Setter
@NoArgsConstructor
public class
PaymentPlan {
    @Id
    @Column(name = "payment_plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentPlanId;
    @Column(name = "net_amount")
    private BigDecimal netAmount;
    @Column(name = "tax_amount")
    private BigDecimal taxAmount;
    @Column(name = "gross_amount")
    private BigDecimal grossAmount;
    @Column(name = "currency")
    private String currency;
    @Enumerated(EnumType.STRING)
    @Column(name = "duration")
    private PaymentPeriod duration;
    @ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PaymentMethod> paymentMethods;
}
