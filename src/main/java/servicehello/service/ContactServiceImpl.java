package servicehello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicehello.model.Contact;
import servicehello.repository.ContactRepository;

import java.util.List;

/**
 * implementation fot {@link servicehello.service.ContactService}
 * @author Leonid Dubravsky
 */

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    @Transactional
    public List<Contact> getFilteredContacts(String param) {
        return contactRepository.getFilteredContacts(param);
    }

    @Override
    @Transactional
    public List<Contact> retrieveContacts(int pageSize, int pageNumber, String param) {
        return contactRepository.retrieveContactsWithPaging(pageSize, pageNumber, param);
    }

}
