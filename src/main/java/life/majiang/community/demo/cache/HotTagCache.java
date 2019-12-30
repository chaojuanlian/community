package life.majiang.community.demo.cache;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: HotTagCache
 * @description: 热门标签缓存
 * @author: WangYuChao
 * @create: 2019/12/30 20:45
 */
@Component
@Data
public class HotTagCache {
    private Map<String,Integer> tags = new HashMap<>();
}
