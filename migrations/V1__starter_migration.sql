create table if not exists roles (
    id int auto_increment primary key,
    name varchar(50) not null unique
);

insert into roles (name) values ('ADMIN'), ('USER');

create table if not exists statuses (
    id int auto_increment primary key,
    name varchar(50) not null unique
);

insert into statuses (name) values ('OPEN'), ('IN_PROGRESS'), ('CLOSED'), ('ACTIVE'), ('DRAFT'), ('REMOVED');

create table if not exists users (
    id int auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(100) not null,
    role_id int,
    foreign key (role_id) references roles(id)
);

create table if not exists proyect (
    id int auto_increment primary key,
    name varchar(100) not null,
    description text,
    status_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    created_by int,
    foreign key (created_by) references users(id),
    foreign key (status_id) references statuses(id)
);

create table if not exists sprint (
    id int auto_increment primary key,
    name varchar(100) not null,
    description text,
    start_date date,
    end_date date,
    proyect_id int,
    status_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (proyect_id) references proyect(id),
    foreign key (status_id) references statuses(id)
);

create table if not exists task (
    id int auto_increment primary key,
    title varchar(100) not null,
    description text,
    status_id int,
    sprint_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    created_by int,
    foreign key (created_by) references users(id),
    foreign key (status_id) references statuses(id),
    foreign key (sprint_id) references sprint(id)
);

create table if not exists task_assignment (
    id int auto_increment primary key,
    task_id int,
    user_id int,
    assigned_at timestamp default current_timestamp,
    foreign key (task_id) references task(id),
    foreign key (user_id) references users(id)
);