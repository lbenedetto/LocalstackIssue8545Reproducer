package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.net.URI;
import java.util.stream.Collectors;

public class S3Test {
    private static S3Client s3Client;

    @BeforeAll
    public static void init() {
        s3Client = S3Client.builder()
                .endpointOverride(URI.create("http://localhost:4566"))
                .region(Region.EU_WEST_1)
                .build();
    }

    @Test
    void testBucketExists() {
        var buckets = s3Client.listBuckets()
                .buckets()
                .stream()
                .map(Bucket::name)
                .collect(Collectors.toSet());
        assert buckets.contains("my-bucket");
    }

    @Test
    void testGetObject() {
        s3Client.getObject(GetObjectRequest.builder()
                .bucket("my-bucket")
                .key("test.txt")
                .build());
    }

    @Test
    void testGetObjectBackwards() {
        s3Client.getObject(GetObjectRequest.builder()
                .bucket("test.txt")
                .key("my-bucket")
                .build());
    }
}
