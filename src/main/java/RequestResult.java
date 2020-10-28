
/**
 * Created by zhongying on 2020/4/22.
 */

public class RequestResult {
    /** 状态码 */
    private int code;

    /** 返回body */
    private  String body;

    public RequestResult(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
