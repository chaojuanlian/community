package life.majiang.community.demo.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 状态
 * @author: WangYuChao
 * @create: 2019/12/23 19:44
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1),
    ;
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
