-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Mrz 2023 um 21:39
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `mysql-carapp`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `car`
--

CREATE TABLE `car` (
  `id` int(3) NOT NULL,
  `carBrand` varchar(50) NOT NULL,
  `km` int(11) NOT NULL,
  `available` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `car`
--

INSERT INTO `car` (`id`, `carBrand`, `km`, `available`) VALUES
(4, 'Toyota', 0, 0),
(1, 'seat', 0, 1),
(9, 'pro', 5000, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rent`
--

CREATE TABLE `rent` (
  `uid` int(4) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(3) NOT NULL,
  `id` int(3) NOT NULL,
  `carBrand` varchar(50) NOT NULL,
  `km` int(11) NOT NULL,
  `available` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `uid` int(4) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`uid`, `Name`, `Age`) VALUES
(5, 'Lama', 8),
(5, 'Lama', 8),
(5, 'Lama', 8),
(0, 'Sepp', 89),
(6, 'Pikachu', 44);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
