FROM node:14.21.3-bullseye

COPY . .

RUN npm install
RUN npm run prestart

ARG API_URL

ENV API_URL ${API_URL}

EXPOSE 8080

CMD ["node", "dist/app.js"]