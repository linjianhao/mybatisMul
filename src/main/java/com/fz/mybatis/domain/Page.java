package com.fz.mybatis.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**分页模型类
 * Created by Administrator on 2017/4/12.
 */
@Data
public class Page<T> {
    private int totalPage;     // total pages
    private int pageSize = 2; // page Size
    private int totalRecord;   // total record
    private int currentPage = 1;  // current page
    private int startIndex;
    private List<T> list = new ArrayList<T>();  // page data
    private int startPage;
    private int endPage;

    public Page(int currentPage, int totalRecord) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;

        this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;

        // get data from startIndex in DB
        this.startIndex = (this.currentPage - 1) * this.pageSize;

        if (this.totalPage < 10) {
            this.startPage = 1;
            this.endPage = this.totalPage;
        } else {
            this.startPage = currentPage - 4;
            this.endPage = currentPage + 5;

            if (this.startPage < 1) {
                this.startPage = 1;
                this.endPage = 10;
            }

            if (this.endPage > this.totalPage) {
                this.endPage = this.totalPage;
                this.startPage = this.totalPage - 9;
            }
        }
    }
}
