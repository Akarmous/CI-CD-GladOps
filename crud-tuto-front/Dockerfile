FROM node:12.18-alpine 
WORKDIR /app

RUN npm install
COPY . /app/
RUN npm run build --prod
FROM nginx:alpine