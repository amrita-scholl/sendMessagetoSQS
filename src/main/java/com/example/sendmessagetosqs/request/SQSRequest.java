package com.example.sendmessagetosqs.request;

import org.springframework.beans.factory.annotation.Value;

public class SQSRequest {

    public String getQueueUrl() {
        return queueUrl;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Value("${sqs.queueUrl}")
    private String queueUrl;
    private String message;
}
