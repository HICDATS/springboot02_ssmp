package com.icdats.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icdats.pojo.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 17802
 * @description 针对表【tbl_book】的数据库操作Service
 * @createDate 2022-09-20 11:58:40
 */
public interface BookService extends IService<Book> {

    public Page<Book> getPage(Page<Book> page, Book book);

}
