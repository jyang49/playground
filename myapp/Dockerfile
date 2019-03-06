FROM node:8.12-alpine

RUN apk add --no-cache curl

WORKDIR app
ADD app.js ./app.js
ENTRYPOINT ["node", "app.js"]
