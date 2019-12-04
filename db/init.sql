CREATE OR REPLACE FUNCTION on_updated_at()   
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = current_timestamp;
    RETURN NEW;   
END;
$$ language 'plpgsql';

drop table if exists user_login_role;
drop table if exists role_permission;
drop table if exists permission;
drop table if exists role;
drop table if exists user_login;
drop table if exists person;

create table person(
	id uuid primary key default uuid_generate_v4(),
	name varchar(200) not null,
	updated_at timestamp not null default current_timestamp,
	created_at timestamp not null default current_timestamp
);
create trigger person_updated_at before update on person 
for each row execute procedure on_updated_at();

create table user_login(
	id uuid primary key default uuid_generate_v4(),
	username varchar(100) not null,
	password varchar(100) not null,
	updated_at timestamp not null default current_timestamp,
	created_at timestamp not null default current_timestamp
);
create trigger user_login_updated_at before update on user_login 
for each row execute procedure on_updated_at();

create table role(
	id uuid primary key default uuid_generate_v4(),
	name varchar(100) not null
);

create table permission(
	id uuid primary key default uuid_generate_v4(),
	name varchar(100) not null unique
);

create table role_permission(
	permission_id uuid not null references permission(id) on delete cascade,
	role_id uuid not null references role(id) on delete cascade,
	created_at timestamp not null default current_timestamp,
	primary key (permission_id, role_id)
);

create table user_login_role(
	user_login_id uuid not null references user_login(id) on delete cascade,
	role_id uuid not null references role(id) on delete cascade,
	created_at timestamp not null default current_timestamp,
	primary key (user_login_id, role_id)
);