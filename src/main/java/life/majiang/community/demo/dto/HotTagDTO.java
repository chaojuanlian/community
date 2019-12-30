package life.majiang.community.demo.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: HotTagDTO
 * @description: 热门标签
 * @author: WangYuChao
 * @create: 2019/12/30 21:09
 */
@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;

    @Override
    public int compareTo(@NotNull Object o) {
        return this.priority - ((HotTagDTO)o).getPriority();
    }
}
