FROM node:12.18-alpine 
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY --from=build /app/dist/crudtuto-Front /usr/share/nginx/html
EXPOSE 4200



