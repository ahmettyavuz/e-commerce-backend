package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.PaymentRequestDto;
import com.workintech.ecommerce_backend.dto.ProductRequestDto;
import com.workintech.ecommerce_backend.entity.Payment;
import com.workintech.ecommerce_backend.entity.Product;
import com.workintech.ecommerce_backend.mapper.PaymentMapper;
import com.workintech.ecommerce_backend.repository.CreditCardRepository;
import com.workintech.ecommerce_backend.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, CreditCardRepository creditCardRepository) {
        this.paymentRepository = paymentRepository;
        this.creditCardRepository = creditCardRepository;
    }


    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow(null) ;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    //(dml)
    // buna koymaya gerek var mıl
    @Override
    public Payment delete(Long id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);
        return payment;
    }

    @Override
    public Payment addPayment(PaymentRequestDto paymentRequestDto){
        Payment payment = PaymentMapper.paymentReqestDtoToPayment(paymentRequestDto);
        payment.setCreditCard(creditCardRepository.findById(paymentRequestDto.creditCardId()).get());

        return payment;
    }


}
