FROM node:12.18-alpine 
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
ENV NODE_OPTIONS=--openssl-legacy-provider
FROM nginx:alpine
COPY --from=build /app/dist/crud-tuto-front /usr/share/nginx/html
EXPOSE 8089



