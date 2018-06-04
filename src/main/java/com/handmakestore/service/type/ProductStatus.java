package com.handmakestore.service.type;

public enum ProductStatus {

    // if product has been created we set NEW status for next 1 hour
    NEW,
    // after one hour after we will change status to CREATED.
    CREATED,
    // we will set this status if found some problem with product description or something
    UNKNOWN,
    // if product no more showing on market
    CLOSE
}
