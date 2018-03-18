-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-03-2018 a las 20:20:40
-- Versión del servidor: 5.6.29
-- Versión de PHP: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aplicacionescritoriogestionhotel`
--
CREATE DATABASE IF NOT EXISTS `aplicacionescritoriogestionhotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `aplicacionescritoriogestionhotel`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `usuario`, `contraseña`) VALUES
(1, 'admin', 'admin'),
(2, 'trabajador1', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `precio` int(11) NOT NULL,
  `servicios` varchar(150) NOT NULL,
  `oferta` int(11) NOT NULL,
  `ocupacion` int(11) NOT NULL,
  `planta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `tipo`, `precio`, `servicios`, `oferta`, `ocupacion`, `planta`) VALUES
(1, 'matrimonio', 42, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones, catering', 0, 1, 1),
(2, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones, catering', 0, 1, 1),
(3, 'camas triples', 48, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 2, 1),
(4, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 1, 1),
(5, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 3, 1),
(6, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 4, 1),
(7, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 2, 1),
(8, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 3, 1),
(9, 'matriminio', 42, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 3, 1),
(10, 'matriminio', 42, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 2, 1),
(11, 'matriminio', 42, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 1, 1),
(12, 'camas triples', 48, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 1, 1),
(13, 'camas triples', 48, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 2, 1),
(14, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 1, 1),
(15, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 3, 1),
(16, 'camas dobles', 40, 'aire acondicionado, calefaccion, TV, bañera, balcon, servicio de habitaciones', 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` int(11) NOT NULL,
  `dni` char(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `dni`, `nombre`, `apellidos`, `telefono`, `email`, `sexo`) VALUES
(1, '70895270R', 'Ismael', 'Garcia Martin', '667076490', 'doblevrap@hotmail.com', 'H'),
(2, '11111111H', 'Rafael', 'Juarez Martin', '675757575', 'rjuarez@hotmail.com', 'H'),
(3, '70895270R', 'Ismael', 'Garcia Martin', '676676676', 'doblevrap@hotmail.com', 'H'),
(4, '70895270R', 'Ismael', 'Garcia Martin', '667667667', 'dog@hotm.com', 'H'),
(5, '70895270R', 'Rafa', 'Rafa', '678678678', 'rafa@rafa.es', 'H'),
(6, '70895270R', 'Jose', 'Mata Moros', '678677666', 'matamoros@mata.es', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `id` int(11) NOT NULL,
  `Nhabitacion` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`id`, `Nhabitacion`, `fecha`) VALUES
(1, 4, '2018-03-19'),
(2, 4, '2018-03-20'),
(3, 4, '2018-03-21'),
(4, 4, '2018-03-22'),
(5, 4, '2018-03-23'),
(6, 4, '2018-03-24'),
(7, 4, '2018-03-25'),
(8, 4, '2018-03-26'),
(9, 5, '2018-03-18'),
(10, 8, '2018-03-26'),
(11, 10, '2018-03-19'),
(12, 10, '2018-03-20'),
(13, 10, '2018-03-21'),
(14, 10, '2018-03-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `fechaReserva` char(10) NOT NULL,
  `fechaEntrada` char(10) NOT NULL,
  `fechaSalida` char(10) NOT NULL,
  `tipoPago` int(11) NOT NULL,
  `Nhabitacion` int(11) NOT NULL,
  `cliente` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `fechaReserva`, `fechaEntrada`, `fechaSalida`, `tipoPago`, `Nhabitacion`, `cliente`) VALUES
(1, '2018-2-18', '2018-3-20', '2018-3-28', -1, 2, '70895270R'),
(2, '2018-2-18', '2018-3-20', '2018-3-27', -1, 3, '70895270a'),
(3, '2018-2-18', '2018-3-19', '2018-3-26', 0, 4, '70895270R'),
(4, '2018-2-18', '2018-3-26', '2018-3-26', -1, 8, '70895270R'),
(5, '2018-2-18', '2018-3-19', '2018-3-22', 1, 10, '70895270R');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
