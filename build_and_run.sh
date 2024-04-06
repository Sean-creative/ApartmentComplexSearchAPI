#!/bin/bash

# 이미지 이름과 태그 설정
IMAGE_NAME=archisketch_backend
TAG=latest

# Docker 이미지 빌드
docker build -t $IMAGE_NAME:$TAG .

# 이전 컨테이너 삭제 (있을 경우)
docker rm -f $IMAGE_NAME || true

# Docker 컨테이너 실행
docker run -d --name $IMAGE_NAME -p 8080:8080 $IMAGE_NAME:$TAG
