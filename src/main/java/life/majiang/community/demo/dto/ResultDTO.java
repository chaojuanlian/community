package life.majiang.community.demo.dto;

import life.majiang.community.demo.exception.CustomizeErrorCode;
import life.majiang.community.demo.exception.CustomizeException;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: ResultDTO
 * @description: 返回结果
 * @author: WangYuChao
 * @create: 2019/12/2 21:12
 */
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode noLogin) {
        return errorOf(noLogin.getCode(), noLogin.getMessage());
    }
    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }
    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功！");
        return resultDTO;
    }

    public static <T> ResultDTO okOf(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功！");
        resultDTO.setData(t);
        return resultDTO;
    }

}
