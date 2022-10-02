package com.icdats.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icdats.controller.utils.R;
import com.icdats.pojo.Book;
import com.icdats.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public R getAll() {
//        log.debug("debug......");
//        log.info("info........");
//        log.warn("warn........");
//        log.error("error......");
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R(bookService.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true,bookService.getById(id));
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize){
//        Page<Book> bookPage = new Page<>(currentPage,pageSize);
//        bookService.page(bookPage);
//        if(currentPage > bookPage.getPages()){
//            bookPage.setCurrent(bookPage.getPages());
//        }
//        return new R(true,bookService.page(bookPage));
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize , Book book){
        Page<Book> bookPage = new Page<>(currentPage,pageSize);
        bookService.page(bookPage);
        if(currentPage > bookPage.getPages()){
            bookPage.setCurrent(bookPage.getPages());
        }
        return new R(true,bookService.getPage(bookPage,book));
    }
}
