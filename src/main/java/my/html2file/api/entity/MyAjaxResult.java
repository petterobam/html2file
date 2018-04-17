package my.html2file.api.entity;

public class MyAjaxResult {
    public static final int SUCCESS = 1;
    public static final int FAIL = -1;
    /**
     * 状态
     */
    private int status = SUCCESS;
    /**
     * 结果
     */
    private Object result;
    /**
     * 错误信息
     */
    private String errorMsg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
