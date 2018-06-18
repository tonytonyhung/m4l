package leduyhung.me.m4l.module.user.message;

public class MessageForActivity {

    private ConstantMessage code;
    private String message;

    public enum ConstantMessage {
        CODE_FACEBOOK_BUTTON_CLICK,
        CODE_LOGIN_FACEBOOK_SUCCESS,
        CODE_LOGIN_FACEBOOK_CANCEL,
        CODE_LOGIN_FACEBOOK_FAIL,
        CODE_LOGIN_SERVER_SUCCESS,
        CODE_LOGIN_SERVER_FAIL
    }

    public MessageForActivity(ConstantMessage code, String message) {
        this.code = code;
        this.message = message;
    }

    public ConstantMessage getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
