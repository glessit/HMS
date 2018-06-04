package com.handmakestore.common.mapper;

import com.handmakestore.common.VO.product.ProductVO;
import com.handmakestore.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarketMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MarketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductVO toProductVO(Product product) {
        return modelMapper.map(product, ProductVO.class);
    }
}
