package com.misiontic.product_ms.models;

public class PagingParameters {
    final Integer maxPageSize = 50;
    final Integer minPageSize = 10;
    private Integer pageNumber;
    private Integer PageSize;
    private String searchParam;
    private String userId;

    public PagingParameters(Integer pageNumber, Integer pageSize, String searchParam, String userId) {
        this.pageNumber = pageNumber;
        PageSize = (pageSize > maxPageSize) ? maxPageSize : (pageSize <= 0 || pageSize == null) ? minPageSize : pageSize;
        this.searchParam = searchParam;
        this.userId = userId;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
