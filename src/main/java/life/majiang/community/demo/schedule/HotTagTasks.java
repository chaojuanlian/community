package life.majiang.community.demo.schedule;

import life.majiang.community.demo.cache.HotTagCache;
import life.majiang.community.demo.mapper.QuestionMapper;
import life.majiang.community.demo.model.Question;
import life.majiang.community.demo.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.security.auth.kerberos.KerberosKey;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: HotTagTasks
 * @description: 热门标签定时任务
 * @author: WangYuChao
 * @create: 2019/12/27 21:54
 */
@Component
@Slf4j
public class HotTagTasks {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "5 0 0 * * *")
    public void reportCurrentTime(){
        int offset = 0;
        int limit = 5;
        log.info("The time is now {}", new Date());
        List<Question> list = new ArrayList<>();

        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit){
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(),new RowBounds(offset,limit));
            for (Question question : list) {

                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null) {
                        priorities.put(tag, priority + 5 + question.getCommentCount());
                    } else {
                        priorities.put(tag, 5 + question.getCommentCount());
                    }
                }
            }
            offset += limit;
        }
        hotTagCache.setTags(priorities);
        hotTagCache.getTags().forEach(
                (k,v)->{
                    System.out.print(k);
                    System.out.print(":");
                    System.out.print(v);
                    System.out.println();
                }
        );

        log.info("The time is now {}", new Date());
    }
}
