FROM node:18.16-bullseye

WORKDIR /app

COPY . /app

RUN npm install
RUN npm run prestart

ARG API_URL

ENV API_URL ${API_URL}

EXPOSE 8080

CMD ["node", "dist/app.js"]