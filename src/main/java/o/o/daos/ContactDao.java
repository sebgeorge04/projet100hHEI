package o.o.daos;

import java.util.List;

import o.o.entities.Contact;

public interface ContactDao {
	public List<Contact> listContact();
	public Contact getContact(String nom);
	public Contact addContact(Contact contact);
	public Contact deleteContact(String nom);
	public Contact ModifContact(String nom);
}
