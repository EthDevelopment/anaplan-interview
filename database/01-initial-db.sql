USE definitions;

CREATE TABLE IF NOT EXISTS `dashboards` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Inserting data with values for the title column
INSERT INTO dashboards (title) VALUES
('Dashboard 1'),
('Dashboard 2'),
('Dashboard 3');