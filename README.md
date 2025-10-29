# 🚀 Inicialización del Proyecto

Este proyecto se ejecuta completamente dentro de **Docker** para facilitar la configuración y la portabilidad del entorno.

---

## 🧱 Puesta en marcha del entorno

Para levantar el proyecto desde cero:

1. **Construir los contenedores**
   ```bash
   docker compose build
   ```

2. **Lanzar el entorno**
   ```bash
   docker compose up
   ```

---

## ⚠️ Posibles problemas de conexión

Si durante el arranque observas errores relacionados con la base de datos (**MySQL**), asegúrate de que el contenedor correspondiente está levantado correctamente.

Puedes hacerlo de dos formas:

- Desde la interfaz de Docker Desktop, iniciando manualmente el contenedor de MySQL.
- O bien desde la terminal, abriendo tres consolas y ejecutando:
  ```bash
  docker compose up <nombre_del_servicio>
  ```

---

## 🧩 Migraciones (Flyway)

Las migraciones se gestionan mediante **Flyway** y se almacenan dentro de la carpeta:

```
migrations/
```

### 📜 Nomenclatura de los ficheros de migración

Cada script SQL debe seguir la siguiente convención:

```
V<version-final>__<nombre-de-tu-movida>.sql
```

Por ejemplo:
```
V1__create_users_table.sql
V2__add_index_to_orders.sql
```

### 🚀 Ejecución de migraciones

Para aplicar las migraciones, basta con ejecutar el contenedor correspondiente a Flyway.

---

## 🧩 Consideraciones al reconstruir

Cuando realices un nuevo build, por ejemplo con:

```bash
docker compose build
```
o
```bash
docker compose up --build
```

puede producirse un error temporal si la base de datos se inicializa **más tarde que el contenedor de migraciones**.

Hasta que se mejore la organización del arranque, **asegúrate de que la base de datos está instanciada** antes de ejecutar las migraciones.

---

## ⚙️ Entornos

- **Local:** requiere comprobar el estado de la base de datos antes de aplicar las migraciones.  
- **Producción:** se revisará la configuración del arranque para asegurar el orden correcto de los servicios.

---

## 🧾 Resumen rápido

| Acción | Comando |
|--------|----------|
| Construir contenedores | `docker compose build` |
| Levantar entorno | `docker compose up` |
| Reconstruir con build forzado | `docker compose up --build` |
| Levantar servicio individual | `docker compose up <nombre_del_servicio>` |

---

✍️ **Autor:** *[Tu nombre o equipo]*  
📦 **Tecnologías:** Docker, Flyway, MySQL
