package life.lzjt.community.dto;

import lombok.Data;

/**
 * @author 赵志文
 * @date 2021/5/22
 */
@Data
public class NotificationDTO {
    private Integer id;
    private Long gmtCreate;
    private Integer status;
    private Integer notifier;
    private String notifierName;
    private String outerTitle;
    private Integer outerId;
    private String typeName;
    private Integer type;
}
