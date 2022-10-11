package com.starzplay.paymentmethodservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.starzplay.paymentmethodservice.dto.PaymentMethodDTO;
import com.starzplay.paymentmethodservice.entity.PaymentMethod;
import com.starzplay.paymentmethodservice.service.PaymentMethodService;
import com.starzplay.paymentmethodservice.util.AppConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(AppConstant.PAYMENT_METHOD_URL)
@AllArgsConstructor
public class PaymentController {

    private final PaymentMethodService paymentMethodService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<PaymentMethodDTO> createPaymentMethod(@RequestBody PaymentMethodDTO paymentMethod){

        PaymentMethod paymentMethodNew = paymentMethodService.createPaymentMethod(objectMapper.convertValue(paymentMethod, PaymentMethod.class));
        return ResponseEntity.created(URI.create(AppConstant.PAYMENT_METHOD_URL+ paymentMethodNew.getPaymentMethodId())).body(objectMapper.convertValue(paymentMethodNew, PaymentMethodDTO.class));

    }


    @GetMapping
    public  ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethod(){
        List<PaymentMethodDTO> collect = paymentMethodService.getPaymentMethods().stream().map(paymentMethod -> objectMapper.convertValue(paymentMethod, PaymentMethodDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }


    @GetMapping("/{id}")
    ResponseEntity<PaymentMethodDTO> getPaymentMethod(@PathVariable Long id){
        return ResponseEntity.ok(
                objectMapper.convertValue(
                        paymentMethodService.getPaymentMethod(id), PaymentMethodDTO.class)
        );
    }


    @PutMapping("/{id}")
    ResponseEntity<PaymentMethodDTO> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethodDTO paymentMethodDTO){
        return ResponseEntity.ok(
                objectMapper.convertValue(
                        paymentMethodService.updatePaymentMethod(id,objectMapper.convertValue(paymentMethodDTO, PaymentMethod.class)),
                        PaymentMethodDTO.class
                        )
            );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaymentMethod(@PathVariable Long id){
        paymentMethodService.deletePaymentMethod(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping( params = {"name"})
    public ResponseEntity<List<PaymentMethodDTO>> getPaymentMethodByName(@RequestParam String name){

        return ResponseEntity.ok(
                paymentMethodService.getPaymentMethodsByName(name).stream().map(paymentMethod -> objectMapper.convertValue(paymentMethod, PaymentMethodDTO.class))
                        .collect(Collectors.toList())
        );
    }
    @GetMapping( params = {"id"})
    public ResponseEntity<List<PaymentMethodDTO>> getPaymentMethodByName(@RequestParam Long id){

        return ResponseEntity.ok(
                paymentMethodService.getPaymentMethodByPaymentPlanId(id).stream().map(paymentMethod -> objectMapper.convertValue(paymentMethod, PaymentMethodDTO.class))
                        .collect(Collectors.toList())
        );
    }

}
