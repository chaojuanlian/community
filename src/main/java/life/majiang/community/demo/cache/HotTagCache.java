package life.majiang.community.demo.cache;

import life.majiang.community.demo.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

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
    private List<String> hots = new ArrayList<>();

    public void updataTags(Map<String,Integer> tags){
        int max = 3; // 默认热门标签最大数
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);

        tags.forEach((name,priority)->{
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size()<max){
                priorityQueue.add(hotTagDTO);
            }else {
                HotTagDTO minHot = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHot)>0){
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        List<String> sortedTags = new ArrayList<>();

        HotTagDTO poll = priorityQueue.poll();
        while (poll!= null){
            sortedTags.add(0,poll.getName());
            poll = priorityQueue.poll();
        }
        hots = sortedTags;
        System.out.println(hots);


    }
}
