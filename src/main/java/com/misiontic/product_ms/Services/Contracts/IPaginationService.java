package com.misiontic.product_ms.Services.Contracts;

import com.misiontic.product_ms.models.PagedList;
import com.misiontic.product_ms.models.PagingParameters;

public interface IPaginationService {
    PagedList getPagination(PagingParameters pagingParameters);
}
