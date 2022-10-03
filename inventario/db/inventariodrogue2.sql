-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-10-2022 a las 20:16:46
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `index_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `laboratorio` varchar(100) NOT NULL,
  `fecha_ven` date DEFAULT NULL,
  `ent_sal` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`index_id`, `cantidad`, `nombre`, `laboratorio`, `fecha_ven`, `ent_sal`) VALUES
(2, 5, 'Amoxicilina 500mg', 'MK', '2022-01-02', b'1'),
(14, 4, 'Losartan', 'Genfar', '2023-05-25', b'1'),
(29, 5, 'Amoxicilina 500mg', 'MK', '2022-10-12', b'1'),
(32, 2, 'Neurobion 500mg', 'Genfar', '2022-10-12', b'1'),
(34, 52, 'Vitamina C', 'MK', '2022-10-20', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `index_id` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `proveedor` varchar(60) NOT NULL,
  `ref_producto` int(11) NOT NULL,
  `detalle_completo` tinyblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `entradas`
--

INSERT INTO `entradas` (`index_id`, `fecha_entrada`, `proveedor`, `ref_producto`, `detalle_completo`) VALUES
(3, '2022-09-02', 'DistriPrueba3', 2, NULL),
(23, '2022-09-25', 'Prueba 5', 14, NULL),
(39, '2022-10-03', 'JSJS', 29, NULL),
(40, '2022-10-03', 'Copidrogas', 32, NULL),
(41, '2022-10-03', 'Mi Proveedor 1', 34, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `existencias`
--

CREATE TABLE `existencias` (
  `index_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_ven` date DEFAULT NULL,
  `laboratorio` varchar(255) DEFAULT NULL,
  `nombre_prod` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `existencias`
--

INSERT INTO `existencias` (`index_id`, `cantidad`, `fecha_ven`, `laboratorio`, `nombre_prod`) VALUES
(166, 10, '2022-01-02', 'MK', 'Amoxicilina 500mg'),
(167, 4, '2023-05-25', 'Genfar', 'Losartan'),
(168, 2, '2022-10-12', 'Genfar', 'Neurobion 500mg'),
(169, 52, '2022-10-20', 'MK', 'Vitamina C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`index_id`, `nombre`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `index_id` int(11) NOT NULL,
  `fecha_salida` date NOT NULL,
  `proveedor` varchar(60) NOT NULL,
  `ref_producto` int(11) NOT NULL,
  `detalle_completo` tinyblob DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `cliente` varchar(255) NOT NULL,
  `detalle` varchar(255) NOT NULL,
  `fecha_sal` date NOT NULL,
  `vent_devpro` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `index_id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`index_id`, `nombre`, `apellido`, `email`, `password`) VALUES
(3, 'err', 'erer', 'jerson@hotmail.com', '$2a$10$G75HG83QStf4ETXAlsl8N.xCHkFqW.j8lksw4YOumSN4vhAFENOXS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_roles`
--

CREATE TABLE `usuarios_roles` (
  `usuario_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios_roles`
--

INSERT INTO `usuarios_roles` (`usuario_id`, `rol_id`) VALUES
(3, 1);

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
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `existencias`
--
ALTER TABLE `existencias`
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`index_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`index_id`),
  ADD UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`);

--
-- Indices de la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD KEY `FK6yxg1lhuv5nievqea7rvn6afm` (`rol_id`),
  ADD KEY `FKqcxu02bqipxpr7cjyj9dmhwec` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `existencias`
--
ALTER TABLE `existencias`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=170;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD CONSTRAINT `FK6yxg1lhuv5nievqea7rvn6afm` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`index_id`),
  ADD CONSTRAINT `FKqcxu02bqipxpr7cjyj9dmhwec` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`index_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
