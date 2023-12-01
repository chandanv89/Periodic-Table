FROM node:latest AS node-build
WORKDIR /app
COPY . .
RUN npm ci
RUN npm run build

FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=node-build /app/dist/periodic-table /usr/share/nginx/html
