CREATE SCHEMA `bank` DEFAULT CHARACTER SET utf8 ;
use bank;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 17-Dez-2021 às 00:11
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bank`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `personid` int(11) DEFAULT NULL,
  `iban` varchar(50) NOT NULL,
  `accountnumber` varchar(50) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `accounttypeid` int(11) DEFAULT NULL,
  `openat`datetime DEFAULT current_timestamp(),
  `expireat` datetime DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp(),
  `coinid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `coin`
--
CREATE TABLE `coin` (
  `id` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `sigla` char(11) DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `companies`
--

CREATE TABLE `companies` (
  `id` int(11) NOT NULL,
  `designation` varchar(150) NOT NULL,
  `description` text DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp(),
  `personid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `movement`
--

CREATE TABLE `movement` (
  `id` int(11) NOT NULL,
  `codeMovement` varchar(50) DEFAULT NULL,
  `accountcreditid` int(11) DEFAULT NULL,
  `accountdebitid` int(11) DEFAULT NULL,
  `bankdebitdode` varchar(50) DEFAULT NULL,
  `bankcreditcode` varchar(50) DEFAULT NULL,
  `amountmovement` float DEFAULT NULL,
  `datamovement` date DEFAULT NULL,
  `dataValidate_movement` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `numberCheque` varchar(50) DEFAULT NULL,
  `rubric` varchar(50) DEFAULT NULL,
  `agentmovementId` int(11) DEFAULT NULL,
  `typemoventId` int(11) DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firtname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `gender` ENUM('Masculino','Femenino'),
  `nif` varchar(14) NOT NULL,
  `Persontype` ENUM('Coletiva','Singular'),
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
-- --------------------------------------------------------
--
-- Estrutura da tabela `referencePayment`
--

CREATE TABLE `referencePayment` (
  `id` int(11) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `amount` float NOT NULL,
  `destination` varchar(50) NOT NULL,
  `notes` text DEFAULT NULL,
  `accountdebitid` int(11) DEFAULT NULL,
  `accountcreditid` int(11) DEFAULT NULL,
  `serviceId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `designation` varchar(150) NOT NULL,
  `price` float NOT NULL,
  `description` text DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `typeAccount`
--

CREATE TABLE `typeAccount` (
  `id` int(11) NOT NULL,
  `designation` varchar(150) NOT NULL,
  `code` varchar(12) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `typeMovement`
--

CREATE TABLE `typeMovement` (
  `id` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `code` varchar(12) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `createdat` datetime DEFAULT current_timestamp(),
  `updatedat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(50) NOT NULL,
  `personid` int(11) DEFAULT NULL,
  `createdat` datetime NOT NULL DEFAULT current_timestamp(),
  `updatedat` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `iban` (`iban`),
  ADD UNIQUE KEY `accountNumber` (`accountNumber`),
  ADD KEY `personid` (`personid`),
  ADD KEY `accounttypeid` (`accounttypeid`),
  ADD KEY `coinId` (`coinId`);

--
-- Índices para tabela `coin`
--
ALTER TABLE `coin`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `movement`
--
ALTER TABLE `movement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accountcreditid` (`accountcreditid`),
  ADD KEY `accountdebitid` (`accountdebitid`),
  ADD KEY `typemoventId` (`typemoventId`);

--
-- Índices para tabela `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nif` (`nif`);
--
-- Índices para tabela `referencePayment`
--
ALTER TABLE `referencePayment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `reference` (`reference`),
  ADD KEY `accountdebitid` (`accountdebitid`),
  ADD KEY `accountcreditid` (`accountcreditid`),
  ADD KEY `serviceId` (`serviceId`);

--
-- Índices para tabela `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `companyid` (`companyid`);

--
-- Índices para tabela `typeAccount`
--
ALTER TABLE `typeAccount`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `designation` (`designation`),
  ADD UNIQUE KEY `code` (`code`);

--
-- Índices para tabela `typeMovement`
--
ALTER TABLE `typeMovement`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `coin`
--
ALTER TABLE `coin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `companies`
--
ALTER TABLE `companies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `movement`
--
ALTER TABLE `movement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `referencePayment`
--
ALTER TABLE `referencePayment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `typeAccount`
--
ALTER TABLE `typeAccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `typeMovement`
--
ALTER TABLE `typeMovement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`personid`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`accounttypeid`) REFERENCES `typeAccount` (`id`),
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`coinId`) REFERENCES `coin` (`id`),
  ADD CONSTRAINT `account_ibfk_4` FOREIGN KEY (`coinId`) REFERENCES `coin` (`id`),
  ADD CONSTRAINT `account_ibfk_5` FOREIGN KEY (`coinId`) REFERENCES `coin` (`id`);

--
-- Limitadores para a tabela `movement`
--
ALTER TABLE `movement`
  ADD CONSTRAINT `movement_ibfk_1` FOREIGN KEY (`accountcreditid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `movement_ibfk_2` FOREIGN KEY (`accountdebitid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `movement_ibfk_3` FOREIGN KEY (`typemoventId`) REFERENCES `typeMovement` (`id`);

--
-- Limitadores para a tabela `person`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`personid`) REFERENCES `person` (`id`);

--
-- Limitadores para a tabela `referencePayment`
--
ALTER TABLE `referencePayment`
  ADD CONSTRAINT `referencePayment_ibfk_1` FOREIGN KEY (`accountdebitid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `referencePayment_ibfk_2` FOREIGN KEY (`accountcreditid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `referencePayment_ibfk_3` FOREIGN KEY (`serviceId`) REFERENCES `services` (`id`);

--
-- Limitadores para a tabela `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `services_ibfk_1` FOREIGN KEY (`companyid`) REFERENCES `companies` (`id`);
COMMIT;

ALTER TABLE `companies`
  ADD CONSTRAINT `companies_ibfk_9` FOREIGN KEY (`personid`) REFERENCES `Person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

select *from person;


/*
Obj para person 
{
  "firtname":"",
  "lastname":"",
  "gender":"",
  "nif":"",
  "Persontype":""
}

Obj para Companies 
{
  "designation":"",
  "description":"",
  "Person":{
    "firtname":"",
    "lastname":"",
  	"gender":"",
  	"nif":"",
  	"Persontype":""
  },
  "description":""
}
 
 
 Obj para coin 
{
  "designation":"",
  "sigla":""
}


Obj para account 
{
  "status":"fsfsfsf",
  "amount":10000,
  "accounttypeid":1,
  "coinid":1,
  "expireat":"2021-12-23T18:55:43.000+00:00",
  "openat":"2021-12-23T18:55:43.000+00:00"
}

Obj para typeaccount 
{
  "designation":"Conta Corrente",
  "code":"C001",
  "description":"conta corrente do cliente"
}

Obj para servicesusers 
[
	{
      "designation":"",
      "price":,
      "description":"",
      "Companies":{
        "id":1
      }
    }
]
select *from account
*/
select *from services
companiesservices
