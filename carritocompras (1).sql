-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-08-2023 a las 23:03:05
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carritocompras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombres`, `apellidos`, `dni`, `telefono`, `email`) VALUES
(1, 'MIGUEL ANGEL', 'LOPEZ COLLANTES', '41135822', '968872571', 'miguel.lopez.collantes@gmail.com'),
(2, 'CARLOS', 'QUIROZ', '45324677', '912567876', 'cquiroz@gmail.com'),
(3, 'FELIX', 'DEL ROSARIO', '23455467', '934234543', 'fdelrozario@hotmail.com'),
(4, 'FLAVIA', 'PAREDES', '56432321', '967734164', 'flaviaparedes@gmail.com'),
(5, 'CINTHYA', 'TALLEDO', '43709719', '987567321', 'cinthya@gmail.com'),
(6, 'MARTIN', 'LOPEZ', '53426771', '956123234', 'martinlopez@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id`, `id_venta`, `id_producto`, `cantidad`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 1),
(3, 2, 1, 1),
(4, 2, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`) VALUES
(1, 'Mouse', 15),
(2, 'Teclado', 35.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `id_cliente`, `fecha`) VALUES
(1, 1, '2023-08-15'),
(2, 2, '2023-08-16'),
(3, 1, '2023-08-17');


-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `view_detalle`
-- (Véase abajo para la vista actual)
--

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `view_ventas`
-- (Véase abajo para la vista actual)
--

-- --------------------------------------------------------

--
-- Estructura para la vista `view_detalle`
--
DROP TABLE IF EXISTS `view_detalle`;

CREATE  VIEW `view_detalle`  AS SELECT `d`.`id` AS `id`, `d`.`id_venta` AS `id_venta`, `p`.`nombre` AS `nombre`, `p`.`precio` AS `precio`, `d`.`cantidad` AS `cantidad`, `p`.`precio`* `d`.`cantidad` AS `subtotal` FROM (`detalle_venta` `d` join `producto` `p` on(`d`.`id_producto` = `p`.`id`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `view_ventas`
--
DROP TABLE IF EXISTS `view_ventas`;

CREATE view `view_ventas`  AS SELECT `v`.`id` AS `id`, concat(`c`.`nombres`,' ',`c`.`apellidos`) AS `cliente`, `v`.`fecha` AS `fecha`, sum(`p`.`precio` * `d`.`cantidad`) AS `total` FROM (((`cliente` `c` join `venta` `v` on(`c`.`id` = `v`.`id_cliente`)) join `detalle_venta` `d` on(`v`.`id` = `d`.`id_venta`)) join `producto` `p` on(`d`.`id_producto` = `p`.`id`)) GROUP BY `v`.`id` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`);


--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;


--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
