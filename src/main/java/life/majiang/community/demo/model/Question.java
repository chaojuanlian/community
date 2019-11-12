package life.majiang.community.demo.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private  Integer creator;
    private Integer viewCount;
    private Integer comentCount;
    private Integer likeCount;
}