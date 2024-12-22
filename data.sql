-- Listage des données de la table inventaire.produits : ~7 rows (environ)
INSERT INTO `produits` (`id`, `nom`, `categorie`, `quantite`, `prix`) VALUES
	(1, 'Ordinateur Portable', 'Électronique', 15, 1200),
	(2, 'Clavier Mécanique', 'Accessoires', 30, 80.5),
	(3, 'Casque Audio', 'Audio', 20, 150),
	(4, 'Télévision 4K', 'Électronique', 10, 2500),
	(5, 'Souris', 'Accessoires', 50, 45.99),
	(6, 'Imprimante Laser', 'Bureau', 12, 300),
	(7, 'Tablette Graphique', 'Créatif', 8, 400),
	(8, 'Smartphone', 'Électronique', 25, 800),
	(9, 'Chargeur Universel', 'Accessoires', 40, 25),
	(10, 'Chaise de Bureau', 'Bureau', 18, 200);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;