-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33065
-- Tiempo de generación: 08-09-2022 a las 14:43:43
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventariodrogue`
--
CREATE DATABASE IF NOT EXISTS `inventariodrogue` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inventariodrogue`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

DROP TABLE IF EXISTS `detalles`;
CREATE TABLE `detalles` (
  `index_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `ref_producto` int(11) NOT NULL,
  `precio_uni` float NOT NULL,
  `subtotal` float NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `detalles`:
--

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`index_id`, `cantidad`, `ref_producto`, `precio_uni`, `subtotal`, `fecha_ingreso`, `fecha_salida`) VALUES
(1, 2, 0, 2400, 4800, '2022-05-03', '2022-07-03'),
(2, 1, 0, 6300, 6300, '2022-08-03', '2022-09-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

DROP TABLE IF EXISTS `entradas`;
CREATE TABLE `entradas` (
  `index_id` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `proveedor` varchar(60) NOT NULL,
  `detalle` varchar(60) NOT NULL,
  `cliente` varchar(60) NOT NULL,
  `ped_devcl` tinyint(1) NOT NULL,
  `ref_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `entradas`:
--   `ref_producto`
--       `productos` -> `index_id`
--

--
-- Volcado de datos para la tabla `entradas`
--

INSERT INTO `entradas` (`index_id`, `fecha_entrada`, `proveedor`, `detalle`, `cliente`, `ped_devcl`, `ref_producto`) VALUES
(3, '2022-09-02', 'Distridrogas', '', 'Sofia Perez', 0, 2),
(4, '2022-09-08', 'Surtidrogas', '', 'Simon Lopez', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `existencias`
--

DROP TABLE IF EXISTS `existencias`;
CREATE TABLE `existencias` (
  `index_id` int(11) NOT NULL,
  `ref_producto` int(30) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `existencias`:
--   `ref_producto`
--       `productos` -> `index_id`
--

--
-- Volcado de datos para la tabla `existencias`
--

INSERT INTO `existencias` (`index_id`, `ref_producto`, `cantidad`, `fecha_ingreso`) VALUES
(1, 1, 2, '2022-09-02'),
(2, 1, 20, '2022-09-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `laboratorio` varchar(60) NOT NULL,
  `fecha_ven` date NOT NULL,
  `req_formula` varchar(2) DEFAULT 'Si',
  `precioUnidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `productos`:
--

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`index_id`, `nombre`, `laboratorio`, `fecha_ven`, `req_formula`, `precioUnidad`) VALUES
(1, 'Acetaminofen', '001', '2022-03-04', 'No', 0),
(2, 'Aspirina', '001', '2022-01-02', 'No', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

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

--
-- RELACIONES PARA LA TABLA `salidas`:
--   `ref_producto`
--       `productos` -> `index_id`
--

--
-- Volcado de datos para la tabla `salidas`
--

INSERT INTO `salidas` (`index_id`, `fecha_sal`, `detalle`, `proveedor`, `ref_producto`, `cantidad`, `vent_devpro`, `cliente`) VALUES
(3, '2022-09-08', '', 'Distridrogas', 2, 2, 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `nombre_usuario` varchar(60) NOT NULL,
  `contraseña` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `usuarios`:
--

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`index_id`, `nombre`, `nombre_usuario`, `contraseña`) VALUES
(1, 'Juan Caicedo', 'juanC', '1234'),
(2, 'Maria Mora', 'mariaM', '0000');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`index_id`),
  ADD KEY `fk_entradas_productos` (`ref_producto`);

--
-- Indices de la tabla `existencias`
--
ALTER TABLE `existencias`
  ADD PRIMARY KEY (`index_id`),
  ADD KEY `FK_productos_cateUbi` (`ref_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`index_id`),
  ADD KEY `fk_salidas_productos` (`ref_producto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`index_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `existencias`
--
ALTER TABLE `existencias`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `fk_entradas_productos` FOREIGN KEY (`ref_producto`) REFERENCES `productos` (`index_id`);

--
-- Filtros para la tabla `existencias`
--
ALTER TABLE `existencias`
  ADD CONSTRAINT `FK_productos_cateUbi` FOREIGN KEY (`ref_producto`) REFERENCES `productos` (`index_id`);

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk_salidas_productos` FOREIGN KEY (`ref_producto`) REFERENCES `productos` (`index_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
