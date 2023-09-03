ALTER TABLE operation
    DROP COLUMN operation_id;

delete
from flyway_schema_history
where script like concat('V1_1__', '%');