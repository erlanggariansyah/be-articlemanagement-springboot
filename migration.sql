CREATE TABLE IF NOT EXISTS `ARTICLES`(
    `id`          INTEGER AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `description` TEXT NOT NULL,
    `author`      VARCHAR(100) NOT NULL,
    `created_at`  DATE NOT NULL DEFAULT CURRENT_DATE
);