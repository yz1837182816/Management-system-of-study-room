USE study_room;
CREATE TABLE t_user(
    id int primary key auto_increment,
    name varchar(20),
    t_name varchar(10),
    create_time timestamp,
    duration varchar(10),
    end_time date,
    type varchar(10),
    state varchar(10)
);
ALTER TABLE t_user CHANGE NAME NAME VARCHAR(255) CHARACTER SET utf8;
ALTER TABLE t_user CHANGE TYPE TYPE VARCHAR(255) CHARACTER SET utf8;
ALTER TABLE t_user CHANGE state state VARCHAR(255) CHARACTER SET utf8;