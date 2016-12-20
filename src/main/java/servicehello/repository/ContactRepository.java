package servicehello.repository;

import servicehello.model.Contact;

import java.util.List;

/**
 * Repository for {@link servicehello.model.Contact} domain objects.
 *
 * @author Leonid Dubravsky
 */
public interface ContactRepository {

    List<Contact> getFilteredContacts(String parameter);

    public List<Contact> retrieveContactsWithPaging(int pageSize, int pageNumber, String parameter);
}

