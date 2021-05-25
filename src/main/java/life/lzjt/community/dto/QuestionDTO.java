package life.lzjt.community.dto;

import life.lzjt.community.model.User;
import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/7
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
