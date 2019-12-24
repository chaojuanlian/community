package life.majiang.community.demo.controller;

import life.majiang.community.demo.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: FielController
 * @description: 上传图片/文件
 * @author: WangYuChao
 * @create: 2019/12/24 21:43
 */
@Controller
public class FielController {
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/wechat.jpg");
        return fileDTO;
    }


}
