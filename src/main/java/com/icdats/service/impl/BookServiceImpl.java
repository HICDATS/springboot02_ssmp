package com.icdats.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icdats.pojo.Book;
import com.icdats.service.BookService;
import com.icdats.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 17802
 * @description 针对表【tbl_book】的数据库操作Service实现
 * @createDate 2022-09-20 11:58:40
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> getPage(Page<Book> page, Book book) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(StringUtils.isNotBlank(book.getType()),Book::getType,book.getType());
        bookLambdaQueryWrapper.like(StringUtils.isNotBlank(book.getName()),Book::getName,book.getName());
        bookLambdaQueryWrapper.like(StringUtils.isNotBlank(book.getDescription()),Book::getDescription,book.getDescription());
        return bookMapper.selectPage(page,bookLambdaQueryWrapper);
    }
}




