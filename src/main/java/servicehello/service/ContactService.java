package servicehello.service;

import servicehello.model.Contact;

import java.util.List;

/**
 * Services for {@link servicehello.model.Contact}
 * @author Leonid Dubravsky
 */
public interface ContactService {
    List<Contact> getFilteredContacts(String parameter);

    public List<Contact> retrieveContacts(int pageSize, int pageNumber, String parameter);
}
