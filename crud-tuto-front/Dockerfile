FROM node:12.18-alpine 
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY --from=node /app/dist/crud-tuto-front /usr/share/nginx/html




