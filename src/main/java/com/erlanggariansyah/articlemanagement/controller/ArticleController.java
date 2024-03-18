package com.erlanggariansyah.articlemanagement.controller;

import com.erlanggariansyah.articlemanagement.constant.FieldConstant;
import com.erlanggariansyah.articlemanagement.constant.GeneralConstant;
import com.erlanggariansyah.articlemanagement.exception.throwable.BadRequestException;
import com.erlanggariansyah.articlemanagement.exception.throwable.NotFoundException;
import com.erlanggariansyah.articlemanagement.model.Article;
import com.erlanggariansyah.articlemanagement.service.ArticleService;
import com.erlanggariansyah.articlemanagement.util.LogUtil;
import com.erlanggariansyah.articlemanagement.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@Slf4j
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(FieldConstant.ID) @Nullable Integer id) throws NotFoundException, BadRequestException {
        log.info(LogUtil.startLog(GeneralConstant.GET, this.getClass().getSimpleName()));

        Object article = articleService.get(id);

        log.info(LogUtil.endLog(GeneralConstant.GET, this.getClass().getSimpleName()));
        return ResponseUtil.ok(article);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Article article) throws BadRequestException {
        log.info(LogUtil.startLog(GeneralConstant.POST, this.getClass().getSimpleName()));

        articleService.post(article);

        log.info(LogUtil.endLog(GeneralConstant.POST, this.getClass().getSimpleName()));
        return ResponseUtil.ok();
    }

    @PutMapping
    public ResponseEntity<?> update(
            @RequestParam(FieldConstant.ID) @Nullable Integer id,
            @RequestParam(FieldConstant.TITLE) @Nullable String title,
            @RequestParam(FieldConstant.DESCRPITION) @Nullable String description
    ) throws BadRequestException, NotFoundException {
        log.info(LogUtil.startLog(GeneralConstant.UPDATE, this.getClass().getSimpleName()));

        articleService.update(id, title, description);

        log.info(LogUtil.endLog(GeneralConstant.UPDATE, this.getClass().getSimpleName()));
        return ResponseUtil.ok();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(FieldConstant.ID) @Nullable Integer id) throws BadRequestException, NotFoundException {
        log.info(LogUtil.startLog(GeneralConstant.DELETE, this.getClass().getSimpleName()));

        articleService.delete(id);

        log.info(LogUtil.endLog(GeneralConstant.DELETE, this.getClass().getSimpleName()));
        return ResponseUtil.ok();
    }
}
