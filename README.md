### Java Postgress Integration

create postgress database `hb_test` with `test` table.

DDL for that table should be

```sql
CREATE TABLE IF NOT EXISTS hb_test.test
(
    name character varying(20) COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    age integer
)
```
