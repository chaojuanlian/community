package life.majiang.community.demo.dto;

import life.majiang.community.demo.model.User;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: CommentDTO
 * @description: 服务于数据库传递参数
 * @author: WangYuChao
 * @create: 2019/12/11 19:37
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private Integer commentCount;
    private User user;
}
