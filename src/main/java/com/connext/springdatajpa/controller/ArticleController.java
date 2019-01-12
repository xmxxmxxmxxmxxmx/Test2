package com.connext.springdatajpa.controller;


import com.connext.springdatajpa.annotation.AopAnnotation;
import com.connext.springdatajpa.model.Article;
import com.connext.springdatajpa.model.User;
import com.connext.springdatajpa.service.ArticleService;
import com.connext.springdatajpa.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/articleController")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;

    //进入文章乐园
    @RequestMapping("/toArticlePark")
    public String toArticlePark(Model model){
        model.addAttribute("article",this.articleService.queryAllArticle());
        return "article_park";
    }

    //从文章乐园进入文章详细界面
    @RequestMapping("/articleDetail")
    public String articleDetail(String articleId, Model model, HttpSession session){
        session.setAttribute("articleId",articleId);
        model.addAttribute("comment",this.commentService.queryCommentByArticleId(Integer.parseInt(articleId)));
        model.addAttribute("article",this.articleService.queryOneArticleDetail(Integer.parseInt(articleId)));
        return "article_detail";
    }

    @RequestMapping("/toArticleAdd")
    public String toArticleAdd() {
        return "message_add";
    }


    @RequestMapping("/queryArticle")
    public String queryArticle(Model model, HttpSession session) {
        model.addAttribute("messagelist", this.articleService.queryArticleByUserId(((User) session.getAttribute("loginUserInfo")).getId()));
        return "message_list";
    }

    @RequestMapping("/deleteOne")
    @AopAnnotation(value = "用户删除消息")
    public String deleteOne(Integer articleId) {
        this.articleService.deleteOne(articleId);
        return "redirect:queryArticle";
    }

    @RequestMapping("/see")
    public String see(Integer articleId, Model model) {
        model.addAttribute("messagedetail", this.articleService.editOne(articleId));
        return "message_detail";
    }

    @RequestMapping("/inDeleteOne")
    public String indeleteOne(Integer articleId) {
        this.articleService.deleteOne(articleId);
        return "redirect:queryArticle";
    }

    @RequestMapping("preUpdate")
    public String preUpdate(Integer articleId, Model model) {
        model.addAttribute("messagedetail", this.articleService.editOne(articleId));
        return "message_update";
    }

    @RequestMapping("update")
    @AopAnnotation(value = "用户修改消息")
    public String updateArticle(Article article,String date,HttpSession session) {
        article.setUser(((User) session.getAttribute("loginUserInfo")));
        this.articleService.updateArticle(article);
        return "redirect:queryArticle";
    }


    @RequestMapping(value = "/addArticle")
    public String addmessage(Article article, HttpSession session){
        article.setUser(((User) session.getAttribute("loginUserInfo")));
        this.articleService.addArticle(article);
        return "redirect:queryArticle";
    }


}
