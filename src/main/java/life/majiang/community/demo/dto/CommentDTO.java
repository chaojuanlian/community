package life.majiang.community.demo.dto;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: CommentDTO
 * @description: 问题回复业务模型
 * @author: WangYuChao
 * @create: 2019/12/1 22:35
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
