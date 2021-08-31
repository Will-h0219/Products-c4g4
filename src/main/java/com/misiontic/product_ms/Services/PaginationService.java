package com.misiontic.product_ms.Services;

import com.misiontic.product_ms.Services.Contracts.IPaginationService;
import com.misiontic.product_ms.exceptions.products.ProductNotFoundException;
import com.misiontic.product_ms.models.PagedList;
import com.misiontic.product_ms.models.PagingParameters;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PaginationService implements IPaginationService {
    private final ProductRepository productRepository;

    public PaginationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PagedList getPagination(PagingParameters pagingParameters) {
        if (pagingParameters.getUserId() == null) {
            throw new ProductNotFoundException("Error con userId");
        }
        ArrayList<Product> products;
        Long count;
        if (pagingParameters.getSearchParam() != null) {
            products = productRepository.findByUserIdAndProductNameRegexOrderByProductId(pagingParameters.getUserId(), pagingParameters.getSearchParam().toUpperCase())
                    .stream().skip((pagingParameters.getPageNumber() - 1) * pagingParameters.getPageSize())
                    .limit(pagingParameters.getPageSize())
                    .collect(Collectors.toCollection(ArrayList::new));
            count = productRepository.countByUserIdAndProductNameRegex(pagingParameters.getUserId(), pagingParameters.getSearchParam().toUpperCase());
        } else {
            products = productRepository.findByUserIdOrderByProductId(pagingParameters.getUserId())
                    .stream().skip((pagingParameters.getPageNumber() - 1) * pagingParameters.getPageSize())
                    .limit(pagingParameters.getPageSize())
                    .collect(Collectors.toCollection(ArrayList::new));
            count = productRepository.countByUserId(pagingParameters.getUserId());
        }

        return new PagedList(products, count, pagingParameters.getPageNumber(), pagingParameters.getPageSize());
    }
}
