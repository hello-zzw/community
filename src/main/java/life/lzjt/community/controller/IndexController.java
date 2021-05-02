package life.lzjt.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 赵志文
 * @date 2021/5/2
 */
//自动把类作为spring的一个Bean进行管理，允许这个类接收前端的请求
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
