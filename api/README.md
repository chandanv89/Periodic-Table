# Periodic Table API
[![Push API image to DockerHub (snapshot)](https://github.com/chandanv89/Periodic-Table/actions/workflows/push-api-img-to-dh.yml/badge.svg)](https://github.com/chandanv89/Periodic-Table/actions/workflows/push-api-img-to-dh.yml)

This project provides a few RESTful endpoints for the Periodic Table app.

## Usage

Easiest way to run this application is to use Docker.

```sh
$ docker pull chandanv89/periodic-table-api:latest
```

Then create a container, exposing the port.

```sh
$ docker run --name periodic-table-api -d -p 9091:9091 periodic-table-api
bc35bbb45e9d862abfd718d32b58e61e10d516e0d767ad5387a79c7a55eac35e
```

If a container is created successfully, you should see it's id as the response for the above command. In this case, it is `bc35b..ac35e`.

To test the service:

```sh
$ curl http://localhost:9091/periodic-table/api/v1/elements
```

## Endpoints Exposed

- <http-method> GET</http-method> <endpoint>/periodic-table/api/v1/elements</endpoint>
- <http-method>GET</http-method> <endpoint>/periodic-table/api/v1/elements/{elementName}</endpoint>
- <http-method>GET</http-method> <endpoint>/periodic-table/api/v1/elements/{elementName}/images</endpoint>

## API Reference Documents

- [Swagger UI](http://localhost:9091/swagger)
- [Redoc](http://localhost:9091/redoc)
- [Scalar](https://chandanv89.apidocumentation.com/100/reference#tag/periodic-table-controller)

<style>
    http-method {
        border: 1px solid #5f5;
        pading: 3px 5px;
        border-radius: 3px;
        font: 700 0.75rem/1rem Inter, system-ui, sans-serif;
        background-color: #9b9;
        color: #141;
    }

    endpoint {
        font-family: monospace;
    }
</style>
