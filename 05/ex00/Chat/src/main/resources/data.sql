insert into users (login, password) values ('John1', '1');
insert into users (login, password) values ('John2', '111');
insert into users (login, password) values ('John3', '1234');
insert into users (login, password) values ('John4', 'qwerty');
insert into users (login, password) values ('John5', null);

insert into rooms (room_name, room_owner) values ('chatroom1', 1);
insert into rooms (room_name, room_owner) values ('chatroom2', 2);
insert into rooms (room_name, room_owner) values ('chatroom3', 3);
insert into rooms (room_name, room_owner) values ('chatroom4', 4);
insert into rooms (room_name, room_owner) values ('chatroom5', 5);

insert into messages (message, time, message_author, message_room) values ('Hello 1 world!', to_timestamp(2022-04-26-01-47-53), 1, 1);
insert into messages (message, time, message_author, message_room) values ('Hello 2 world!', to_timestamp(2022-04-26-01-47-53), 2, 2);
insert into messages (message, time, message_author, message_room) values ('Hello 3 world!', to_timestamp(2022-04-26-01-47-53), 3, 3);
insert into messages (message, time, message_author, message_room) values ('Hello 4 world!', to_timestamp(2022-04-26-01-47-53), 4, 4);
insert into messages (message, time, message_author, message_room) values ('Hello 5 world!', to_timestamp(2022-04-26-01-47-53), 5, 5);