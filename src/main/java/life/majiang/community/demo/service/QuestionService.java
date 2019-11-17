package life.majiang.community.demo.service;

import life.majiang.community.demo.dto.PagenationDTO;
import life.majiang.community.demo.dto.QuestionDTO;
import life.majiang.community.demo.mapper.QuestionMapper;
import life.majiang.community.demo.mapper.UserMapper;
import life.majiang.community.demo.model.Question;
import life.majiang.community.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PagenationDTO list(Integer page, Integer size) {
        PagenationDTO pagenationDTO = new PagenationDTO();
        Integer totalCount = questionMapper.count();
        pagenationDTO.setePagenation(totalCount,page,size);

        if(page < 1){
            page = 1;
        }
        if(page > pagenationDTO.getTotalPage()){
            page = pagenationDTO.getTotalPage();
        }


        //5*i-1  size * (page-1)
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pagenationDTO.setQuestions(questionDTOList);
        return pagenationDTO;
    }
}
