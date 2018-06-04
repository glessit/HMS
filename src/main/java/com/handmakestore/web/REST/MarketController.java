package com.handmakestore.web.REST;

import com.handmakestore.common.VO.product.ProductVO;
import com.handmakestore.common.mapper.MarketMapper;
import com.handmakestore.domain.Product;
import com.handmakestore.service.ErrorUtil;
import com.handmakestore.service.MarketService;
import com.handmakestore.service.type.ProductStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(
        value = "/api/v1/market",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
@Slf4j
public class MarketController {

    private final MarketService marketService;
    private final MarketMapper marketMapper;

    @Autowired
    public MarketController(MarketService marketService, MarketMapper marketMapper) {
        this.marketService = marketService;
        this.marketMapper = marketMapper;
    }

    /**
     * Create product on market
     * @param productVO
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/product")
    public ResponseEntity<ProductVO> addProduct(
            @Valid ProductVO productVO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw ErrorUtil.validationException(bindingResult.getAllErrors());
        }

        Product result = marketService.createProduct(productVO);
        return new ResponseEntity<>(marketMapper.toProductVO(result), HttpStatus.CREATED);
    }

    /**
     * Change status of product
     * @param productID
     * @param newProductStatus
     * @return
     */
    @PutMapping(value = "/product/{productID}/status")
    public ResponseEntity<ProductVO> changeStatus(
            @PathVariable("productID") Long productID,
            @RequestBody ProductStatus newProductStatus) {

        Product result = marketService.changeStatus(productID, newProductStatus);
        return new ResponseEntity<>(marketMapper.toProductVO(result), HttpStatus.OK);
    }

    @GetMapping(value = "/product/news")
    public ResponseEntity<Set<ProductVO>> getNewsProducts() {

    }
}
