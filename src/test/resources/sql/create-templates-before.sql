DELETE FROM templates;

INSERT INTO templates (id, created_by, creation_datetime, last_updated_by, update_datetime, group_id, name, pattern,
                       resent, version)
values (1, 'Bilal', current_timestamp, 'Bilal', current_timestamp, 'one', 'ONET', 'ONEP', true, 0),
       (2, 'Bilal', current_timestamp, 'Bilal', current_timestamp, 'two', 'TWOT', 'TWOP', false, 0);

