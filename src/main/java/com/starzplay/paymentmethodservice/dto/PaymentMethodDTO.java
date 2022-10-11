package com.starzplay.paymentmethodservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PaymentMethodDTO {
    @JsonIgnore
    private Long paymentMethodId;
    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanDTO> paymentPlans;

}
