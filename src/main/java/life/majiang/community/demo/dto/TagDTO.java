package life.majiang.community.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: TagDTO
 * @description: tag传输model
 * @author: WangYuChao
 * @create: 2019/12/16 23:08
 */
@Data
public class TagDTO {
    private String catagoryName;
    private List<String> tags;
}
