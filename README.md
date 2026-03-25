## 🚀 Configuración e inicio

Ejecuta el siguiente comando desde el directorio donde se encuentra el archivo `docker-compose.yml`:
```bash
docker-compose up -d
```

- `docker-compose up -d` — levanta los contenedores en segundo plano

> ⚠️ El puerto **3306** debe estar libre antes de ejecutar estos comandos.
> Puedes verificarlo con `netstat -ano | findstr :3306` (Windows) o `lsof -i :3306` (Linux/Mac)

---

## 🗄️ Acceder a la base de datos desde la terminal

**Entrar al contenedor:**
```bash
docker exec -it walmart-api-db bash
```

**Conectarse a MySQL desde dentro del contenedor:**
```bash
mysql -u walmapi -p
# Password: walmapi
```

**O en un solo comando desde fuera del contenedor:**
```bash
docker exec -it walmart-api-db mysql -u walmapi -p walmart-db
```

**Comandos útiles una vez dentro de MySQL:**
```sql
SHOW DATABASES;         -- ver todas las bases de datos
USE walmart-db;         -- seleccionar la base de datos
SHOW TABLES;            -- ver todas las tablas
DESCRIBE nombre_tabla;  -- ver estructura de una tabla
```