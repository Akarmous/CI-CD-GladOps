FROM node:latest as build
RUN mkdir -p /app
WORKDIR /app
COPY . /app
RUN npm run build --prod
FROM nginx:alpine
COPY --from=build /app/dist/crud-tuto-front /usr/share/nginx/html
