package br.com.academy.hrpayroll.mapper;

import br.com.academy.hrpayroll.entity.Payment;
import br.com.academy.hrpayroll.model.PaymentResponse;
import org.modelmapper.ModelMapper;

public class PaymentMapper {

    public static PaymentResponse toModel(Object entity) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(entity, PaymentResponse.class);
    }

    public static Payment toEntity(Object model) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(model, Payment.class);
    }
}
