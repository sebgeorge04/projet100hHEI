package o.o.daos;

import java.util.List;

public interface Utilisateur {
	List<Utilisateur> listerUtilisateurs();

	Utilisateur getUtilisateur(Long id);

	Utilisateur getUtilisateur(String mail);

	String getMotDePasseUtilisateurHashe(String identifiant);

	void supprimerUtilisateur(Long id);

	Utilisateur ajouterUtilisateur(Utilisateur nouvelUtilisateur, String motDePasse);
}
