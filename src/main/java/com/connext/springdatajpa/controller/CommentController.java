package com.connext.springdatajpa.controller;

import com.connext.springdatajpa.model.Article;
import com.connext.springdatajpa.model.Comment;
import com.connext.springdatajpa.model.User;
import com.connext.springdatajpa.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/commentController")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/addComment")
    public String addComment(HttpSession session, Comment comment, Article article,RedirectAttributes redirectAttributes){
        comment.setUser((User) session.getAttribute("loginUserInfo"));
        article.setId(Integer.parseInt(session.getAttribute("articleId").toString()));
        comment.setArticle(article);
        this.commentService.addComment(comment);
        redirectAttributes.addAttribute("articleId",session.getAttribute("articleId").toString());
        return "redirect:/articleController/articleDetail";
    }

    @RequestMapping("/deleteMyComment")
    public String deleteMyComment(String articleId,HttpSession session,RedirectAttributes redirectAttributes){
        this.commentService.deleteMyComment(Integer.parseInt(articleId));
        redirectAttributes.addAttribute("articleId",session.getAttribute("articleId").toString());
        return "redirect:/articleController/articleDetail";
    }

}
