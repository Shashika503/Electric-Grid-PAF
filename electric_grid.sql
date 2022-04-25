-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 05:19 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electric_grid`
--

-- --------------------------------------------------------

--
-- Table structure for table `meter_connection`
--

CREATE TABLE `meter_connection` (
  `mc_id` int(11) NOT NULL,
  `mc_type` varchar(50) NOT NULL,
  `mc_phase_type` varchar(50) NOT NULL,
  `mc_capacity` float(20) NOT NULL,
  `mc_monthly_unit_usage` float(20) NOT NULL,
  `mc_validity_status` varchar(300) NOT NULL,
  `mc_power_distribution_status` varchar(50) NOT NULL,
  `user_acc_id` int(10) NOT NULL,
  `billing_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meter_connection`
--

INSERT INTO `meter_connection` ( `mc_id` ,  `mc_type`, `mc_phase_type` ,  `mc_capacity` ,  `mc_monthly_unit_usage` ,  `mc_validity_status` ,  `mc_power_distribution_status` ,  `user_acc_id` ,  `billing_id`) VALUES
(1, 'industrial', 'three-phase', 5000, 78, 'active', 'on', 7896547, 8903456),
(2, 'domestic', 'one-phase', 2000, 89, 'active', 'on' , 7896549 , 3456732),
(3, 'industrial', 'three-phase', 6000, 105 , 'active', 'on', 8967854 , 9087654),
(4,  'domestic', 'two-phase', 6000, 95, 'inactive', 'on', 8997884 , 9097634);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `meter_connection`
--
ALTER TABLE `meter_connection`
  ADD PRIMARY KEY (`mc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `meter_connection`
--
ALTER TABLE `meter_connection`
  MODIFY `mc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
