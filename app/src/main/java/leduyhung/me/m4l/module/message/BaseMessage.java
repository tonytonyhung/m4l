package leduyhung.me.m4l.module.message;

public abstract class BaseMessage {

    private StatusResponse status;
    private String message;
    private int fromId;

    public enum StatusResponse {
        SUCCESS,
        NOT_FOUND,
        NO_INTERNET_CONNECTED,
        TIMEOUT_SOCKET,
        MAINTAIN
    }

    public BaseMessage(StatusResponse status, String message, int fromId) {
        this.status = status;
        this.message = message;
        this.fromId = fromId;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getFromId() {
        return fromId;
    }
}