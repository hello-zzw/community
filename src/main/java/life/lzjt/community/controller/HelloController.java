package life.lzjt.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

/**
 * @author 赵志文
 * @date 2021/5/2
 */
//自动把类作为spring的一个Bean进行管理，允许这个类接收前端的请求
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",required = false,defaultValue = "world")
    String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
