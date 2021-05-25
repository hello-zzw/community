package life.lzjt.community.enums;

/**
 * @author 赵志文
 * @date 2021/5/13
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType(){
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()){
            if (commentTypeEnum.getType() == type){
                return false;
            }
        }
        return true;
    }
}
