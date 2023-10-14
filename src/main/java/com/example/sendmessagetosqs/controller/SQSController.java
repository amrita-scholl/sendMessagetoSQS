package com.example.sendmessagetosqs.controller;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.sendmessagetosqs.request.SQSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@RestController
@RequestMapping("/sqs")
public class SQSController {

    @Autowired
    private AmazonSQS sqsClient;

    @PostMapping("/send-message")
    public String sendMessageToSQS(@RequestBody SQSRequest sqsRequest) {
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(sqsRequest.getQueueUrl())
                .withMessageBody(sqsRequest.getMessage());

        sqsClient.sendMessage(request);
        return "Message sent to SQS queue: " + sqsClient.sendMessage(request).getMessageId();
    }
}
