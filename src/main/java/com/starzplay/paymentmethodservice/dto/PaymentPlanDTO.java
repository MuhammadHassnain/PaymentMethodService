package com.starzplay.paymentmethodservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.starzplay.paymentmethodservice.entity.constant.PaymentPeriod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PaymentPlanDTO {
    private Long paymentPlanId;
    private BigDecimal netAmount;
    private BigDecimal taxAmount;
    private BigDecimal grossAmount;
    private String currency;
    private PaymentPeriod duration;
}
