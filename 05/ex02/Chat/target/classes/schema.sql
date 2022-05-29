drop table if exists users, rooms, messages;

create table if not exists users (
   id              bigserial primary key,
   login           varchar(30) unique not null,
   password        varchar(30)
);

create table if not exists rooms (
   id              bigserial primary key,
   room_name       varchar(30) not null,
   room_owner      int not null references users(id)
);

create table if not exists messages (
    id              bigserial primary key,
    message         text not null,
    time            timestamp,
    message_author  int not null references users(id),
    message_room    int not null references rooms(id)
);
