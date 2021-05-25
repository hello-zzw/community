package life.lzjt.community.dto;

import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/12
 */
@Data
public class CommentCreateDTO {
    private Integer parentId;
    private String content;
    private Integer type;
}
