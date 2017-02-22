package o.o.daos;

import java.util.List;

import o.o.entities.Devis;

public interface DevisDao {
	public Devis addDevis(Devis devis);
	public List<Devis> listDevis();
}
