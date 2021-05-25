package life.lzjt.community.controller;

import life.lzjt.community.dto.CommentCreateDTO;
import life.lzjt.community.dto.CommentDTO;
import life.lzjt.community.dto.ResultDTO;
import life.lzjt.community.enums.CommentTypeEnum;
import life.lzjt.community.exception.CustomizeErrorCode;
import life.lzjt.community.model.Comment;
import life.lzjt.community.model.User;
import life.lzjt.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 赵志文
 * @date 2021/5/15
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){
          User user = (User) request.getSession().getAttribute("user");
          if (user == null){
              return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
          }

          if (commentCreateDTO == null ||commentCreateDTO.getContent() == null || commentCreateDTO.getContent() == ""){
              return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
          }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);

        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Integer id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
