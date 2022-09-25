SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `inventariodrogue` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inventariodrogue`;

DROP TABLE IF EXISTS `detalles`;
CREATE TABLE `detalles` (
  `index_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `laboratorio` varchar(100) NOT NULL,
  `fecha_ven` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `detalles` (`index_id`, `cantidad`, `nombre`, `laboratorio`, `fecha_ven`) VALUES
(1, 2, 'Acetaminofen', '001', '2022-03-04'),
(2, 5, 'Aspirina3', '003', '2022-01-02'),
(3, 3, 'Losartan', '003', '2022-01-02'),
(10, 3, 'Otro', '004', '2023-03-30'),
(11, 4, 'Losartan', '001', '2023-05-25'),
(12, 4, 'Losartan', '001', '2023-05-25'),
(13, 4, 'Losartan', '001', '2023-05-25'),
(14, 4, 'Losartan', '001', '2023-05-25'),
(15, 5, 'Losartan', '003', '2022-09-28'),
(16, 5, 'Losartan', '003', '2022-09-28'),
(17, 5, 'Losartan', '003', '2022-09-28');

DROP TABLE IF EXISTS `entradas`;
CREATE TABLE `entradas` (
  `index_id` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `proveedor` varchar(60) NOT NULL,
  `ref_producto` int(11) NOT NULL,
  `detalle_completo` tinyblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `entradas` (`index_id`, `fecha_entrada`, `proveedor`, `ref_producto`, `detalle_completo`) VALUES
(3, '2022-09-02', 'DistriPrueba3', 2, NULL),
(23, '2022-09-25', 'Prueba 5', 14, NULL);

DROP TABLE IF EXISTS `existencias`;
CREATE TABLE `existencias` (
  `index_id` int(11) NOT NULL,
  `ref_producto` int(30) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `existencias` (`index_id`, `ref_producto`, `cantidad`, `fecha_ingreso`) VALUES
(1, 1, 2, '2022-09-02'),
(2, 1, 20, '2022-09-02');

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `laboratorio` varchar(60) NOT NULL,
  `fecha_ven` date NOT NULL,
  `req_formula` varchar(2) DEFAULT 'Si',
  `precioUnidad` float NOT NULL,
  `precio_unidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `productos` (`index_id`, `nombre`, `laboratorio`, `fecha_ven`, `req_formula`, `precioUnidad`, `precio_unidad`) VALUES
(1, 'Acetaminofen', '001', '2022-03-04', 'No', 0, 0),
(2, 'Aspirina', '001', '2022-01-02', 'No', 0, 0);

DROP TABLE IF EXISTS `salidas`;
CREATE TABLE `salidas` (
  `index_id` int(11) NOT NULL,
  `fecha_sal` date NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `proveedor` varchar(60) NOT NULL,
  `ref_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `vent_devpro` tinyint(1) NOT NULL,
  `cliente` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `salidas` (`index_id`, `fecha_sal`, `detalle`, `proveedor`, `ref_producto`, `cantidad`, `vent_devpro`, `cliente`) VALUES
(3, '2022-09-08', '', 'Distridrogas', 2, 2, 0, '');

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `nombre_usuario` varchar(60) NOT NULL,
  `contraseña` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `usuarios` (`index_id`, `nombre`, `nombre_usuario`, `contraseña`) VALUES
(1, 'Juan Caicedo', 'juanC', '1234'),
(2, 'Maria Mora', 'mariaM', '0000');


ALTER TABLE `detalles`
  ADD PRIMARY KEY (`index_id`);

ALTER TABLE `entradas`
  ADD PRIMARY KEY (`index_id`);

ALTER TABLE `existencias`
  ADD PRIMARY KEY (`index_id`),
  ADD KEY `FK_productos_cateUbi` (`ref_producto`);

ALTER TABLE `productos`
  ADD PRIMARY KEY (`index_id`);

ALTER TABLE `salidas`
  ADD PRIMARY KEY (`index_id`),
  ADD KEY `fk_salidas_productos` (`ref_producto`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`index_id`);


ALTER TABLE `detalles`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

ALTER TABLE `entradas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

ALTER TABLE `existencias`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `productos`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `salidas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `usuarios`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


ALTER TABLE `existencias`
  ADD CONSTRAINT `FK_productos_cateUbi` FOREIGN KEY (`ref_producto`) REFERENCES `productos` (`index_id`);

ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_salidas_productos` FOREIGN KEY (`ref_producto`) REFERENCES `productos` (`index_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
