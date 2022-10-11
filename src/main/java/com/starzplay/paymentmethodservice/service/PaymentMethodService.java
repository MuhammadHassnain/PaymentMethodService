package com.starzplay.paymentmethodservice.service;


import com.starzplay.paymentmethodservice.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);
    PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethod(Long id);
    List<PaymentMethod> getPaymentMethods();
    void deletePaymentMethod(Long paymentPlanId);
}
