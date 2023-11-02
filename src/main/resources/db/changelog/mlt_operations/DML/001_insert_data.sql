--liquibase formatted sql
--changeset RustyCrazyPunky:insert_date
INSERT INTO OPERATION_STATUS (
    DESCRIPTION
) VALUE (
    'validating'
);