-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 22, 2015 at 03:01 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `localeShop`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyers`
--

CREATE TABLE `buyers` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `locality` varchar(256) NOT NULL,
  `town` varchar(256) NOT NULL,
  `city` varchar(256) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buyers`
--

INSERT INTO `buyers` (`id`, `name`, `locality`, `town`, `city`, `latitude`, `longitude`, `created_date`, `modified_date`) VALUES
(1, 'hari', 'vadamadurai', 'thudiyalur', 'coimbatore', 15, 90, '2015-12-14 00:00:00', '2015-12-14 00:00:00'),
(3, 'subha', 'nggo', 'thudiyalur', 'coimbatore', 15, 90, '2015-12-14 00:00:00', '2015-12-14 00:00:00'),
(4, 'chilku', 'nggo', 'mayavaram', 'coimbatore', 15, 100, '2015-12-14 00:00:00', '2015-12-14 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `deals_sellers`
--

CREATE TABLE `deals_sellers` (
  `id` int(11) NOT NULL,
  `seller_branch_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `unit_name` varchar(256) NOT NULL,
  `price` double NOT NULL,
  `deal_price` double NOT NULL,
  `total_units` int(11) NOT NULL,
  `date_from` datetime NOT NULL,
  `date_to` datetime NOT NULL,
  `home_delivery` tinyint(1) NOT NULL,
  `sellerBranch_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deals_sellers`
--

INSERT INTO `deals_sellers` (`id`, `seller_branch_id`, `product_id`, `unit_name`, `price`, `deal_price`, `total_units`, `date_from`, `date_to`, `home_delivery`, `sellerBranch_id`) VALUES
(1, 1, 1, 'kg', 120, 80, 10, '2015-12-13 06:05:00', '2015-12-24 00:00:00', 1, NULL),
(2, 2, 2, 'kg', 50, 20, 20, '2015-12-13 00:00:00', '2015-12-24 00:00:00', 1, NULL),
(5, 2, 2, 'kg', 70, 40, 20, '2015-12-10 00:00:00', '2015-12-23 00:00:00', 1, NULL),
(9, 13, 4, 'kg', 110, 80, 10, '2015-12-15 00:00:00', '2015-12-24 00:00:00', 1, NULL),
(10, 3, 3, 'kg', 60, 20, 20, '2015-12-15 00:00:00', '2015-12-24 00:00:00', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`) VALUES
(1, 'Apple', 'Apple fruit'),
(2, 'Mango', 'Mango fruit'),
(3, 'Jack', 'Jack fruit'),
(4, 'Guava', 'Guava fruit'),
(5, 'Grape', 'Grape fruit'),
(6, 'Banana', 'Banana fruit');

-- --------------------------------------------------------

--
-- Table structure for table `sellers`
--

CREATE TABLE `sellers` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `location` varchar(256) NOT NULL,
  `createdDate` datetime NOT NULL,
  `modifiedDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sellers`
--

INSERT INTO `sellers` (`id`, `name`, `description`, `location`, `createdDate`, `modifiedDate`) VALUES
(1, 'Tata Store', 'Tata Store Department base', 'Coimbatore', '2015-12-08 00:00:00', '2015-12-08 00:00:00'),
(2, 'Reliance Store', 'Reliance Store Department base', 'kambam', '2015-12-08 00:00:00', '2015-12-08 00:00:00'),
(3, 'Kirla Store', 'Kirla Store Department base', 'suseendram', '2015-12-12 00:00:00', '2015-12-13 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `seller_branches`
--

CREATE TABLE `seller_branches` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `branch_locality` varchar(256) NOT NULL,
  `branch_town` varchar(256) NOT NULL,
  `branch_city` varchar(256) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `seller_id` int(11) NOT NULL,
  `createdDate` datetime NOT NULL,
  `modifiedDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seller_branches`
--

INSERT INTO `seller_branches` (`id`, `name`, `description`, `branch_locality`, `branch_town`, `branch_city`, `latitude`, `longitude`, `seller_id`, `createdDate`, `modifiedDate`) VALUES
(1, 'tata store', 'tata store', 'nggo colony', 'thudiyalur', 'coimbatore', 10.57, 76.5, 1, '2015-12-13 00:00:00', '2015-12-13 00:00:00'),
(2, 'tata store', 'tata store', 'viswanathapuram', 'thudiyalur', 'coimbatore', 12.89, 83.76, 1, '2015-12-13 00:00:00', '2015-12-13 00:00:00'),
(3, 'reliance store', 'reliance store', 'r k nagar', 'k k nagar', 'theni', 13.89, 86.76, 2, '2015-12-08 00:00:00', '2015-12-12 00:00:00'),
(13, 'reliance store', 'reliance store', 'r k nagar', 's h nagar', 'tanjore', 13.89, 86.76, 2, '2015-12-13 00:00:00', '2015-12-13 00:00:00'),
(14, 'reliance store', 'reliance store', 'r k nagar', 's h nagar', 'tanjore', 13.89, 86.76, 2, '2015-12-12 00:00:00', '2015-12-13 00:00:00'),
(15, 'reliance store', 'reliance store', 'r k nagar', 's h nagar', 'tanjore', 13.89, 86.76, 2, '2015-12-12 00:00:00', '2015-12-13 00:00:00'),
(16, 'Kirla store', 'Kirla store', 'r k nagar', 'k k nagar', 'ooty', 13.89, 86.76, 3, '2015-12-12 00:00:00', '2015-12-13 00:00:00'),
(17, 'Kirla store', 'Kirla store', 'r k nagar', 's h nagar', 'tanjore', 13.89, 86.76, 3, '2015-12-12 00:00:00', '2015-12-13 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`) VALUES
(1, 'hari'),
(2, 'subha'),
(3, 'saatvik'),
(4, 'kappu'),
(5, 'chilku'),
(6, 'angel');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyers`
--
ALTER TABLE `buyers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deals_sellers`
--
ALTER TABLE `deals_sellers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seller deals` (`seller_branch_id`) USING BTREE,
  ADD KEY `product deals` (`product_id`) USING BTREE,
  ADD KEY `FK4B20621C688027A8` (`sellerBranch_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sellers`
--
ALTER TABLE `sellers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seller_branches`
--
ALTER TABLE `seller_branches`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seller_id` (`seller_id`),
  ADD KEY `longitude` (`longitude`),
  ADD KEY `latitude` (`latitude`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyers`
--
ALTER TABLE `buyers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `deals_sellers`
--
ALTER TABLE `deals_sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sellers`
--
ALTER TABLE `sellers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `seller_branches`
--
ALTER TABLE `seller_branches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `deals_sellers`
--
ALTER TABLE `deals_sellers`
  ADD CONSTRAINT `FK4B20621C688027A8` FOREIGN KEY (`sellerBranch_id`) REFERENCES `seller_branches` (`id`),
  ADD CONSTRAINT `deals_sellers_ibfk_1` FOREIGN KEY (`seller_branch_id`) REFERENCES `seller_branches` (`id`),
  ADD CONSTRAINT `deals_sellers_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `seller_branches`
--
ALTER TABLE `seller_branches`
  ADD CONSTRAINT `seller_branches_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `sellers` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
