package life.lzjt.community.dto;

import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/4
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
