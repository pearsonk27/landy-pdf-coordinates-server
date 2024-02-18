#!/bin/bash
COMMIT=$(git rev-parse --verify HEAD)
docker build -f ./Dockerfile \
  -t pearsonk27/pdf-coordinates-server \
  -t pearsonk27/pdf-coordinates-server:${COMMIT} .