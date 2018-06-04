package com.handmakestore.common.mapper;

import com.handmakestore.common.VO.account.AccountVO;
import com.handmakestore.domain.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccountVO toVO(Account account) {
        return modelMapper.map(account, AccountVO.class);
    }
}
