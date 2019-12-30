package life.majiang.community.demo.cache;

import life.majiang.community.demo.dto.TagDTO;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.omg.IOP.TAG_CODE_SETS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: TagCache
 * @description: 标签缓存
 * @author: WangYuChao
 * @create: 2019/12/16 23:04
 */
public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOs = new ArrayList<>();
        TagDTO front = new TagDTO();
        front.setCatagoryName("前端");
        front.setTags(Arrays.asList("javascript","前端","vue.js","css","html","html5","node.js","react.js","jquery","css3","es6","typescript","chrome","npm","bootstrap","sass","less","chrome-devtools","firefox","angular","coffeescript","safari","postcss","postman","fiddler","webkit","yarn","firebug","edge"));
        tagDTOs.add(front);


        TagDTO later = new TagDTO();
        later.setCatagoryName("后端");
        later.setTags(Arrays.asList("php","java","node.js","python","c++","c","golang","spring","django","flask","springboot","后端","c#","swoole","ruby","asp.net","ruby-on-rails","scala","rust","lavarel","爬虫"));
        tagDTOs.add(later);




        TagDTO move = new TagDTO();
        move.setCatagoryName("移动端");
        move.setTags(Arrays.asList("android","ios","objective-c","小程序","swift","react-native","xcode","android-studio","webapp","flutter","kotlin"));
        tagDTOs.add(move);



        TagDTO db = new TagDTO();
        db.setCatagoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","数据库","json","elasticsearch","nosql","memcached","postgresql","sqlite","mariadb"));
        tagDTOs.add(db);




        TagDTO transport = new TagDTO();
        transport.setCatagoryName("运输");
        transport.setTags(Arrays.asList("linux","nginx","docker","apache","centos","ubunt","服务器负载均衡","运维","ssh","vagrant","容器","jenkins","devops","debian","fabric"));
        tagDTOs.add(transport);



        TagDTO ai = new TagDTO();
        ai.setCatagoryName("人工智能");
        ai.setTags(Arrays.asList("算法","机器学习","人工智能","深度学习","数据挖掘","tensorflow","神经网络","图像识别","自然语言","处理人脸识别","机器人","pytorch","自动驾驶"));
        tagDTOs.add(ai);


        TagDTO tool = new TagDTO();
        tool.setCatagoryName("工具");
        tool.setTags(Arrays.asList("git","github","macos","visual-studio-code","windows","vim","sublime-text","intellij-idea","eclipse","phpstorm","webstorm","编辑器","svnvisual-studio","pycharm","emacs"));
        tagDTOs.add(tool);



        TagDTO other = new TagDTO();
        other.setCatagoryName("其他");
        other.setTags(Arrays.asList("程序员","http","segmentfault","https","安全","websocket","restful","xss","区块链","csrf","graphql","rpc","比特币","以太坊","udp","智能合约"));
        tagDTOs.add(other);

        return tagDTOs;
    }

    public static String filterInValid(String tags){
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
