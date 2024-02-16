# Motor Store Management

Este proyecto representa el Backend de un sistema de ventasde respuestos para motores.

## Installation

Configure la base de datos en el archivo application.properties, establezca la conexion y la bd en Postgresql

## API Reference

#### Crear producto

```http
  POST /products/
```

```json
{
  "name": "Aceite de Motor",
  "description": "Aceite de Motor Bermol 250ml",
  "quantity": 8,
  "model": "Botella",
  "price": 5
}
```

Crea un producto nuevo, no permite generar otro si tiene el mismo nombre

#### Actualizar producto

```http
  PUT /products/
```

```json
{
  "name": "Aceite de Motor",
  "description": "Aceite de Motor Bermol 250ml",
  "quantity": 8,
  "model": "Botella",
  "price": 5
}
```

Actualiza un producto si existe.

#### Borrar producto

```http
  DELETE /products/
```

```json
{
  "name": "Aceite de Motor"
}
```

Borra un producto si existe.

#### Actualizar stock

```http
  PUT /products/stock/{type}
```

| Parameter | Type     | Description                                                  |
|:----------|:---------|:-------------------------------------------------------------|
| `type`    | `string` | **Required**. Tipo de operación: **Valor**. "add" o "delete" |

```json
{
  "name": "Aceite de Motor"
}
```

Borra un producto si existe.

#### Crear usuario

```http
  POST /users/
```

```json
{
  "username": "adminstore",
  "password": "admon123",
  "type": "Administrador"
}
```

Crea un usuario nuevo, no permite generar otro si tiene el mismo nombre

#### Actualizar usuario

```http
  PUT /users/
```

```json
{
  "username": "adminstore",
  "password": "admin4",
  "type": "Vendedor"
}
```

Actualiza un usuario si existe.

#### Borrar usuario

```http
  DELETE /users/
```

```json
{
  "username": "adminstore"
}
```

Borra un usuario si existe.

#### Generar Venta

```http
  DELETE /users/
```

```json
{
  "seller": "adminstore",
  "products": [
    {
      "name": "Aceite de Motor",
      "quantity": 2
    },
    {
      "name": "Regulador",
      "quantity": 1
    }
  ]
}
```

Genera una venta, actualiza el stock