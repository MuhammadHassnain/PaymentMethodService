package com.starzplay.paymentmethodservice.service;


import com.starzplay.paymentmethodservice.entity.PaymentMethod;
import com.starzplay.paymentmethodservice.exception.ResourceNotFoundException;
import com.starzplay.paymentmethodservice.repository.PaymentMethodRepository;
import com.starzplay.paymentmethodservice.repository.PaymentPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentPlanRepository paymentPlanRepository;
    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        PaymentMethod existingPayMethod = paymentMethodRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(HttpStatus.NOT_FOUND, "Payment Method " + id + " Not Found"));
        if(paymentMethod.getPaymentPlans()!=null && paymentMethod.getPaymentPlans().size()>0){
            paymentMethod.setPaymentPlans(paymentPlanRepository.saveAll(paymentMethod.getPaymentPlans()));
        }
        paymentMethod.setPaymentMethodId(existingPayMethod.getPaymentMethodId());
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethod(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment Method " + id + " Not Found"));
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }



    @Override
    public void deletePaymentMethod(Long paymentMethodId){
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(()->new ResourceNotFoundException("Payment Method " + paymentMethodId + " Not Found"));
        paymentMethod.setPaymentPlans(new ArrayList<>());
        paymentMethodRepository.save(paymentMethod);
        paymentMethodRepository.deleteById(paymentMethodId);
    }


    @Override
    public List<PaymentMethod> getPaymentMethodsByName(String name) {

        return paymentMethodRepository.findAllByName(name);
    }

    @Override
    public  List<PaymentMethod> getPaymentMethodByPaymentPlanId(Long paymentPlanId){
        return paymentMethodRepository.findAll().stream()
                .filter(paymentMethod -> paymentMethod
                        .getPaymentPlans()
                        .stream()
                            .anyMatch(paymentPlan -> paymentPlan.getPaymentPlanId().equals(paymentPlanId)))
                .collect(Collectors.toList());
    }
}
