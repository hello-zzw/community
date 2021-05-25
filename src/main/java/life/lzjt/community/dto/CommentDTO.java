package life.lzjt.community.dto;

import life.lzjt.community.model.User;
import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/17
 */
@Data
public class CommentDTO {
    private Integer id;
    private Integer parentId;
    private Integer type;
    private Integer commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
