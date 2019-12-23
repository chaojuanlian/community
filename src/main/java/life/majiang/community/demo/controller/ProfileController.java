package life.majiang.community.demo.controller;

import life.majiang.community.demo.dto.PagenationDTO;
import life.majiang.community.demo.model.User;
import life.majiang.community.demo.service.NotificationService;
import life.majiang.community.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }

        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
            PagenationDTO pagenationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pagenation", pagenationDTO);
        }else if("replies".equals(action)){
            PagenationDTO pagenationDTO = notificationService.list(user.getId(), page, size);
            model.addAttribute("pagenation", pagenationDTO);
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");

        }


        return "profile";
    }

}
