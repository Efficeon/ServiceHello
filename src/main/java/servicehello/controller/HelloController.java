package servicehello.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import servicehello.model.Contact;
import servicehello.service.ContactService;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by lion on 19.12.16.
 */

@Controller
@RequestMapping("/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    ContactService service;

    @RequestMapping(value = "/contacts", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ContactsHolder> getFilteredContacts(@RequestParam(value = "nameFilter", required = true) String nameFilter) {
        try {
            Pattern pattern = Pattern.compile(nameFilter);
        } catch (PatternSyntaxException e) {
            return new ResponseEntity<ContactsHolder>(HttpStatus.BAD_REQUEST);
        }
        List<Contact> contacts = service.getFilteredContacts(nameFilter);
        if (contacts.isEmpty()) {
            return new ResponseEntity<ContactsHolder>(HttpStatus.NO_CONTENT);
        }

        ContactsHolder result = new ContactsHolder(contacts);
        return new ResponseEntity<ContactsHolder>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts/{page}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ContactsHolder> getFilteredContactsUsingPaging(
            @RequestParam(value = "nameFilter", required = true) String nameFilter,
            @PathVariable(value = "page") int page) {
        Pattern pattern;
        try {
            pattern = Pattern.compile(nameFilter);
        } catch (PatternSyntaxException e) {
            return new ResponseEntity<ContactsHolder>(HttpStatus.BAD_REQUEST);
        }
        List<Contact> contacts = service.retrieveContacts(10, page, nameFilter);
        if (contacts.isEmpty()) {
            return new ResponseEntity<ContactsHolder>(HttpStatus.NO_CONTENT);
        }

        ContactsHolder result = new ContactsHolder(contacts);
        return new ResponseEntity<ContactsHolder>(result, HttpStatus.OK);
    }

    static class ContactsHolder {
        @JsonProperty
        List<Contact> contacts;

        public ContactsHolder(List<Contact> contacts) {
            this.contacts = contacts;
        }
    }
}
