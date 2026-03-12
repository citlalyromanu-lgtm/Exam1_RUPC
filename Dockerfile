FROM ubuntu:latest
LABEL authors="uchih"

ENTRYPOINT ["top", "-b"]