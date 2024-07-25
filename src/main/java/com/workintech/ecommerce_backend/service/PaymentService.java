package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.PaymentRequestDto;
import com.workintech.ecommerce_backend.entity.Payment;

public interface PaymentService extends Service<Payment>{

    Payment addPayment(PaymentRequestDto paymentRequestDto);
}
