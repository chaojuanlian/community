package life.majiang.community.demo.exception;

public enum CustomizeErrorCode implements iCustomizeErrorCode{
    QUESTION_NOT_FOUND("你找的问题不在了，要不要换个试试？");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
