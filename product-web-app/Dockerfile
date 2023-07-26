FROM node:18-alpine

WORKDIR /app

COPY . /app

COPY ../tsconfig.json tsconfig.json

RUN npm install
RUN npm run prestart

ARG API_URL

ENV API_URL ${API_URL}

EXPOSE 8080

CMD ["node", "dist/app.js"]