package life.majiang.community.demo.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @program: CustomizeException
 * @description: 自定义异常
 * @author: WangYuChao
 * @create: 2019/11/29 20:19
 */
public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(iCustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
