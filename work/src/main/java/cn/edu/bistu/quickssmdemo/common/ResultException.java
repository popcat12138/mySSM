package cn.edu.bistu.quickssmdemo.common;


public class ResultException extends RuntimeException {
    private String code;

    public ResultException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}