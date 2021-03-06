package servicehello.repository;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import servicehello.model.Contact;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JPA implementation for {@link servicehello.repository.ContactRepository}
 */
@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private static final Logger logger = LoggerFactory.getLogger(ContactRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getFilteredContacts(String parameter) {
        Pattern pattern = Pattern.compile(parameter);
        List<Contact> contacts = new LinkedList<Contact>();

        StatelessSession session = this.sessionFactory.openStatelessSession();

        ScrollableResults contactCursor = session.createQuery("from Contact").scroll(ScrollMode.FORWARD_ONLY);

        logger.info("Getting contacts: " + parameter + "...");

        while (contactCursor.next()) {
            Contact currentContact = (Contact) contactCursor.get(0);
            Matcher m = pattern.matcher(currentContact.getName());
            if (!m.matches()) {
                contacts.add(currentContact);
            }
        }
        contactCursor.close();
        session.close();

        logger.info(contacts.size() + " contacts found.");

        return contacts;
    }


    /**
     * Methods for paging
     */
    public List<Contact> retrieveContactsWithPaging(int pageSize, int pageNumber, String parameter) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contact> contacts = null;

        Query query = session.createQuery("from Contact");
        query = query.setFirstResult(pageSize * (pageNumber - 1));
        query.setMaxResults(pageSize);
        contacts = query.list();

        return filterContacts(contacts, parameter);
    }

    private LinkedList<Contact> filterContacts(List<Contact> allContacts, String param) {

        Pattern pattern = Pattern.compile(param);
        LinkedList<Contact> sortedContacts = new LinkedList<Contact>(allContacts);

        Iterator<Contact> contactIterator = sortedContacts.iterator();
        while (contactIterator.hasNext()) {
            Contact currentContact = contactIterator.next();
            Matcher matcher = pattern.matcher(currentContact.getName());
            if (matcher.matches()) contactIterator.remove();
        }

        return sortedContacts;
    }
}
