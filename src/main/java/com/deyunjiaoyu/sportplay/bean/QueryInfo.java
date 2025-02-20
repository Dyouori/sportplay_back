package com.deyunjiaoyu.sportplay.bean;

public class QueryInfo {
    private String query;//username
    private int pageStart=1;//当前页数
    private int pageSize=1;//一页多少个，最大数
    private int queryId;

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", pageNum=" + pageStart +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
