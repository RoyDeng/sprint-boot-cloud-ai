# sprint-boot-cloud-ai

A app integrate ChatGPT and Whisper API into Spring Boot Microservice.

## Containerising the app

### You can now build a container image from your app with the following command:

```bash
docker build -t helloworld-ai .
```

### Create a new Docker network as follows:

```bash
docker network create ai
```

```bash
docker run \
  --name=ai-java \
  --rm \
  --network=ai \
  -p 8500:8500 \
  -e OPEN_AI_KEY={YOUR_OPEN_AI_KEY} \
  ai-java
```

## How to test the running app

### Ask a question:

```curl
curl --location 'http://localhost:8500/api/v1/chat' \
--header 'Content-Type: application/json' \
--data '{
    "question": "How do you define success?"
}'
```

### Convert a audio file to verbatim:

```curl
curl --location --request GET 'http://localhost:8500/api/v1/transcription' \
--form 'file="audio.mp3"' \
--form 'model="whisper-1"'
```

##### Tags: `Spring Cloud OpenFeign` `Microservice` `OpenAI` `ChatGPT` `Docker`