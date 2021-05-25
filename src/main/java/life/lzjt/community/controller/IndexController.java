package life.lzjt.community.controller;

import life.lzjt.community.dto.PaginationDTO;
import life.lzjt.community.mapper.UserMapper;
import life.lzjt.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 赵志文
 * @date 2021/5/2
 */
//自动把类作为spring的一个Bean进行管理，允许这个类接收前端的请求
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "4") Integer size,
                        @RequestParam(name = "search", required = false) String search){
        PaginationDTO pagination = questionService.list(search, page, size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("search", search);
        return "index";
    }
}
