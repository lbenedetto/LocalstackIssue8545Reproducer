package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SendMessageTest {
    @Test
    void testListQueuesWithLocalstack202() {
        var sqsClient = Main.getSQSClient("202");
        var queues = sqsClient.listQueues().getQueueUrls();

        assertEquals(1, queues.size());
        assertEquals("http://localhost:14202/000000000000/MyMessage", queues.get(0));
    }

    @Test
    void testListQueuesWithLocalstack232() {
        var sqsClient = Main.getSQSClient("232");
        var queues = sqsClient.listQueues().getQueueUrls();

        assertEquals(1, queues.size());
        assertEquals("http://localhost:14232/000000000000/MyMessage", queues.get(0));
    }

    @Test
    void testSendMessageWithLocalstack202() {
        var sqsClient = Main.getSQSClient("202");
        Main.sendMessage(sqsClient);
    }

    @Test
    void testSendMessageWithLocalstack232() {
        var sqsClient = Main.getSQSClient("232");
        Main.sendMessage(sqsClient);
    }
}
