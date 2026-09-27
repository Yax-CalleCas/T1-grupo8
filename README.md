# Examen T1 - Grupo 8

**Curso:** PROG04697 - Desarrollo de Aplicaciones Web II | **Ciclo:** Sexto

## Integrantes

- Yaxon Paul Calle Castillo
- Yuly Gisela Huanca Tito
- Brayan Javier Jara Rojas
- Nicole Eimi Nolasco Zaan
- Cesar Roman Quispe

## Proyecto

PAYGO PERÚ - 3 microservicios: `ms-tarjetas` (8081), `ms-recargas` (8082, valida tarjeta vía Feign y publica a RabbitMQ) y `ms-riesgo` (8083, consume de la cola y calcula situación de riesgo).

## Antes de correr

- MySQL en el puerto `5510`
- RabbitMQ:
  ```bash
  docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
  ```
  (después solo `docker start rabbitmq`)
- Ajustar usuario/password de MySQL en cada `application.yaml`

## Configuración (application.yaml)

Cada microservicio trae su propio `application.yaml` en `src/main/resources/`:

| Microservicio | Puerto |
|---|---|
| `ms-tarjetas` | 8081 |
| `ms-recargas` | 8082 |
| `ms-riesgo` | 8083 |

`ms-recargas` y `ms-riesgo` además necesitan la config de RabbitMQ:
```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

## Orden de ejecución

1. MySQL + RabbitMQ
2. `ms-tarjetas`
3. `ms-riesgo`
4. `ms-recargas`

## Regla de riesgo

- **Aprobada:** monto ≤ 70% del saldo disponible
- **Observada:** monto > 70% del saldo disponible

## Postman

Colección en `Postman/`, importar con **File → Import**.
