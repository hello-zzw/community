package life.lzjt.community.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * @author 赵志文
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
