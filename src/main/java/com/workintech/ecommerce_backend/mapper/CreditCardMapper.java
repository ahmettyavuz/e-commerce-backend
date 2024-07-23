package com.workintech.ecommerce_backend.mapper;

import com.workintech.ecommerce_backend.dto.CreditCardRequestDto;
import com.workintech.ecommerce_backend.dto.CreditCardResponseDto;
import com.workintech.ecommerce_backend.entity.CreditCard;

public class CreditCardMapper {

    public static CreditCard creditCardRequestDtoCreditCard(CreditCardRequestDto creditCardRequestDto){
        CreditCard creditCard =new CreditCard();
        creditCard.setNo(creditCardRequestDto.no());
        creditCard.setCcv(creditCardRequestDto.ccv());
        creditCard.setName(creditCardRequestDto.name());
        creditCard.setExpireMonth(creditCardRequestDto.expireMonth());
        creditCard.setExpireYear(creditCardRequestDto.expireYear());
        return creditCard;
    }

    public static CreditCardResponseDto creditCardToCreditCardResponseDto(CreditCard creditCard){
        return new CreditCardResponseDto(creditCard.getNo(),creditCard.getName(),creditCard.getExpireMonth(),creditCard.getExpireYear(),creditCard.getCcv());
    }

}
