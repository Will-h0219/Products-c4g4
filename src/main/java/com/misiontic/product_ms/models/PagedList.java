package com.misiontic.product_ms.models;

import java.util.ArrayList;

public class PagedList {
    private Integer currentPage;
    private Integer pageSize;
    private Long totalCount;
    private Integer totalPages;

    private ArrayList<Product> data;

    public PagedList(ArrayList<Product> items, Long count, Integer pageNumber, Integer pageSize) {
        currentPage = pageNumber;
        this.pageSize = pageSize;
        totalCount = count;
        totalPages = (pageSize > 0) ? (int) Math.ceil(count / (double) pageSize) : 0;
        data = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<Product> getData() {
        return data;
    }

    public void setData(ArrayList<Product> data) {
        this.data = data;
    }
}
