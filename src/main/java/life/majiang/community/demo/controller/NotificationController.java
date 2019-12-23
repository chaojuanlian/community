package life.majiang.community.demo.controller;

import life.majiang.community.demo.dto.NotificationDTO;
import life.majiang.community.demo.dto.PagenationDTO;
import life.majiang.community.demo.enums.NotificationTypeEnum;
import life.majiang.community.demo.mapper.NotificationMapper;
import life.majiang.community.demo.model.User;
import life.majiang.community.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: NotificationController
 * @description: 回复控制
 * @author: WangYuChao
 * @create: 2019/12/23 21:51
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOutid();
        }else{
            return "redirect:/";
        }
    }
}
