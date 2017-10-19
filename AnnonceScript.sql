-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  ven. 20 oct. 2017 à 01:13
-- Version du serveur :  10.1.25-MariaDB
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `espritforall`
--

-- --------------------------------------------------------

--
-- Structure de la table `Address`
--

CREATE TABLE `Address` (
  `id` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `homeNumber` varchar(50) NOT NULL,
  `furtherAddressDescription` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Address`
--

INSERT INTO `Address` (`id`, `city`, `street`, `homeNumber`, `furtherAddressDescription`) VALUES
(4, 'Beja', '', '', ''),
(5, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(6, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(7, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(8, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(9, '1111', '', '', ''),
(10, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(11, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(12, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(13, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(14, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(15, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(16, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(17, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(18, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(19, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(20, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(21, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(22, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(23, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(24, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(25, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(26, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(27, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(28, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(29, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(30, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(31, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(32, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(33, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(34, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(35, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(36, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(37, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(38, 'Beja', 'Jassmin', '21', 'en face de monoprix'),
(39, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(40, 'Jandouba', 'Jassmin', '45', 'en face de monoprix'),
(41, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(42, 'Jandouba', 'Jassmin', '45', 'en face de monoprix'),
(43, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(44, 'El KEff', 'Jassmin', '45', 'en face de monoprix'),
(45, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(46, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(47, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(48, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(49, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(50, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(51, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(52, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(55, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(56, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(58, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(59, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(61, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(62, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(64, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(65, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(67, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(68, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(70, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(71, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(73, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(74, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(75, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(77, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(78, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(79, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(81, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(82, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(83, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(85, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(86, 'Manouba', 'REpublique', '4000', 'en face de monoprix'),
(87, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(88, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(90, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(91, 'Manouba', 'REpublique', '4000', 'en face de monoprix'),
(92, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(93, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(95, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(96, 'Manouba', 'REpublique', '4000', 'en face de monoprix'),
(97, 'Tunis', 'REpublique', '21', 'en face de monoprix'),
(98, 'Ben arous', 'Jassmin', '45', 'en face de monoprix'),
(100, 'Mourouj', 'REpublique', '4000', 'en face de monoprix'),
(101, 'Manouba', 'REpublique', '4000', 'en face de monoprix'),
(102, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(103, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(104, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(105, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(106, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(107, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(108, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(109, 'NouvelleAriana', 'Principale', '404', 'baa7dha el pole'),
(110, 'NouvelleAriana', 'Principale', '404', 'baa7dha el pole'),
(111, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(112, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(113, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(114, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(115, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(116, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(117, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(118, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(119, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(120, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(121, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(122, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(123, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(124, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(125, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(126, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(127, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(128, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(129, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(130, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(131, 'Ghazela', 'Principale', '404', 'baa7dha el pole'),
(132, 'Ghazela', 'Principale', '404', 'baa7dha el pole');

-- --------------------------------------------------------

--
-- Structure de la table `AnnonceCoLocataire_R`
--

CREATE TABLE `AnnonceCoLocataire_R` (
  `id` int(11) NOT NULL,
  `annonceCoLocation_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `AnnonceCoLocation`
--

CREATE TABLE `AnnonceCoLocation` (
  `id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `dimensions` varchar(50) NOT NULL,
  `maxCoLocataire` int(11) NOT NULL,
  `loyer` float NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `creationDate` date NOT NULL,
  `expirationDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `AnnonceObjetPerdu`
--

CREATE TABLE `AnnonceObjetPerdu` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `creationDate` date NOT NULL,
  `expirationDate` date NOT NULL,
  `objectDescription` varchar(50) NOT NULL,
  `lossDate` date NOT NULL,
  `lossLocation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `AnnonceObjetPerdu`
--

INSERT INTO `AnnonceObjetPerdu` (`id`, `name`, `description`, `owner_id`, `creationDate`, `expirationDate`, `objectDescription`, `lossDate`, `lossLocation`) VALUES
(1, 'a', 'a', 1, '2017-10-18', '2017-10-11', 'ddd', '2017-10-10', 'dazdad'),
(3, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(4, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(8, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(9, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(10, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(12, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(13, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(20, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(21, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(23, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(24, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(26, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(27, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(29, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(30, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(32, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(33, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(35, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(36, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 6', '1970-01-01', 'Bloc A'),
(37, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'Iphone 7', '1970-01-01', 'Bloc A'),
(39, 'Objet Perdu', '', 4, '1970-01-01', '1970-01-01', 'BMW Z4 Sport', '1970-01-01', 'Bloc A');

-- --------------------------------------------------------

--
-- Structure de la table `ImageAnnonce`
--

CREATE TABLE `ImageAnnonce` (
  `id` int(11) NOT NULL,
  `annonceCoLocation_id` int(11) NOT NULL,
  `imageUrl` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

-- CREATE TABLE `User` (
--   `id` int(11) NOT NULL,
--   `Name` varchar(50) NOT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `User`
--

-- INSERT INTO `User` (`id`, `Name`) VALUES
-- (1, 'ahmed'),
-- (2, 'kadhem'),
-- (3, 'ahmed'),
-- (4, 'kadhem');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Address`
--
ALTER TABLE `Address`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `AnnonceCoLocataire_R`
--
ALTER TABLE `AnnonceCoLocataire_R`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_AnnonceCoLocationId` (`annonceCoLocation_id`),
  ADD KEY `fk_Colocataire` (`User_id`);

--
-- Index pour la table `AnnonceCoLocation`
--
ALTER TABLE `AnnonceCoLocation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address_id` (`address_id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Index pour la table `AnnonceObjetPerdu`
--
ALTER TABLE `AnnonceObjetPerdu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Index pour la table `ImageAnnonce`
--
ALTER TABLE `ImageAnnonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_AnnonceCoLocation` (`annonceCoLocation_id`);

--
-- Index pour la table `User`
--
-- ALTER TABLE `User`
--   ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=133;
--
-- AUTO_INCREMENT pour la table `AnnonceCoLocataire_R`
--
ALTER TABLE `AnnonceCoLocataire_R`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;
--
-- AUTO_INCREMENT pour la table `AnnonceCoLocation`
--
ALTER TABLE `AnnonceCoLocation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT pour la table `AnnonceObjetPerdu`
--
ALTER TABLE `AnnonceObjetPerdu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT pour la table `ImageAnnonce`
--
ALTER TABLE `ImageAnnonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT pour la table `User`
--
-- ALTER TABLE `User`
--   MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `AnnonceCoLocataire_R`
--
ALTER TABLE `AnnonceCoLocataire_R`
  ADD CONSTRAINT `fk_AnnonceCoLocationId` FOREIGN KEY (`annonceCoLocation_id`) REFERENCES `AnnonceCoLocation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  -- ADD CONSTRAINT `fk_Colocataire` FOREIGN KEY (`User_id`) REFERENCES `User` (`id`);

--
-- Contraintes pour la table `AnnonceCoLocation`
--
ALTER TABLE `AnnonceCoLocation`
  ADD CONSTRAINT `fk_addressId` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  -- ADD CONSTRAINT `fk_ownerId` FOREIGN KEY (`owner_id`) REFERENCES `User` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `AnnonceObjetPerdu`
--
ALTER TABLE `AnnonceObjetPerdu`
  -- ADD CONSTRAINT `AnnonceObjetPerdu_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `User` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `ImageAnnonce`
--
ALTER TABLE `ImageAnnonce`
  ADD CONSTRAINT `fk_AnnonceCoLocation` FOREIGN KEY (`annonceCoLocation_id`) REFERENCES `AnnonceCoLocation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
