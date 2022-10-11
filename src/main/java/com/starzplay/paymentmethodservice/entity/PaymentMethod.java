package com.starzplay.paymentmethodservice.entity;



import com.starzplay.paymentmethodservice.entity.constant.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method")
@NoArgsConstructor
@Getter
@Setter
public class PaymentMethod {

    @Id
    @Column(name = "payment_method_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentMethodId;
    @Column(name = "name")
    private String name;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "payment_method_plan",
            joinColumns = @JoinColumn(name = "payment_method_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_plan_id")
    )
    private List<PaymentPlan> paymentPlans;

}
