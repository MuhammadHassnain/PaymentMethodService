package com.starzplay.paymentmethodservice.service;


import com.starzplay.paymentmethodservice.entity.PaymentMethod;
import com.starzplay.paymentmethodservice.repository.PaymentMethodRepository;
import com.starzplay.paymentmethodservice.repository.PaymentPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        PaymentMethod existingPayMethod = paymentMethodRepository.findById(id).orElseThrow(RuntimeException::new);
        paymentMethod.setPaymentMethodId(id);
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethod(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }



    @Override
    public void deletePaymentMethod(Long paymentPlanId){
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentPlanId)
                .orElseThrow(RuntimeException::new);
        paymentMethod.setPaymentPlans(new ArrayList<>());
        paymentMethodRepository.save(paymentMethod);
        paymentMethodRepository.deleteById(paymentPlanId);
    }


}
