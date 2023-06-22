package org.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Main {

    public static void sendMessage(AmazonSQS client) {
        client.sendMessage(new SendMessageRequest()
                .withMessageBody("asdf")
                .withQueueUrl("MyMessage"));
    }

    public static AmazonSQS getSQSClient(String localstackVersion) {
        var endpointConfiguration = new AwsClientBuilder.EndpointConfiguration("http://localhost:14" + localstackVersion, "eu-west-1");
        return AmazonSQSClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("test", "test")))
                .build();
    }
}