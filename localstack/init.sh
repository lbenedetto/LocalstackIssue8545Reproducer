#!/bin/bash

aws cloudformation create-stack \
  --stack-name ike \
  --template-body file:///etc/localstack/init/ready.d/formation.yaml \
  --endpoint-url=http://localhost:4566 \
  --region eu-west-1