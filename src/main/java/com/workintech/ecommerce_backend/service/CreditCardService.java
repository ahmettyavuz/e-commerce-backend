package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.CreditCardRequestDto;
import com.workintech.ecommerce_backend.entity.CreditCard;

public interface CreditCardService extends Service<CreditCard>{
    CreditCard addCreditCard(CreditCardRequestDto creditCardRequestDto, String user_mail);
}
