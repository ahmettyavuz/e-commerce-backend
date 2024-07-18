package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Payment;
import com.workintech.ecommerce_backend.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        /*
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            return address.get();
        }
        */
        return paymentRepository.findById(id).orElseThrow(null) ;
    }

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    // buna koymaya gerek var mı sonuçta dml
    @Transactional
    @Override
    public Payment delete(Long id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);
        return payment;
    }
}
