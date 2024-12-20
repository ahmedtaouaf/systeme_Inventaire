-- Listage des données de la table inventaire.produits : ~7 rows (environ)
REPLACE INTO `produits` (`id`, `nom`, `categorie`, `quantite`, `prix`) VALUES
	(2, 'Produit1', 'Catégorie1', 10, 99.99),
	(3, 'Produit1', 'Catégorie1', 10, 99.99),
	(4, 'Produit1', 'CatÃ©gorie1', 10, 99.99),
	(5, 'Produit1', 'CatÃ©gorie1', 10, 99.99),
	(6, 'ahmed', 'ahmed', 2, 100),
	(7, 'maticha', 'maticha', 2, 10),
	(8, 'aaaa', 'tttt', 10, 200),
	(9, '2', '2', 1, 100);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;