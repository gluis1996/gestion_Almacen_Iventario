-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2022 a las 20:18:02
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
-- Base de datos: `licoreria`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarRoles` (IN `id` VARCHAR(6))   BEGIN 
SELECT 
concat(r.idroles,' - ',r.nombre) as cod
from empleado as e
INNER join roles as r on e.idroles=r.idroles 
where e.IdEmpleado=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_Cliente` (IN `IdCliente1` VARCHAR(6), IN `tipoDocumento1` VARCHAR(30), IN `docuemnto1` VARCHAR(8), IN `nombre1` VARCHAR(30), IN `apellido1` VARCHAR(30), IN `direccion1` VARCHAR(50), IN `telefono1` VARCHAR(9), IN `email1` VARCHAR(40), IN `fechaNacimiento1` DATE, IN `EstadoCivil1` CHAR(1), IN `Genero1` CHAR(1))   BEGIN
UPDATE cliente 
set tipoDocumento=tipoDocumento1,docuemnto=docuemnto1,nombre=nombre1,apellido=apellido1,direccion=direccion1,telefono=telefono1,email=email1,fechaNacimiento=fechaNacimiento1,EstadoCivil=EstadoCivil1,Genero=Genero1
where IdCliente=IdCliente1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_Actualizar_NuevoEmpleado` (IN `idEmpleado1` VARCHAR(6), IN `numeroDocumento1` VARCHAR(12), IN `nombre1` VARCHAR(30), IN `apellido1` VARCHAR(30), IN `nacionalidad1` VARCHAR(20), IN `edad1` INT, IN `distrito1` VARCHAR(30), IN `estado1` CHAR(1), IN `rol1` INT(15))   BEGIN
UPDATE Empleado SET
numeroDocumento=numeroDocumento1,
nombre=nombre1,
apellido=apellido1,
nacionalidad=nacionalidad1,
edad=edad1,
distrito=distrito1,
estado=estado1,
idroles=rol1
WHERE idEmpleado=idEmpleado1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_productoAlmacen` (IN `codigo` VARCHAR(6), IN `cantidad1` INT, IN `preciouni1` DOUBLE(7,2))   begin
UPDATE producto_almacen set Cantidad = cantidad1, Precio_Compra	= preciouni1
WHERE Idproducto =codigo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_productoPiso` (IN `codigo` VARCHAR(6), IN `cantidad1` INT, IN `preciouni1` DOUBLE(7,2), IN `limiteStock1` INT)   begin
UPDATE producto_piso set Cantidad_Piso = cantidad1, Precio_Unitario=preciouni1,LimiteStock=limiteStock1
WHERE idproducto=codigo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_proveedor` (IN `IdProveedor1` VARCHAR(6), IN `Razon_Social1` VARCHAR(50), IN `Direccion1` VARCHAR(50), IN `Correo1` VARCHAR(60), IN `Contacto1` VARCHAR(9), IN `Contacto_Comercial1` VARCHAR(50))   BEGIN
UPDATE proveedor SET 
Razon_Social=Razon_Social1,
Direccion=Direccion1,
Correo=Correo1,
Contacto=Contacto1,
Contacto_Comercial=Contacto_Comercial1
where IdProveedor=IdProveedor1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_bucarProducto` (IN `id` VARCHAR(10))   BEGIN
SELECT 
pro.Idproducto as id,
pro.Descripcion as nombre,
c.descripcion as nombre_categoria,
p.Cantidad_Piso as cantidad,
p.Precio_Unitario as precio,
p.LimiteStock as limite
FROM producto_piso as p
INNER JOIN producto as pro on pro.Idproducto=p.Idproducto
inner join categoria as c on c.IdCategoria=pro.IdCategoria
WHERE p.Idproducto=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarPAmenores` (IN `cant` INT)   BEGIN
SELECT 
p.Idproducto as id,
pro.Descripcion as nombre,
c.IdCategoria as c,
c.descripcion as nombre_categoria,
pr.RUC as ruc,
pr.Razon_Social as rz,
p.Cantidad as cantidad,
d.precioCompra as precio,
p.Precio_Compra as venta
from producto_almacen as p
inner join producto as pro on pro.idproducto=p.idproducto
inner join categoria as c on c.IdCategoria=pro.IdCategoria
INNER join detalle_almacen as d on d.idproducto=p.Idproducto
INNER join proveedor as pr on pr.RUC=d.RUC
GROUP by p.Idproducto
HAVING p.Cantidad<=cant;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarProdutoAlmacen` (IN `cod` VARCHAR(6))   BEGIN
SELECT
p.Idproducto as id,
pro.Descripcion as nombre,
c.descripcion as nombre_categoria,
c.IdCategoria as cate,
pr.RUC as ruc,
pr.Razon_Social as rz,
p.Cantidad as cantidad,
p.Precio_Compra as venta
from producto_almacen as p
inner join producto as pro on pro.idproducto=p.idproducto
inner join categoria as c on c.IdCategoria=pro.IdCategoria
INNER join detalle_almacen as d on d.idproducto=p.Idproducto
INNER join proveedor as pr on pr.RUC=d.RUC
GROUP by p.Idproducto
HAVING p.Idproducto=cod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_Usuario` (IN `usuario` VARCHAR(10), IN `pass` VARCHAR(10))   BEGIN
select 
u.usuario as usu,
u.contraseña as pass,
r.nombre as nom,
u.IdEmpleado as id
from usuario as u
INNER JOIN empleado as e on u.IdEmpleado=e.IdEmpleado
inner join roles as r on r.idroles=e.idroles
where u.usuario=usuario and u.contraseña=pass;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_vendedor` (IN `id` VARCHAR(30))   BEGIN
SELECT 
e. IdEmpleado as c,
e.numeroDocumento as de,
concat(e.nombre,' ',e.apellido) as nom
from empleado as e
WHERE e.IdEmpleado=id or e.numeroDocumento=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminarCliente` (IN `id` VARCHAR(6))   begin
DELETE FROM cliente WHERE IdCliente=id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingresar_Cliente` (IN `IdCliente1` VARCHAR(6), IN `tipoDocumento1` VARCHAR(30), IN `docuemnto1` VARCHAR(8), IN `nombre1` VARCHAR(30), IN `apellido1` VARCHAR(30), IN `direccion1` VARCHAR(50), IN `telefono1` VARCHAR(9), IN `email1` VARCHAR(40), IN `fechaNacimiento1` DATE, IN `EstadoCivil1` CHAR(1), IN `Genero1` CHAR(1))   BEGIN
insert into cliente(IdCliente,tipoDocumento,docuemnto,nombre,apellido,direccion,telefono,email,fechaNacimiento,EstadoCivil,Genero) values (IdCliente1,tipoDocumento1,docuemnto1,nombre1,apellido1,direccion1,telefono1,email1,fechaNacimiento1,EstadoCivil1,Genero1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingresar_Compra` (IN `idCompra1` VARCHAR(30), IN `IdEmpleado1` VARCHAR(6), IN `IdCliente1` VARCHAR(6), IN `total1` DOUBLE(7,2), IN `comprovante1` VARCHAR(30), IN `numero_comprovante1` VARCHAR(30), IN `cantidadTotal1` INT)   BEGIN
INSERT INTO compra (idCompra,IdEmpleado,IdCliente,Fecha_Compra,total,comprovante,numero_comprovante,cantidadTotal)
VALUES
(idCompra1,IdEmpleado1,IdCliente1,LOCALTIMESTAMP,total1,comprovante1,numero_comprovante1,cantidadTotal1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Ingresar_DetalleCompra` (IN `idCompra1` VARCHAR(30), IN `Idproducto1` VARCHAR(6), IN `Cantidad1` INT, IN `Precio_Unitario1` DOUBLE(7,2), IN `sub_total1` DOUBLE(7,2))   BEGIN
INSERT INTO detalle_compra (idCompra,Idproducto,Cantidad,Precio_Unitario,sub_total)
values (idCompra1,Idproducto1,Cantidad1,Precio_Unitario1,sub_total1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingresar_detalle_reponedor` (IN `IdEmpleado1` VARCHAR(6), IN `Idproducto1` VARCHAR(6), IN `Cantidad_Registrada1` INT(11), IN `Detalle1` VARCHAR(40))   BEGIN
INSERT INTO detalle_reponedor (IdEmpleado,Idproducto,Cantidad_Registrada,fecha,Detalle)
VALUES (IdEmpleado1,Idproducto1,Cantidad_Registrada1,LOCALTIMESTAMP,Detalle1);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingresar_proveedor` (IN `RUC1` VARCHAR(30), IN `Razon_Social1` VARCHAR(50), IN `Direccion1` VARCHAR(50), IN `Correo1` VARCHAR(60), IN `Contacto1` VARCHAR(9), IN `Contacto_Comercial1` VARCHAR(50))   BEGIN
INSERT INTO proveedor (RUC,Razon_Social,Direccion,Correo,Contacto,Contacto_Comercial,Fecha_Registro)
values (RUC1, Razon_Social1, Direccion1, Correo1 , Contacto1 ,Contacto_Comercial1,LOCALTIMESTAMP);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingreso_detalleAlmacen` (IN `ide` VARCHAR(6), IN `idpr` VARCHAR(6), IN `idRUC` VARCHAR(30), IN `cantidadI` INT, IN `precioCom` DOUBLE(7,2))   begin 

INSERT into detalle_almacen (idEmpleado,idproducto,RUC,cantidadIngresada,precioCompra,fecha)VALUES
(ide,idpr,idRUC,cantidadI,precioCom,LOCALTIMESTAMP);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ingreso_productoAlmacen` (IN `codigo` VARCHAR(6), IN `descripcion` VARCHAR(300), IN `categoria` INT(11), IN `cantidad` INT(11), IN `preciouni` DOUBLE(7,2))   begin
insert into producto (Idproducto,Descripcion,IdCategoria) values (codigo,descripcion,categoria);
insert into producto_almacen(Idproducto,Precio_Compra,Cantidad) values (codigo,preciouni,cantidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_productoPiso` (IN `codigo` VARCHAR(6), IN `descripcion` VARCHAR(300), IN `categoria` INT(11), IN `cantidad` INT, IN `preciouni` DOUBLE(7,2), IN `limiteStock` INT)   begin
insert into producto_piso(Idproducto,Cantidad_Piso,Precio_Unitario,LimiteStock) values (codigo,cantidad,preciouni,limiteStock);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_producto` ()   BEGIN
SELECT 
pro.Idproducto as id,
pro.Descripcion as nombre,
c.descripcion as nombre_categoria,
p.Cantidad_Piso as cantidad,
p.Precio_Unitario as precio,
p.LimiteStock as limite
from producto_piso as p
inner join producto as pro on pro.idproducto=p.idproducto
inner join categoria as c on c.IdCategoria=pro.IdCategoria;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_lista_productosAlmacen` ()   BEGIN
SELECT 
p.Idproducto as id,
pro.Descripcion as nombre,
c.IdCategoria as c,
c.descripcion as nombre_categoria,
pr.RUC as ruc,
pr.Razon_Social as rz,
p.Cantidad as cantidad,
d.precioCompra as precio,
p.Precio_Compra as venta
from producto_almacen as p
inner join producto as pro on pro.idproducto=p.idproducto
inner join categoria as c on c.IdCategoria=pro.IdCategoria
INNER join detalle_almacen as d on d.idproducto=p.Idproducto
INNER join proveedor as pr on pr.RUC=d.RUC
GROUP BY p.Idproducto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_NuevoEmpleado` (IN `idEmpleado` VARCHAR(6), IN `Tdocumento` VARCHAR(12), IN `numeroDocumento` VARCHAR(12), IN `nombre` VARCHAR(30), IN `apellido` VARCHAR(30), IN `nacionalidad` VARCHAR(20), IN `edad` INT, IN `genero` CHAR(1), IN `distrito` VARCHAR(30), IN `estado` CHAR(1), IN `rol` INT(15))   BEGIN
-- Crear Nombre usuario
Declare aux varchar(30);
declare pos int;
declare cuenta varchar(30);
declare letra1 varchar(30);
declare letra2 varchar(30);
declare letra3 varchar(30);
declare letra4 varchar(30);
declare contraseña varchar(30);

set pos=INSTR(apellido,' ');
set letra3=left(LOWER(nombre),1);
set aux=LOWER(SUBSTRING(lower(apellido),1,pos-1));
set cuenta=CONCAT(letra3,aux);

-- crear Contraseña
set letra1=UPPER(LEFT(nombre,1));
set letra2=UPPER(LEFT(apellido,1));
set contraseña =CONCAT(numeroDocumento,letra1,letra2);

insert into Empleado(idEmpleado,Tdocumento,numeroDocumento,nombre,apellido,nacionalidad,edad,genero,distrito,estado,idroles) 
values(idEmpleado,Tdocumento,numeroDocumento,nombre,apellido,nacionalidad,edad,genero,distrito,estado,rol);

insert into usuario(usuario,contraseña,idEmpleado,Fecha_creacion)
values(cuenta,contraseña,idEmpleado,now());
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IdCategoria` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `Descripcion`) VALUES
(1, 'Cerveza'),
(2, 'licores'),
(3, 'Cervezas artesanales'),
(4, 'Vinos'),
(5, 'Whisky'),
(6, 'Vodka'),
(12, 'Pisco'),
(13, 'espumante'),
(14, 'a'),
(15, 'b');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` varchar(6) NOT NULL,
  `tipoDocumento` varchar(30) NOT NULL,
  `docuemnto` varchar(8) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(40) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `EstadoCivil` char(1) NOT NULL,
  `Genero` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `tipoDocumento`, `docuemnto`, `nombre`, `apellido`, `direccion`, `telefono`, `email`, `fechaNacimiento`, `EstadoCivil`, `Genero`) VALUES
('CL0001', 'DNI', '75103020', 'fabian solis', 'susan paredes', 'calle 27 los olivos', '918733678', 'fabiansolis@gmail.com', '1996-09-08', 'S', 'F'),
('CL0002', 'DNI', '10203010', 'kevin', 'rojas aedo', 'pas los olvidados de dios', '123456789', 'aedo.com', '1996-10-25', 'S', 'M'),
('CL0003', 'DNI', '75109685', 'alian edison', 'gonzalo valdez', 'san borja', '99999', '@edi', '1996-11-30', 'S', 'M'),
('CL0004', 'DNI', '10204578', 'julio neyra', 'perez soto', 'ventanilla', '123456', '@edi', '1996-02-27', 'S', 'M'),
('CL0005', 'Selecionar', '75107706', 'alian edison', 'gonzalo valdez', 'san borja', '95959559', '@alian.edison', '2002-11-30', 'S', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` varchar(30) NOT NULL,
  `IdEmpleado` varchar(6) NOT NULL,
  `IdCliente` varchar(6) NOT NULL,
  `Fecha_Compra` datetime NOT NULL,
  `total` double(7,2) NOT NULL,
  `comprovante` varchar(30) NOT NULL,
  `numero_comprovante` varchar(30) NOT NULL,
  `cantidadTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `IdEmpleado`, `IdCliente`, `Fecha_Compra`, `total`, `comprovante`, `numero_comprovante`, `cantidadTotal`) VALUES
('00000001', 'E00002', 'CL0005', '2022-07-14 17:08:47', 719.00, 'Boleta', 'B001 - 00000001', 10),
('00000002', 'E00002', 'CL0002', '2022-07-14 17:10:09', 719.00, 'Factura', 'F001 - 00000001', 10),
('00000003', 'E00002', 'CL0005', '2022-07-14 22:30:55', 868.50, 'Factura', 'F001 - 00000002', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_almacen`
--

CREATE TABLE `detalle_almacen` (
  `idDetalleA` int(11) NOT NULL,
  `idEmpleado` varchar(6) NOT NULL,
  `idproducto` varchar(6) NOT NULL,
  `RUC` varchar(30) NOT NULL,
  `cantidadIngresada` int(11) NOT NULL,
  `precioCompra` double(7,2) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_almacen`
--

INSERT INTO `detalle_almacen` (`idDetalleA`, `idEmpleado`, `idproducto`, `RUC`, `cantidadIngresada`, `precioCompra`, `fecha`) VALUES
(38, 'E00004', 'P00001', '200186745010', 100, 100.90, '2022-07-14 16:05:07'),
(39, 'E00004', 'P00002', '200186745010', 100, 60.90, '2022-07-14 16:05:31'),
(40, 'E00004', 'P00003', '200186745010', 100, 110.90, '2022-07-14 16:05:53'),
(41, 'E00004', 'P00004', '200186745010', 100, 30.90, '2022-07-14 16:06:16'),
(42, 'E00004', 'P00005', '200186745010', 100, 68.90, '2022-07-14 16:12:33'),
(43, 'E00004', 'P00006', '200186745010', 100, 30.70, '2022-07-14 16:14:10'),
(44, 'E00004', 'P00007', '200186745010', 100, 20.90, '2022-07-14 22:22:49'),
(45, 'E00004', 'P00006', '200186745010', 60, 30.70, '2022-07-14 22:23:44'),
(46, 'E00004', 'P00005', '200186745010', 80, 68.90, '2022-07-14 22:23:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `idCompra` varchar(30) NOT NULL,
  `Idproducto` varchar(6) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio_Unitario` double(7,2) DEFAULT NULL,
  `sub_total` double(7,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_compra`
--

INSERT INTO `detalle_compra` (`idCompra`, `Idproducto`, `Cantidad`, `Precio_Unitario`, `sub_total`) VALUES
('00000001', 'P00005', 10, 71.90, 719.00),
('00000002', 'P00005', 10, 71.90, 719.00),
('00000003', 'P00005', 10, 71.90, 719.00),
('00000003', 'P00007', 5, 29.90, 149.50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_reponedor`
--

CREATE TABLE `detalle_reponedor` (
  `idRepo` int(11) NOT NULL,
  `IdEmpleado` varchar(6) NOT NULL,
  `Idproducto` varchar(6) NOT NULL,
  `Cantidad_Registrada` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `Detalle` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_reponedor`
--

INSERT INTO `detalle_reponedor` (`idRepo`, `IdEmpleado`, `Idproducto`, `Cantidad_Registrada`, `fecha`, `Detalle`) VALUES
(7, 'E00003', 'P00005', 20, '2022-07-14 16:50:19', ''),
(8, 'E00003', 'P00005', 50, '2022-07-14 16:52:16', 'en el area de wiskis'),
(9, 'E00003', 'P00005', 10, '2022-07-14 17:15:35', ''),
(10, 'E00003', 'P00007', 20, '2022-07-14 22:26:08', ''),
(11, 'E00003', 'P00007', 10, '2022-07-14 22:26:45', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` varchar(6) NOT NULL,
  `Tdocumento` varchar(12) NOT NULL,
  `numeroDocumento` varchar(12) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` char(1) NOT NULL,
  `distrito` varchar(30) NOT NULL,
  `estado` char(1) NOT NULL,
  `idroles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Tdocumento`, `numeroDocumento`, `nombre`, `apellido`, `nacionalidad`, `edad`, `genero`, `distrito`, `estado`, `idroles`) VALUES
('E00001', 'DNI', '75107706', 'luis Miguel', 'Gonzalo Valdez', 'peruana', 25, 'M', 'Puente Piedra', 'A', 4),
('E00002', 'Dni', '10203040', 'Emily Deysi', 'Solis Machaca', 'peruana', 22, 'F', 'Los Olivos', 'A', 2),
('E00003', 'Dni', '01867450', 'Briggite Becerra', 'Jasmine Placencia', 'Peruana', 19, 'F', 'Comas', 'A', 1),
('E00004', 'Dni', '40152030', 'Julio', 'Neyra Diaz', 'Peruano', 25, 'M', 'ventanilla', 'A', 3),
('E00005', 'Dni', '12321212', 'lucero', 'suares gomez', 'peuranan', 25, 'F', 'puente ìera', 'A', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `Idproducto` varchar(6) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `IdCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`Idproducto`, `Descripcion`, `IdCategoria`) VALUES
('P00001', 'Whisky Chivas Regal Extra 13 Años 700 ml ', 5),
('P00002', 'Combo Whisky Johnnie Walker Red label 750 ml + Evervess 1.5 L + Hielo 1.5 kg ', 5),
('P00003', 'Combo 01 Whisky Chivas 13 Años 700 Ml + 01 Evervess 1.5 Lt + Hielo ', 5),
('P00004', 'Combo 01 Whisky Grants Triple Wood S/ Estuche 1L + 01 Guarana Vitaminizada 2L + 01 Bolsa de Hielo ', 5),
('P00005', 'Combo 01 Whisky Johnnie Walker Red Label 750 + 02 Smirnoff Ice Green Apple Lata 350 ml ', 5),
('P00006', 'Combo 01 Whisky Old Times Black Label 750 Ml + 01 Energizante Flame 1.5 Lt + Hielo 1.5 Kg ', 5),
('P00007', 'Combo 01 Jarabe de Goma Artisan 360ml + 01 Bebida Carbonatada Evervess 1.5Lt + 01 Limones Malla 240gr', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_almacen`
--

CREATE TABLE `producto_almacen` (
  `Idproducto` varchar(6) NOT NULL,
  `Precio_Compra` float NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Descripcion` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto_almacen`
--

INSERT INTO `producto_almacen` (`Idproducto`, `Precio_Compra`, `Cantidad`, `Descripcion`) VALUES
('P00001', 109.9, 100, NULL),
('P00002', 64.9, 100, NULL),
('P00003', 116.9, 100, NULL),
('P00004', 38.9, 100, NULL),
('P00005', 71.9, 100, NULL),
('P00006', 39.7, 100, NULL),
('P00007', 29.9, 70, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_piso`
--

CREATE TABLE `producto_piso` (
  `Idproducto` varchar(6) NOT NULL,
  `Cantidad_Piso` int(11) NOT NULL,
  `Precio_Unitario` double(7,2) NOT NULL,
  `LimiteStock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto_piso`
--

INSERT INTO `producto_piso` (`Idproducto`, `Cantidad_Piso`, `Precio_Unitario`, `LimiteStock`) VALUES
('P00005', 50, 71.90, 10),
('P00007', 25, 29.90, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `RUC` varchar(30) NOT NULL,
  `Razon_Social` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Contacto` varchar(9) NOT NULL,
  `Contacto_Comercial` varchar(50) NOT NULL,
  `Fecha_Registro` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`RUC`, `Razon_Social`, `Direccion`, `Correo`, `Contacto`, `Contacto_Comercial`, `Fecha_Registro`) VALUES
('200186745010', 'licores sac', 'proceres ', '@licores.sac', '969594989', 'Maruja Valdez Flores', '2022-07-14 15:44:03'),
('20504678921', 'Vino Peru SAC', 'AV pardo 546 Miraflores', 'frabcisco@vinoperu.com', '203567', 'Francisco Iglesias', '2022-07-14 22:20:38'),
('2075107706', 'vinosybebidasSAC', 'proceres', '@vinosybebidasSAC', '96857452', 'lucero', '2022-07-14 19:27:15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idroles`, `nombre`) VALUES
(1, 'Reponedor'),
(2, 'Vendedor'),
(3, 'Almacenero'),
(4, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario` varchar(30) NOT NULL,
  `contraseña` varchar(10) NOT NULL,
  `Fecha_creacion` datetime DEFAULT NULL,
  `IdEmpleado` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `contraseña`, `Fecha_creacion`, `IdEmpleado`) VALUES
('bjasmine', '01867450BJ', '2022-07-14 15:40:30', 'E00003'),
('esolis', '10203040ES', '2022-07-14 15:39:01', 'E00002'),
('jneyra', '40152030JN', '2022-07-14 15:41:20', 'E00004'),
('lgonzalo', '75107706LG', '2022-07-14 15:31:57', 'E00001'),
('lsuares', '12321212LS', '2022-07-14 22:33:24', 'E00005');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `FKCliente` (`IdCliente`),
  ADD KEY `fk_Empleado` (`IdEmpleado`);

--
-- Indices de la tabla `detalle_almacen`
--
ALTER TABLE `detalle_almacen`
  ADD PRIMARY KEY (`idDetalleA`),
  ADD KEY `fkDE` (`idEmpleado`),
  ADD KEY `fkRUC` (`RUC`),
  ADD KEY `fk_pr` (`idproducto`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`idCompra`,`Idproducto`),
  ADD KEY `fk_productoP` (`Idproducto`);

--
-- Indices de la tabla `detalle_reponedor`
--
ALTER TABLE `detalle_reponedor`
  ADD PRIMARY KEY (`idRepo`),
  ADD KEY `fk_detaemp` (`IdEmpleado`),
  ADD KEY `fk_detproducotempleaod` (`Idproducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`),
  ADD KEY `fk_roles` (`idroles`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`Idproducto`),
  ADD KEY `FKCategoria` (`IdCategoria`);

--
-- Indices de la tabla `producto_almacen`
--
ALTER TABLE `producto_almacen`
  ADD PRIMARY KEY (`Idproducto`);

--
-- Indices de la tabla `producto_piso`
--
ALTER TABLE `producto_piso`
  ADD PRIMARY KEY (`Idproducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`RUC`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idroles`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`),
  ADD KEY `FK_UsuEmp` (`IdEmpleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `IdCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `detalle_almacen`
--
ALTER TABLE `detalle_almacen`
  MODIFY `idDetalleA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `detalle_reponedor`
--
ALTER TABLE `detalle_reponedor`
  MODIFY `idRepo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idroles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `FKCliente` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`),
  ADD CONSTRAINT `fk_Empleado` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`);

--
-- Filtros para la tabla `detalle_almacen`
--
ALTER TABLE `detalle_almacen`
  ADD CONSTRAINT `fkDE` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`IdEmpleado`),
  ADD CONSTRAINT `fkRUC` FOREIGN KEY (`RUC`) REFERENCES `proveedor` (`RUC`),
  ADD CONSTRAINT `fk_pr` FOREIGN KEY (`idproducto`) REFERENCES `producto_almacen` (`Idproducto`);

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `fk_compa` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `fk_productoP` FOREIGN KEY (`Idproducto`) REFERENCES `producto_piso` (`Idproducto`);

--
-- Filtros para la tabla `detalle_reponedor`
--
ALTER TABLE `detalle_reponedor`
  ADD CONSTRAINT `fk_detaemp` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`),
  ADD CONSTRAINT `fk_detproducotempleaod` FOREIGN KEY (`Idproducto`) REFERENCES `producto_piso` (`Idproducto`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_roles` FOREIGN KEY (`idroles`) REFERENCES `roles` (`idroles`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FKCategoria` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`);

--
-- Filtros para la tabla `producto_almacen`
--
ALTER TABLE `producto_almacen`
  ADD CONSTRAINT `FKPAlmacen` FOREIGN KEY (`Idproducto`) REFERENCES `producto` (`Idproducto`);

--
-- Filtros para la tabla `producto_piso`
--
ALTER TABLE `producto_piso`
  ADD CONSTRAINT `FKP_Piso` FOREIGN KEY (`Idproducto`) REFERENCES `producto` (`Idproducto`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_UsuEmp` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
