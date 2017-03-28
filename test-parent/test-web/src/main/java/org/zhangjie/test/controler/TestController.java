package org.zhangjie.test.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zhangjie.test.inter.IArticleOption;
import org.zhangjie.test.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private IArticleOption<Article> articleDao;
	
	
	//localhost:8080/test/to
	@RequestMapping("/to")
	public String toTest(HttpServletRequest request){
		List<Article> list = articleDao.selectUserArticles(1);
		for(Article a:list)
		{
			System.out.println(a.getTitle());
			System.out.println(a.getUser().getUserName());
		}
		return "test";
	}
}
