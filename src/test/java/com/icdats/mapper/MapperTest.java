package com.icdats.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icdats.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelect(){
        System.out.println(bookMapper.selectById(1));
        Page<Book> customerPage = new Page<>(1,5);
        bookMapper.selectPage(customerPage,null);
    }

}
