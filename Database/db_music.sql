-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 25, 2017 at 11:11 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_music`
--
CREATE DATABASE IF NOT EXISTS `db_music` DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci;
USE `db_music`;

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `albumId` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `albumName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`id`, `albumId`, `albumName`) VALUES
(1, 'A1', 'Tiếng Anh'),
(2, 'A2', 'Tiáº¿ng Viá»?t');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorId` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `authorname` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genreId` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `genreName` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `singer`
--

CREATE TABLE IF NOT EXISTS `singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `singerId` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `singerName` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE IF NOT EXISTS `songs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songID` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `songName` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `author_id` int(11) NOT NULL,
  `album_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  `singer_id` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `lyric` text COLLATE utf8_vietnamese_ci,
  PRIMARY KEY (`id`),
  KEY `fk_genre_song` (`genre_id`),
  KEY `fk_author_song` (`author_id`),
  KEY `fk_singer_song` (`singer_id`),
  KEY `fk_album_song` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `fullname` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `phone` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `fk_user_role` (`roleid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `fullname`, `phone`, `email`, `roleid`) VALUES
(1, 'admin', '$2a$10$LJxSNKNHaADkJQS4LQsYXeafeP4t5Jaiz49EEGgb5zyZGIb4nFmzW', 1, 'Jasmine', '01225543977', 'jasmine@gmail.com', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `songs`
--
ALTER TABLE `songs`
  ADD CONSTRAINT `fk_album_song` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  ADD CONSTRAINT `fk_author_song` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `fk_genre_song` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `fk_singer_song` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
