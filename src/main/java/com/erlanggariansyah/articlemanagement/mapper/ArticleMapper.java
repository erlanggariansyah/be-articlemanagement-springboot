package com.erlanggariansyah.articlemanagement.mapper;

import com.erlanggariansyah.articlemanagement.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("SELECT * FROM articles")
    List<Article> findAll();

    @Select("SELECT * FROM articles WHERE id = #{id}")
    Article findById(Integer id);

    @Insert("INSERT INTO articles(title, description, author) VALUES(#{title}, #{description}, #{author})")
    void save(Article article);

    @Delete("DELETE FROM articles WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE articles SET title = #{title}, description = #{description} WHERE id = #{id}")
    void update(Integer id, String title, String description);
}
