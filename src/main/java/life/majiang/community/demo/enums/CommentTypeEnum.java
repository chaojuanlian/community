package life.majiang.community.demo.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 评论 父类类型
 * @author: WangYuChao
 * @create: 2019/12/2 21:23
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
