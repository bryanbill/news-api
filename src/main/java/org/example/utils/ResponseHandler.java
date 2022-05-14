package org.example.utils;

import org.example.interfaces.IResponse;
import org.sonatype.inject.Nullable;

public class ResponseHandler implements IResponse {
    private int status;
    private String message;
    private Object data;

    public ResponseHandler(@Nullable int status, @Nullable String message, @Nullable Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * @param status
     */
    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @param message
     */
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param data
     */
    @Override
    public void setData(Object data) {
        this.data = data;
    }
}
