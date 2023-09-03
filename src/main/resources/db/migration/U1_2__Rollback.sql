DELETE
FROM operation_status
where description = 'validating';

delete
from flyway_schema_history
where script like concat('V1_2__', '%');