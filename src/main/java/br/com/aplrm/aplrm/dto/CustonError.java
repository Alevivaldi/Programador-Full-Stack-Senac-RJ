package br.com.aplrm.aplrm.dto;

import java.time.Instant;

public class CustonError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private String trace;

    public CustonError(Instant timestamp, Integer status, String error, String path, String trace) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.trace = trace;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public String getTrace() {
        return trace;
    }
}
