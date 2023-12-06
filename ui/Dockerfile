FROM node:latest AS node-build
WORKDIR /opt/periodic-table-ui
COPY . .
RUN npm ci
RUN npm run build

FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=node-build /opt/periodic-table-ui/dist/periodic-table /usr/share/nginx/html
EXPOSE 80