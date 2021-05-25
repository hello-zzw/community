package life.lzjt.community.dto;

import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/4
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
