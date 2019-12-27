package life.majiang.community.demo.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: QuestionQueryDTO
 * @description:
 * @author: WangYuChao
 * @create: 2019/12/26 21:35
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
