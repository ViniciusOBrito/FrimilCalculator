package com.frimil.frimilcalculator.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private int status;
    private String mensagem;
    private long timestamp;

    public ErrorResponse(int status, String mensagem, long timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

}
