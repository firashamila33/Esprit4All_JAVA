-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  sam. 28 oct. 2017 à 15:34
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
  `lat` double NOT NULL,
  `lng` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Address`
--

INSERT INTO `Address` (`id`, `lat`, `lng`) VALUES
(173, 37.40609645125389, -121.96695327758789),
(174, 37.39048169465409, -121.95425033569336),
(175, 37.38714012333367, -121.96291923522949),
(176, 37.39123182284687, -121.98214530944824),
(177, 37.410732521048885, -121.97227478027344),
(178, 37.38714012333367, -121.96291923522949);

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

--
-- Déchargement des données de la table `AnnonceCoLocation`
--

INSERT INTO `AnnonceCoLocation` (`id`, `address_id`, `dimensions`, `maxCoLocataire`, `loyer`, `name`, `description`, `owner_id`, `creationDate`, `expirationDate`) VALUES
(35, 173, '1', 10, 1, '', 'bus station	', 3, '2017-10-28', '1970-01-18'),
(36, 174, '1', 10, 1, '', 'oracle', 3, '2017-10-28', '1970-01-18'),
(37, 175, '1', 10, 1, '', 'Intel Mesuil', 3, '2017-10-28', '1970-01-18'),
(38, 176, '1', 10, 1, '', 'basla mechwaya college', 3, '2017-10-28', '1970-01-18'),
(39, 177, 'ss', 10, 233, '', 'ssssssssssss', 3, '2017-10-28', '1970-01-18'),
(40, 178, 'z', 10, 12.2, '', 'zzzzzzzzzzzzzz', 3, '2017-10-28', '1970-01-18');

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

--
-- Déchargement des données de la table `ImageAnnonce`
--

INSERT INTO `ImageAnnonce` (`id`, `annonceCoLocation_id`, `imageUrl`) VALUES
(9, 9, 'photo1.png'),
(10, 9, 'photo2.png'),
(11, 10, 'photo1.png'),
(12, 10, 'photo2.png'),
(13, 11, 'photo1.png'),
(14, 11, 'photo2.png'),
(17, 12, 'photo1.png'),
(18, 12, 'photo2.png'),
(21, 13, 'photo1.png'),
(22, 13, 'photo2.png'),
(25, 14, 'photo1.png'),
(26, 14, 'photo2.png'),
(27, 14, 'A beautifull pic'),
(30, 15, 'photo1.png'),
(31, 15, 'photo2.png'),
(32, 15, 'A beautifull pic'),
(35, 16, 'photo1.png'),
(36, 16, 'photo2.png'),
(37, 16, 'A beautifull pic');

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
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=179;
--
-- AUTO_INCREMENT pour la table `AnnonceCoLocataire_R`
--
ALTER TABLE `AnnonceCoLocataire_R`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `AnnonceCoLocation`
--
ALTER TABLE `AnnonceCoLocation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT pour la table `AnnonceObjetPerdu`
--
ALTER TABLE `AnnonceObjetPerdu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT pour la table `ImageAnnonce`
--
ALTER TABLE `ImageAnnonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `AnnonceCoLocataire_R`
--
ALTER TABLE `AnnonceCoLocataire_R`
  ADD CONSTRAINT `fk_AnnonceCoLocationId` FOREIGN KEY (`annonceCoLocation_id`) REFERENCES `AnnonceCoLocation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `AnnonceCoLocation`
--
ALTER TABLE `AnnonceCoLocation`
  ADD CONSTRAINT `fk_addressId` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
