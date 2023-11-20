#!/bin/bash

aws cloudformation create-stack \
  --stack-name ike \
  --template-body file:///etc/localstack/init/ready.d/formation.yaml \
  --endpoint-url=http://localhost:4566 \
  --region eu-west-1

touch test.txt
aws --endpoint-url=http://localhost:4566 s3 cp test.txt s3://my-bucket/test.txt