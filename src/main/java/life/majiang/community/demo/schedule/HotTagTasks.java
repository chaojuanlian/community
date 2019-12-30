package life.majiang.community.demo.schedule;

import life.majiang.community.demo.mapper.QuestionMapper;
import life.majiang.community.demo.model.Question;
import life.majiang.community.demo.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "5 0 0 * * *")
    public void reportCurrentTime(){
        int offset = 0;
        int limit = 5;
        log.info("The time is now {}", new Date());
        List<Question> list = new ArrayList<>();
        while (offset == 0 || list.size() == limit){
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(),new RowBounds(offset,limit));
            for (Question question : list) {
                log.info("list quesiton : {}",question.getId());
            }
            offset += limit;
        }

        log.info("The time is now {}", new Date());
    }
}
