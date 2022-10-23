FROM node:1.8-alpine as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY --from=build /app/dist/crud-tuto-front /usr/share/nginx/html




