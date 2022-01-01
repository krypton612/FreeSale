-- phpMyAdmin SQL Dump
-- version 5.1.1deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 01, 2022 at 01:52 PM
-- Server version: 10.5.9-MariaDB-1
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prueba3`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38);

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `factura`
--

INSERT INTO `factura` (`id_factura`, `total`, `tipo`, `cantidad`) VALUES
(1, 30, 'pollo economico', 3),
(2, 160, 'pollo entero', 2),
(3, 40, 'pollo economico', 4),
(4, 20, 'pollo medio', 1),
(5, 80, 'pollo entero', 1),
(6, 1, 'pollo medio', 40),
(7, 10, 'ECONOMICO', 1),
(8, 10, 'ECONOMICO', 1),
(9, 60, 'CUARTO', 3),
(10, 100, 'ECONOMICO', 10),
(11, 160, 'CUARTO', 8),
(12, 10, 'ECONOMICO', 1),
(13, 240, 'CUARTO', 12),
(14, 20, 'CUARTO', 1),
(15, 10, 'ECONOMICO', 1),
(16, 110, 'ECONOMICO', 11),
(17, 160, 'ENTERO', 2),
(18, 40, 'MEDIO', 1),
(19, 10, 'ECONOMICO', 1),
(20, 10, 'ECONOMICO', 1),
(21, 10, 'ECONOMICO', 1),
(22, 60, 'CUARTO', 3),
(23, 10, 'ECONOMICO', 1),
(24, 120, 'MEDIO', 3),
(25, 80, 'MEDIO', 2),
(26, 10, 'ECONOMICO', 1),
(27, 160, 'ENTERO', 2),
(28, 30, 'ECONOMICO', 3),
(29, 120, 'ECONOMICO', 12),
(30, 40, 'CUARTO', 2),
(31, 30, 'ECONOMICO', 3),
(32, 80, 'MEDIO', 2),
(33, 10, 'ECONOMICO', 1),
(34, 50, 'ECONOMICO', 5),
(35, 160, 'ENTERO', 2),
(36, 80, 'MEDIO', 2),
(37, 20, 'ECONOMICO', 2),
(38, 40, 'MEDIO', 1);

-- --------------------------------------------------------

--
-- Table structure for table `genera`
--

CREATE TABLE `genera` (
  `id_genera` int(11) NOT NULL,
  `id_relacion_pedido` int(11) NOT NULL DEFAULT 0,
  `id_relacion_factura` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genera`
--

INSERT INTO `genera` (`id_genera`, `id_relacion_pedido`, `id_relacion_factura`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(14, 13, 13),
(15, 15, 15),
(16, 15, 15),
(17, 15, 15),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20),
(21, 21, 21),
(22, 22, 22),
(23, 23, 23),
(24, 24, 24),
(25, 25, 25),
(26, 26, 26),
(27, 27, 27),
(28, 28, 28),
(29, 29, 29),
(30, 30, 30),
(31, 31, 31);

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `tipo_plato` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `id_relacion_solicitud` int(11) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `tipo_plato`, `cantidad`, `precio`, `id_relacion_solicitud`, `estado`) VALUES
(1, 'pollo economico', 3, 30, 1, b'0'),
(2, 'pollo entero', 2, 160, 2, b'0'),
(3, 'pollo economico', 4, 40, 3, b'0'),
(4, 'pollo medio', 1, 20, 4, b'0'),
(5, 'pollo entero', 1, 80, 5, b'0'),
(6, 'pollo medio', 1, 40, 6, b'0'),
(7, 'ECONOMICO', 1, 10, 7, b'0'),
(8, 'ECONOMICO', 1, 10, 8, b'0'),
(9, 'CUARTO', 3, 60, 9, b'0'),
(10, 'ECONOMICO', 10, 100, 10, b'0'),
(11, 'CUARTO', 8, 160, 11, b'0'),
(12, 'ECONOMICO', 1, 10, 12, b'0'),
(13, 'ENTERO', 2, 160, 13, b'0'),
(14, 'ECONOMICO', 1, 10, 13, b'0'),
(15, 'ECONOMICO', 1, 10, 15, b'0'),
(16, 'ECONOMICO', 11, 110, 15, b'0'),
(17, 'ENTERO', 2, 160, 15, b'1'),
(18, 'MEDIO', 1, 40, 18, b'1'),
(19, 'ECONOMICO', 1, 10, 19, b'1'),
(20, 'ECONOMICO', 1, 10, 20, b'1'),
(21, 'ECONOMICO', 1, 10, 21, b'1'),
(22, 'CUARTO', 3, 60, 22, b'1'),
(23, 'ECONOMICO', 1, 10, 23, b'1'),
(24, 'MEDIO', 3, 120, 24, b'1'),
(25, 'MEDIO', 2, 80, 25, b'1'),
(26, 'ECONOMICO', 1, 10, 26, b'1'),
(27, 'ENTERO', 2, 160, 27, b'1'),
(28, 'ECONOMICO', 3, 30, 28, b'1'),
(29, 'ECONOMICO', 12, 120, 29, b'1'),
(30, 'CUARTO', 2, 40, 30, b'1'),
(31, 'ECONOMICO', 3, 30, 31, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `registro`
--

CREATE TABLE `registro` (
  `id_registro` int(11) NOT NULL,
  `tipo_plato` varchar(225) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registro`
--

INSERT INTO `registro` (`id_registro`, `tipo_plato`, `cantidad`, `precio`, `estado`) VALUES
(1, 'En Espera', 1, 1, b'1'),
(2, 'ECONOMICO', 2, 20, b'1'),
(3, 'MEDIO', 1, 40, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `id_relacion_cliente` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `id_relacion_cliente`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 15),
(17, 15),
(18, 18),
(19, 19),
(20, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24),
(25, 25),
(26, 26),
(27, 27),
(28, 28),
(29, 29),
(30, 30),
(31, 31);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`);

--
-- Indexes for table `genera`
--
ALTER TABLE `genera`
  ADD PRIMARY KEY (`id_genera`),
  ADD KEY `id_relacion_pedido` (`id_relacion_pedido`),
  ADD KEY `id_relacion_factura` (`id_relacion_factura`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `pedido_ibfk_1` (`id_relacion_solicitud`);

--
-- Indexes for table `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id_registro`);

--
-- Indexes for table `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`),
  ADD KEY `id_relacion_cliente` (`id_relacion_cliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `genera`
--
ALTER TABLE `genera`
  MODIFY `id_genera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `registro`
--
ALTER TABLE `registro`
  MODIFY `id_registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `genera`
--
ALTER TABLE `genera`
  ADD CONSTRAINT `genera_ibfk_1` FOREIGN KEY (`id_relacion_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `genera_ibfk_2` FOREIGN KEY (`id_relacion_factura`) REFERENCES `factura` (`id_factura`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_relacion_solicitud`) REFERENCES `solicitud` (`id_solicitud`);

--
-- Constraints for table `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_ibfk_1` FOREIGN KEY (`id_relacion_cliente`) REFERENCES `cliente` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
