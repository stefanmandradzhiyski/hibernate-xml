use protein_tracker

/* Create users table */
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/* Create proteins data table */
CREATE TABLE `proteins_data` (
  `id` int(11) NOT NULL,
  `total` int(11) NOT NULL DEFAULT '0',
  `goal` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  CONSTRAINT `proteins_data_fk` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/* Create users history table */
CREATE TABLE `users_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entry_time` date NOT NULL,
  `entry` varchar(255) NOT NULL,
  `position` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `users_history_fk` (`user_id`),
  CONSTRAINT `users_history_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/* Create goals alert table */
CREATE TABLE `goals_alert` (
  `id` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/* Create many to many table between users and goal alerts */
CREATE TABLE `users_goals_alert` (
  `user_id` int(11) NOT NULL,
  `goal_alert_id` int(11) NOT NULL,
  KEY `users_goals_alert_fk` (`user_id`),
  KEY `users_goals_alert_fk_goal` (`goal_alert_id`),
  CONSTRAINT `users_goals_alert_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_goals_alert_fk_goal` FOREIGN KEY (`goal_alert_id`) REFERENCES `goals_alert` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8