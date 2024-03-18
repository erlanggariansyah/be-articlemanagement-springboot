package com.erlanggariansyah.articlemanagement.service;

import com.erlanggariansyah.articlemanagement.constant.FieldConstant;
import com.erlanggariansyah.articlemanagement.constant.GeneralConstant;
import com.erlanggariansyah.articlemanagement.constant.MessageConstant;
import com.erlanggariansyah.articlemanagement.exception.throwable.BadRequestException;
import com.erlanggariansyah.articlemanagement.exception.throwable.NotFoundException;
import com.erlanggariansyah.articlemanagement.mapper.ArticleMapper;
import com.erlanggariansyah.articlemanagement.model.Article;
import com.erlanggariansyah.articlemanagement.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public Object get(Integer id) throws NotFoundException {
        log.info(LogUtil.startLog(GeneralConstant.GET, this.getClass().getSimpleName()));

        if (id == null) {
            List<Article> articles = articleMapper.findAll();
            return articles;
        }

        Article article = articleMapper.findById(id);
        if (article == null)
            throw new NotFoundException(FieldConstant.ID, MessageConstant.NOT_FOUND);

        log.info(LogUtil.endLog(GeneralConstant.GET, this.getClass().getSimpleName()));
        return article;
    }

    public void post(Article article) throws BadRequestException {
        log.info(LogUtil.startLog(GeneralConstant.POST, this.getClass().getSimpleName()));

        if (article.getTitle() == null || article.getTitle().isEmpty())
            throw new BadRequestException(FieldConstant.TITLE, MessageConstant.MANDATORY);
        if (article.getAuthor() == null || article.getAuthor().isEmpty())
            throw new BadRequestException(FieldConstant.AUTHOR, MessageConstant.MANDATORY);
        if (article.getDescription() == null || article.getDescription().isEmpty())
            throw new BadRequestException(FieldConstant.DESCRPITION, MessageConstant.MANDATORY);

        articleMapper.save(article);

        log.info(LogUtil.endLog(GeneralConstant.POST, this.getClass().getSimpleName()));
    }

    public void delete(Integer id) throws BadRequestException, NotFoundException {
        log.info(LogUtil.startLog(GeneralConstant.DELETE, this.getClass().getSimpleName()));

        if (id == null)
            throw new BadRequestException(FieldConstant.ID, MessageConstant.MANDATORY);

        Article article = articleMapper.findById(id);
        if (article == null)
            throw new NotFoundException(FieldConstant.ID, MessageConstant.NOT_FOUND);

        articleMapper.delete(id);

        log.info(LogUtil.endLog(GeneralConstant.DELETE, this.getClass().getSimpleName()));
    }

    public void update(Integer id, String title, String description) throws BadRequestException, NotFoundException {
        log.info(LogUtil.startLog(GeneralConstant.UPDATE, this.getClass().getSimpleName()));

        if (id == null)
            throw new BadRequestException(FieldConstant.ID, MessageConstant.MANDATORY);
        if (title == null || title.isEmpty())
            throw new BadRequestException(FieldConstant.TITLE, MessageConstant.MANDATORY);
        if (description == null || description.isEmpty())
            throw new BadRequestException(FieldConstant.DESCRPITION, MessageConstant.MANDATORY);

        Article article = articleMapper.findById(id);
        if (article == null)
            throw new NotFoundException(FieldConstant.ID, MessageConstant.NOT_FOUND);

        articleMapper.update(id, title, description);

        log.info(LogUtil.endLog(GeneralConstant.UPDATE, this.getClass().getSimpleName()));
    }
}
