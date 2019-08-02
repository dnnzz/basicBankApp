-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 02 Ağu 2019, 09:49:04
-- Sunucu sürümü: 5.7.17-log
-- PHP Sürümü: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kur`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hesaplar`
--

CREATE TABLE `hesaplar` (
  `h_id` int(11) NOT NULL,
  `h_bakiye` double NOT NULL,
  `h_bakiye_dolar` double NOT NULL,
  `h_bakiye_euro` double NOT NULL,
  `h_sahip` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `hesaplar`
--

INSERT INTO `hesaplar` (`h_id`, `h_bakiye`, `h_bakiye_dolar`, `h_bakiye_euro`, `h_sahip`) VALUES
(0, 74.001, 70, 0, 0),
(1, 658.2909999999999, 10, 0, 1),
(2, 334, 11, 0, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyeler`
--

CREATE TABLE `uyeler` (
  `k_id` int(20) NOT NULL,
  `k_ad` varchar(65) NOT NULL,
  `k_sifre` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `uyeler`
--

INSERT INTO `uyeler` (`k_id`, `k_ad`, `k_sifre`) VALUES
(0, 'Deniz', 1234),
(1, 'Ali', 1234),
(2, 'Veli', 1234);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `hesaplar`
--
ALTER TABLE `hesaplar`
  ADD PRIMARY KEY (`h_id`),
  ADD KEY `h_sahip` (`h_sahip`);

--
-- Tablo için indeksler `uyeler`
--
ALTER TABLE `uyeler`
  ADD PRIMARY KEY (`k_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `hesaplar`
--
ALTER TABLE `hesaplar`
  MODIFY `h_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Tablo için AUTO_INCREMENT değeri `uyeler`
--
ALTER TABLE `uyeler`
  MODIFY `k_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `hesaplar`
--
ALTER TABLE `hesaplar`
  ADD CONSTRAINT `hesaplar_ibfk_1` FOREIGN KEY (`h_sahip`) REFERENCES `uyeler` (`k_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
