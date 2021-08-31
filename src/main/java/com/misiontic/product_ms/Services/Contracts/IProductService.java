package com.misiontic.product_ms.Services.Contracts;

import com.misiontic.product_ms.models.Product;

public interface IProductService {
    Product createProduct(Product product);
    Product modifyProduct(Product product);
}
