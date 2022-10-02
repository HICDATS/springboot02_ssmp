package com.icdats.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSelect(){
        System.out.println(bookService.getById(1));
    }
}
