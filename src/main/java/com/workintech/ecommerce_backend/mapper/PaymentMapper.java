package com.workintech.ecommerce_backend.mapper;

import com.workintech.ecommerce_backend.dto.PaymentRequestDto;
import com.workintech.ecommerce_backend.dto.PaymentResponseDto;
import com.workintech.ecommerce_backend.entity.Enum_PaymentStatus;
import com.workintech.ecommerce_backend.entity.Payment;
import com.workintech.ecommerce_backend.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentMapper {


    public static Payment paymentReqestDtoToPayment(PaymentRequestDto paymentRequestDto){
        Payment payment = new Payment();
        payment.setAmount(paymentRequestDto.amount());
        payment.setMethod(paymentRequestDto.method());
        payment.setStatus(Enum_PaymentStatus.ODENDI);
      //  payment.setCreditCard(CreditCardMapper.creditCardRequestDtoCreditCard(paymentRequestDto.creditCardRequestDto()));
        return payment;
    }

/*    public static Payment paymentReqestDtoToPayment(PaymentRequestDto paymentRequestDto) {
        if (paymentRequestDto == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setMethod(paymentRequestDto.method());
        payment.setStatus(Enum_PaymentStatus.ODENDI); // Burada uygun bir durum ayarlayın
        payment.setAmount(paymentRequestDto.amount());

        return payment;
    }*/

    public static PaymentResponseDto paymentToPaymentResponseDto(Payment payment){
        return new PaymentResponseDto(payment.getId(),payment.getMethod(),payment.getStatus(),payment.getDate(),payment.getAmount(),
                    CreditCardMapper.creditCardToCreditCardResponseDto(payment.getCreditCard()));
    }

}
