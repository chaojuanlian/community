package life.majiang.community.demo.dto;

import life.majiang.community.demo.model.User;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: NotificationDTO
 * @description: 回复DTO
 * @author: WangYuChao
 * @create: 2019/12/23 20:07
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outid;
    private String typeName;
    private Integer type;
}
