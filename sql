--
-- Dummy SQL dump for the `ifinances` schema
--
-- Set up the database
CREATE DATABASE IF NOT EXISTS `ifinances` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `ifinances`;
--
-- Table structure for table `account`
--
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_number` VARCHAR(50) NOT NULL UNIQUE,
  `balance` DECIMAL(15, 2) NOT NULL,
  `user_id` INT NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `account`
--
INSERT INTO `account` (`account_number`, `balance`, `user_id`) VALUES
('ACC123456789', 50000.00, 1),
('ACC987654321', 125000.75, 2),
('ACC112233445', 7500.50, 3);
--
-- Table structure for table `agent`
--
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `contact_email` VARCHAR(100) UNIQUE,
  `phone_number` VARCHAR(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `agent`
--
INSERT INTO `agent` (`name`, `contact_email`, `phone_number`) VALUES
('John Doe', 'john.doe@ifinances.com', '555-1234'),
('Jane Smith', 'jane.smith@ifinances.com', '555-5678');
--
-- Table structure for table `bank_contact`
--
DROP TABLE IF EXISTS `bank_contact`;
CREATE TABLE `bank_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bank_name` VARCHAR(100) NOT NULL,
  `contact_name` VARCHAR(100),
  `phone_number` VARCHAR(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `bank_contact`
--
INSERT INTO `bank_contact` (`bank_name`, `contact_name`, `phone_number`) VALUES
('First National Bank', 'Amanda Jones', '555-0001'),
('Global Finance', 'Mark Miller', '555-0002');
--
-- Table structure for table `bond`
--
DROP TABLE IF EXISTS `bond`;
CREATE TABLE `bond` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `symbol` VARCHAR(20) NOT NULL UNIQUE,
  `issuer` VARCHAR(100) NOT NULL,
  `maturity_date` DATE,
  `coupon_rate` DECIMAL(5, 2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `bond`
--
INSERT INTO `bond` (`symbol`, `issuer`, `maturity_date`, `coupon_rate`) VALUES
('T-BOND-2030', 'US Treasury', '2030-01-01', 3.50),
('CORP-BOND-XYZ', 'XYZ Corp', '2028-06-15', 5.25);
--
-- Table structure for table `budget`
--
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `amount` DECIMAL(15, 2) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `budget`
--
INSERT INTO `budget` (`name`, `amount`, `user_id`) VALUES
('Monthly Spending', 2000.00, 1),
('Investment Budget', 500.00, 2);
--
-- Table structure for table `budget_transaction`
--
DROP TABLE IF EXISTS `budget_transaction`;
CREATE TABLE `budget_transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `budget_id` INT NOT NULL,
  `amount` DECIMAL(15, 2) NOT NULL,
  `description` VARCHAR(255),
  `date` DATE,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`budget_id`) REFERENCES `budget`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `budget_transaction`
--
INSERT INTO `budget_transaction` (`budget_id`, `amount`, `description`, `date`) VALUES
(1, 200.00, 'Groceries', '2025-07-01'),
(1, 50.00, 'Coffee', '2025-07-05'),
(2, 500.00, 'Bought stock', '2025-07-10');
--
-- Table structure for table `credential`
--
DROP TABLE IF EXISTS `credential`;
CREATE TABLE `credential` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `username` VARCHAR(100) NOT NULL UNIQUE,
  `password_hash` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `credential`
--
-- Note: Passwords are hashed in real applications. This is dummy data.
INSERT INTO `credential` (`user_id`, `username`, `password_hash`) VALUES
(1, 'user1', 'hashed_password_1'),
(2, 'user2', 'hashed_password_2');
--
-- Table structure for table `currency`
--
DROP TABLE IF EXISTS `currency`;
CREATE TABLE `currency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(3) NOT NULL UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `currency`
--
INSERT INTO `currency` (`code`, `name`) VALUES
('USD', 'United States Dollar'),
('EUR', 'Euro'),
('JPY', 'Japanese Yen');
--
-- Table structure for table `finances_user`
--
DROP TABLE IF EXISTS `finances_user`;
CREATE TABLE `finances_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `finances_user`
--
INSERT INTO `finances_user` (`id`, `full_name`, `email`) VALUES
(1, 'Alice Johnson', 'alice.j@example.com'),
(2, 'Bob Williams', 'bob.w@example.com'),
(3, 'Charlie Brown', 'charlie.b@example.com');
--
-- Table structure for table `ifinances_keys` (hypothetical)
--
DROP TABLE IF EXISTS `ifinances_keys`;
CREATE TABLE `ifinances_keys` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `key_name` VARCHAR(100) NOT NULL UNIQUE,
  `key_value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `ifinances_keys`
--
INSERT INTO `ifinances_keys` (`key_name`, `key_value`) VALUES
('api_key', 'abc123def456'),
('secret_token', 'xyz987uvw654');
--
-- Table structure for table `investment`
--
DROP TABLE IF EXISTS `investment`;
CREATE TABLE `investment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `investment_type` ENUM('stock', 'bond', 'other') NOT NULL,
  `symbol` VARCHAR(50) NOT NULL,
  `quantity` INT NOT NULL,
  `purchase_price` DECIMAL(15, 2) NOT NULL,
  `purchase_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `investment`
--
INSERT INTO `investment` (`user_id`, `investment_type`, `symbol`, `quantity`, `purchase_price`, `purchase_date`) VALUES
(1, 'stock', 'AAPL', 10, 150.00, '2025-01-15'),
(2, 'bond', 'T-BOND-2030', 5, 1000.00, '2025-02-20');
--
-- Table structure for table `market`
--
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL UNIQUE,
  `country` VARCHAR(50),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `market`
--
INSERT INTO `market` (`name`, `country`) VALUES
('NASDAQ', 'USA'),
('NYSE', 'USA'),
('Tokyo Stock Exchange', 'Japan');
--
-- Table structure for table `portfolio`
--
DROP TABLE IF EXISTS `portfolio`;
CREATE TABLE `portfolio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `portfolio`
--
INSERT INTO `portfolio` (`user_id`, `name`) VALUES
(1, 'Growth Portfolio'),
(2, 'Retirement Portfolio');
--
-- Table structure for table `stock`
--
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `symbol` VARCHAR(20) NOT NULL UNIQUE,
  `company_name` VARCHAR(100) NOT NULL,
  `market_id` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`market_id`) REFERENCES `market`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `stock`
--
INSERT INTO `stock` (`symbol`, `company_name`, `market_id`) VALUES
('AAPL', 'Apple Inc.', 1),
('GOOG', 'Alphabet Inc.', 1),
('MSFT', 'Microsoft Corp.', 2);
--
-- Table structure for table `time_test` (hypothetical)
--
DROP TABLE IF EXISTS `time_test`;
CREATE TABLE `time_test` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_name` VARCHAR(100),
  `event_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `time_test`
--
INSERT INTO `time_test` (`event_name`) VALUES
('Start of Test'),
('End of Test');
--
-- Table structure for table `transaction`
--
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `type` ENUM('deposit', 'withdrawal', 'transfer') NOT NULL,
  `amount` DECIMAL(15, 2) NOT NULL,
  `transaction_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`account_id`) REFERENCES `account`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `transaction`
--
INSERT INTO `transaction` (`account_id`, `type`, `amount`) VALUES
(1, 'deposit', 1000.00),
(1, 'withdrawal', 50.00),
(2, 'deposit', 5000.00);
--
-- Table structure for table `user_account` (hypothetical)
--
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `user_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `account_id`),
  FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`),
  FOREIGN KEY (`account_id`) REFERENCES `account`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `user_account`
--
INSERT INTO `user_account` (`user_id`, `account_id`) VALUES
(1, 1),
(2, 2),
(3, 3);
--
-- Table structure for table `user_address` (hypothetical)
--
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `street` VARCHAR(100),
  `city` VARCHAR(50),
  `country` VARCHAR(50),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `user_address`
--
INSERT INTO `user_address` (`user_id`, `street`, `city`, `country`) VALUES
(1, '123 Main St', 'Anytown', 'USA'),
(2, '456 Oak Ave', 'Someplace', 'USA');
--
-- Adding foreign keys that were defined earlier
--
ALTER TABLE `account` ADD FOREIGN KEY (`user_id`) REFERENCES `finances_user`(`id`);
