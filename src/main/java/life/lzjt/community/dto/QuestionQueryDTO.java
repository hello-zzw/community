package life.lzjt.community.dto;

import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/24
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
