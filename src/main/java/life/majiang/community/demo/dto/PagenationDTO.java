package life.majiang.community.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagenationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevions;    //上一页按钮
    private boolean showFirstPage;   //第一页按钮
    private boolean showNext;        //下一页按钮
    private boolean showEndPage;     //最后一页按钮

    private Integer page;            //当前页
    private Integer totalPage;       //总页数

    private List<Integer> pages = new ArrayList<>();     //页面页数集合

    public void setePagenation(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevions = false;
        } else {
            showPrevions = true;
        }
        // 是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }
}
