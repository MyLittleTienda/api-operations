--liquibase formatted sql
--changeset RustyCrazyPunky:update_tables
ALTER TABLE OPERATION ADD COLUMN OPERATION_ID BIGINT;