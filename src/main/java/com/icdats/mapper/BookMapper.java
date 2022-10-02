package com.icdats.mapper;

import com.icdats.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 17802
* @description 针对表【tbl_book】的数据库操作Mapper
* @createDate 2022-09-20 11:58:40
* @Entity com.icdats.pojo.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




