package o.o.daos;

import java.util.List;

import o.o.entities.Comptes;

public interface ComptesDao {
		public List<Comptes> listComptes();
		public Comptes getComptes(String nom);
		public Comptes addComptes(Comptes compte);
		public Comptes deleteComptes(String nom);
		public Comptes ModifComptes(String nom);
	}

