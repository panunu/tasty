# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table `tastes` (`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,`name` VARCHAR(254) NOT NULL,`description` VARCHAR(254) NOT NULL,`rating` INTEGER NOT NULL);

# --- !Downs

drop table `tastes`;

