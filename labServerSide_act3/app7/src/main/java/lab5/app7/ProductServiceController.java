package lab5.app7;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lab5.app7.Product;
import lab5.app7.PhoneEntry;


@RestController
public class ProductServiceController {
   private static Map<String, Product> phonebookRepo = new HashMap<>();
   private static Map<String, PhoneEntry> entryRepo = new HashMap<>();
   static {
      Product phonebook1 = new Product();
      phonebook1.setId("1");
      phonebook1.setName("Phonebook 1");
      phonebookRepo.put(phonebook1.getId(), phonebook1);
      
      Product phonebook2 = new Product();
      phonebook2.setId("2");
      phonebook2.setName("Phonebook 2");
      phonebookRepo.put(phonebook2.getId(), phonebook2);

      Product phonebook3 = new Product();
      phonebook3.setId("3");
      phonebook3.setName("Phonebook 3");
      phonebookRepo.put(phonebook3.getId(), phonebook3);

      PhoneEntry entry1= new PhoneEntry();
      entry1.setBookid(phonebook1.getId());
      entry1.setBookname(phonebook1.getName());
      entry1.setFirstname("George");
      entry1.setLastname("Velas");
      entry1.setPhone("5863775199");
      entryRepo.put(entry1.getFirstname(), entry1);

      PhoneEntry entry2= new PhoneEntry();
      entry2.setBookid(phonebook2.getId());
      entry2.setBookname(phonebook2.getName());
      entry2.setFirstname("Mike");
      entry2.setLastname("Jones");
      entry2.setPhone("4803556099");
      entryRepo.put(entry2.getFirstname(), entry2);
   }
   
   @RequestMapping(value = "/phonebook/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      phonebookRepo.remove(id);
      return new ResponseEntity<>("Phonebook is deleted successsfully", HttpStatus.OK);
   }
   
   @RequestMapping(value = "/phonebook/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updatePhonebook(@PathVariable("id") String id, @RequestBody Product phonebook) { 
      phonebookRepo.remove(id);
      phonebook.setId(id);
      phonebookRepo.put(id, phonebook);
      return new ResponseEntity<>("Phonebook is updated successsfully", HttpStatus.OK);
   }
   
   @RequestMapping(value = "/phonebook", method = RequestMethod.POST)
   public ResponseEntity<Object> createPhonebook(@RequestBody Product phonebook) {
      phonebookRepo.put(phonebook.getId(), phonebook);
      return new ResponseEntity<>("Phonebook is created successfully", HttpStatus.CREATED);
   }
   
   @RequestMapping(value = "/phonebook")
   public ResponseEntity<Object> getPhonebook() {
      return new ResponseEntity<>(phonebookRepo.values(), HttpStatus.OK);
   }
   @RequestMapping(value = "/entry")
   public ResponseEntity<Object> getEntry() {
      return new ResponseEntity<>(entryRepo.values(), HttpStatus.OK);
   }
   @RequestMapping(value = "/entry/{firstName}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteEntry(@PathVariable("firstName") String firstName) { 
      entryRepo.remove(firstName);
      return new ResponseEntity<>("PhoneEntry is deleted successsfully", HttpStatus.OK);
   }
   @RequestMapping(value = "/entry/{firstName}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updatePhoneEntry(@PathVariable("firstName") String firstName, @RequestBody PhoneEntry entry) { 
      entryRepo.remove(firstName);
      entry.setFirstname(firstName);
      entryRepo.put(firstName, entry);
      return new ResponseEntity<>("PhoneEntry is updated successsfully", HttpStatus.OK);
   }
   @RequestMapping(value = "/entry", method = RequestMethod.POST)
   public ResponseEntity<Object> createPhoneEntry(@RequestBody PhoneEntry entry) {
      entryRepo.put(entry.getFirstname(), entry);
      return new ResponseEntity<>("PhoneEntry is created successfully", HttpStatus.CREATED);
   }
}
