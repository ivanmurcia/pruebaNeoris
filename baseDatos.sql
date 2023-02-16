-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.32 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for basedatos
CREATE DATABASE IF NOT EXISTS `basedatos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `basedatos`;

-- Dumping structure for table basedatos.cuentas
CREATE TABLE IF NOT EXISTS `cuentas` (
  `id_cuenta` bigint NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `numero_cuenta` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `saldo_inicial` decimal(38,2) NOT NULL,
  `tipo_cuenta` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cliente_id_persona` bigint DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `FKerufrrdrxo0mfgi31wikmtyn0` (`cliente_id_persona`),
  CONSTRAINT `FKerufrrdrxo0mfgi31wikmtyn0` FOREIGN KEY (`cliente_id_persona`) REFERENCES `personas` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table basedatos.cuentas: ~5 rows (approximately)
INSERT INTO `cuentas` (`id_cuenta`, `estado`, `numero_cuenta`, `saldo_inicial`, `tipo_cuenta`, `cliente_id_persona`) VALUES
	(1, b'1', '478758', 1425.00, 'Ahorro', 1),
	(2, b'1', '225487', 700.00, 'Corriente', 2),
	(3, b'1', '495878', 150.00, 'Ahorros', 3),
	(4, b'1', '496825', 1080.00, 'Ahorros', 2),
	(5, b'1', '585545', 1000.00, 'Corriente', 1);

-- Dumping structure for table basedatos.movimientos
CREATE TABLE IF NOT EXISTS `movimientos` (
  `id_movimiento` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `saldo` decimal(38,2) DEFAULT NULL,
  `tipo_movimiento` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `valor` decimal(38,2) NOT NULL,
  `cuenta_id_cuenta` bigint NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `FK7dg9eam32ow23n4moo6x5oo6d` (`cuenta_id_cuenta`),
  CONSTRAINT `FK7dg9eam32ow23n4moo6x5oo6d` FOREIGN KEY (`cuenta_id_cuenta`) REFERENCES `cuentas` (`id_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table basedatos.movimientos: ~4 rows (approximately)
INSERT INTO `movimientos` (`id_movimiento`, `fecha`, `saldo`, `tipo_movimiento`, `valor`, `cuenta_id_cuenta`) VALUES
	(1, '2023-02-16 11:42:26.811000', 1425.00, 'DEBITO', 575.00, 1),
	(2, '2023-02-16 11:42:48.892000', 700.00, 'CREDITO', 600.00, 2),
	(3, '2023-02-16 11:43:24.305000', 150.00, 'CREDITO', 150.00, 3),
	(4, '2023-02-16 11:43:40.866000', 1080.00, 'CREDITO', 540.00, 4);

-- Dumping structure for table basedatos.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `dtype` varchar(31) COLLATE utf8mb4_general_ci NOT NULL,
  `id_persona` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `edad` int NOT NULL,
  `genero` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `identificacion` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contrasena` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `id_cliente` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table basedatos.personas: ~3 rows (approximately)
INSERT INTO `personas` (`dtype`, `id_persona`, `direccion`, `edad`, `genero`, `identificacion`, `nombre`, `telefono`, `contrasena`, `estado`, `id_cliente`) VALUES
	('Cliente', 1, 'Otavalo sn y principal', 33, 'Masculino', '52348381', 'Jose Lema', '098254785', '1234', b'1', '0e807a97-3f63-43f8-977a-e408ea3a5e3a'),
	('Cliente', 2, 'Amazonas y NNUU', 37, 'Femenino', '10161478', 'Marianela Montalvo', '097548965', '5678', b'1', 'd1f95804-b64e-42a0-b06d-5a83e403f729'),
	('Cliente', 3, '13 junio y Equinoccial', 43, 'Masculino', '79896541', 'Juan Osorio', '098874587', '1245', b'1', '75f10874-3107-42f5-94c1-959ee88c9308');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
