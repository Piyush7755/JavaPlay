# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                            bigint auto_increment not null,
  body                          TEXT,
  post_id                       bigint,
  user_id                       bigint,
  create_date                   datetime(6) not null,
  constraint pk_comment primary key (id)
);

create table post (
  id                            bigint auto_increment not null,
  title                         varchar(255) not null,
  body                          TEXT,
  user_id                       bigint,
  create_date                   datetime(6) not null,
  constraint pk_post primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255) not null,
  password                      varchar(255) not null,
  email                         varchar(255) not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  active                        integer not null,
  constraint uq_user_username unique (username),
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id)
);

alter table comment add constraint fk_comment_post_id foreign key (post_id) references post (id) on delete restrict on update restrict;
create index ix_comment_post_id on comment (post_id);

alter table comment add constraint fk_comment_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_comment_user_id on comment (user_id);

alter table post add constraint fk_post_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_post_user_id on post (user_id);


# --- !Downs

alter table comment drop foreign key fk_comment_post_id;
drop index ix_comment_post_id on comment;

alter table comment drop foreign key fk_comment_user_id;
drop index ix_comment_user_id on comment;

alter table post drop foreign key fk_post_user_id;
drop index ix_post_user_id on post;

drop table if exists comment;

drop table if exists post;

drop table if exists user;

