-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 15 juil. 2022 à 21:43
-- Version du serveur :  10.4.19-MariaDB-log
-- Version de PHP : 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jobs`
--

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

CREATE TABLE `competences` (
  `id_competence` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `competences`
--

INSERT INTO `competences` (`id_competence`, `nom`) VALUES
(1, 'Langage C'),
(2, 'analyse de donnees'),
(3, 'Javascript'),
(4, 'Bootstrap'),
(5, 'Python'),
(6, 'Comptabilité');

-- --------------------------------------------------------

--
-- Structure de la table `contrats`
--

CREATE TABLE `contrats` (
  `id_contrat` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `duree` varchar(100) NOT NULL,
  `salaire` varchar(100) NOT NULL,
  `id_offre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `demander`
--

CREATE TABLE `demander` (
  `id_offre` int(11) NOT NULL,
  `id_competence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `experiences`
--

CREATE TABLE `experiences` (
  `id_experience` int(11) NOT NULL,
  `nom_societe` varchar(200) NOT NULL,
  `poste_occupe` varchar(200) NOT NULL,
  `date_debut` varchar(100) NOT NULL,
  `date_fin` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT 'aucune',
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `experiences`
--

INSERT INTO `experiences` (`id_experience`, `nom_societe`, `poste_occupe`, `date_debut`, `date_fin`, `description`, `id_user`) VALUES
(3, 'ESMT', 'stagiaire', '10-03-2018', '24-10-2020', '', 6);

-- --------------------------------------------------------

--
-- Structure de la table `formations`
--

CREATE TABLE `formations` (
  `id_formation` int(11) NOT NULL,
  `intitule` varchar(150) NOT NULL,
  `nom_ecole` varchar(100) NOT NULL,
  `annee_debut` varchar(10) NOT NULL,
  `annee_fin` varchar(10) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formations`
--

INSERT INTO `formations` (`id_formation`, `intitule`, `nom_ecole`, `annee_debut`, `annee_fin`, `id_user`) VALUES
(1, 'LPTI', 'ESMT', '2019', '2022', 6);

-- --------------------------------------------------------

--
-- Structure de la table `notifications`
--

CREATE TABLE `notifications` (
  `id_notification` int(11) NOT NULL,
  `objet` varchar(200) NOT NULL,
  `message` varchar(255) NOT NULL,
  `id_destinataire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

CREATE TABLE `offres` (
  `id_offre` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `niveau_experience` varchar(50) NOT NULL,
  `niveau_etude` varchar(50) NOT NULL,
  `poste_propose` varchar(100) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_societe` int(11) NOT NULL,
  `id_contrat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `posseder`
--

CREATE TABLE `posseder` (
  `id_user` int(11) NOT NULL,
  `id_competence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `posseder`
--

INSERT INTO `posseder` (`id_user`, `id_competence`) VALUES
(6, 1),
(6, 2),
(6, 5),
(6, 4);

-- --------------------------------------------------------

--
-- Structure de la table `posttuler`
--

CREATE TABLE `posttuler` (
  `id_user` int(11) NOT NULL,
  `id_offre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `postuler`
--

CREATE TABLE `postuler` (
  `id_offre` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id_role`, `nom`) VALUES
(1, 'ROLE_ADMINISTRATEUR'),
(2, 'ROLE_UTILISATEUR');

-- --------------------------------------------------------

--
-- Structure de la table `societes`
--

CREATE TABLE `societes` (
  `id_societe` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id_user` int(11) NOT NULL,
  `prenom` varchar(200) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `adresse` varchar(500) NOT NULL,
  `num_tel` varchar(20) NOT NULL,
  `photo_profil` varchar(100) DEFAULT NULL,
  `token` varchar(64) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_user`, `prenom`, `nom`, `login`, `password`, `adresse`, `num_tel`, `photo_profil`, `token`, `id_role`) VALUES
(6, 'bara', 'Sarr', 'sarrbara07@gmail.com', '$2a$10$/3VwC8J/XdaCQraLoU0UtuRp0q5tiKuRALCigDgU3jJ5CTEW9uN56', 'tt', '1234', NULL, NULL, 2),
(25, 'john', 'Doe', 'johnDoe@gmail.com', '$2a$10$SQz7HSMAY.tORcErviJPJec8midO84KZj/5GgfzHtTzWUoP7.nSfW', 'tt', '1234', 'VoicemailFile.png', NULL, 2),
(26, 'test', 'test', 'test@test.sn', '$2a$10$/MWdGKAor9RxCjiGlaN7n.16WMVupyiYetky2284i4lMp9pW88142', 'tt', '1234', '', NULL, 2),
(27, 'jule', 'kamara', 'jule@gmail.com', '$2a$10$3e7aO1olWv.Q13Jr/Z5QnOYaMXsw./12meUleNCa9SsRd6WK8OrXS', 'nowhere', '77 123 45 67', '', NULL, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `competences`
--
ALTER TABLE `competences`
  ADD PRIMARY KEY (`id_competence`);

--
-- Index pour la table `contrats`
--
ALTER TABLE `contrats`
  ADD PRIMARY KEY (`id_contrat`),
  ADD KEY `offre` (`id_offre`);

--
-- Index pour la table `demander`
--
ALTER TABLE `demander`
  ADD KEY `id_offre` (`id_offre`),
  ADD KEY `id_competence` (`id_competence`);

--
-- Index pour la table `experiences`
--
ALTER TABLE `experiences`
  ADD PRIMARY KEY (`id_experience`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `formations`
--
ALTER TABLE `formations`
  ADD PRIMARY KEY (`id_formation`),
  ADD KEY `user_id` (`id_user`);

--
-- Index pour la table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id_notification`),
  ADD KEY `id_destinataire` (`id_destinataire`);

--
-- Index pour la table `offres`
--
ALTER TABLE `offres`
  ADD PRIMARY KEY (`id_offre`),
  ADD KEY `id_posteur` (`id_user`),
  ADD KEY `id_societe` (`id_societe`),
  ADD KEY `contrat` (`id_contrat`);

--
-- Index pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_competence` (`id_competence`);

--
-- Index pour la table `posttuler`
--
ALTER TABLE `posttuler`
  ADD KEY `id_offre` (`id_offre`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `postuler`
--
ALTER TABLE `postuler`
  ADD KEY `FKk36kf0uowhblsi8oljakbpjf` (`id_user`),
  ADD KEY `FKvo8j8tavn0hdx2m4tg6xvu4f` (`id_offre`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_role`);

--
-- Index pour la table `societes`
--
ALTER TABLE `societes`
  ADD PRIMARY KEY (`id_societe`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UKwxanxhwyll18224bh3y1hl54` (`login`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `competences`
--
ALTER TABLE `competences`
  MODIFY `id_competence` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `contrats`
--
ALTER TABLE `contrats`
  MODIFY `id_contrat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `experiences`
--
ALTER TABLE `experiences`
  MODIFY `id_experience` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `formations`
--
ALTER TABLE `formations`
  MODIFY `id_formation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id_notification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `offres`
--
ALTER TABLE `offres`
  MODIFY `id_offre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `societes`
--
ALTER TABLE `societes`
  MODIFY `id_societe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contrats`
--
ALTER TABLE `contrats`
  ADD CONSTRAINT `offre` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id_offre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demander`
--
ALTER TABLE `demander`
  ADD CONSTRAINT `demander_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id_offre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demander_ibfk_2` FOREIGN KEY (`id_competence`) REFERENCES `competences` (`id_competence`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `experiences`
--
ALTER TABLE `experiences`
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `formations`
--
ALTER TABLE `formations`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`id_user`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`id_destinataire`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `offres`
--
ALTER TABLE `offres`
  ADD CONSTRAINT `contrat` FOREIGN KEY (`id_contrat`) REFERENCES `contrats` (`id_contrat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_posteur` FOREIGN KEY (`id_user`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_societe` FOREIGN KEY (`id_societe`) REFERENCES `societes` (`id_societe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD CONSTRAINT `posseder_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `posseder_ibfk_2` FOREIGN KEY (`id_competence`) REFERENCES `competences` (`id_competence`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `posttuler`
--
ALTER TABLE `posttuler`
  ADD CONSTRAINT `posttuler_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offres` (`id_offre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `posttuler_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `utilisateurs` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD CONSTRAINT `utilisateurs_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
