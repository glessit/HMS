package com.handmakestore.service;

import com.handmakestore.common.VO.product.ProductVO;
import com.handmakestore.domain.Product;
import com.handmakestore.service.repository.ProductRepository;
import com.handmakestore.service.type.ProductStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class MarketService {

    private final ProductRepository productRepository;

    @Autowired
    public MarketService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Product createProduct(ProductVO productVO) {


    }

    public Product changeStatus(Long productID, ProductStatus newProductStatus) {



    }
}
