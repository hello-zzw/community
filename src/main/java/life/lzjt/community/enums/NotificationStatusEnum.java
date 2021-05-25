package life.lzjt.community.enums;

/**
 *
 * @author codedrinker
 * @date 2019/6/14
 */
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
