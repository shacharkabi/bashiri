package io.swagger.api;

import io.swagger.model.Contact;

import com.bre.mapper.ContactMapper;
import com.bre.services.ContactSevicesFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-24T08:09:34.281Z")

@Controller
public class ContactsApiController implements ContactsApi {

    private static final Logger log = LoggerFactory.getLogger(ContactsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContactsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addContact(@ApiParam(value = "Contact to add"  )  @Valid @RequestBody Contact contact) {
        String accept = request.getHeader("Accept");
        ContactSevicesFactory.getService().createContact(ContactMapper.map(contact));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Contact>> searchContacts(@NotNull @ApiParam(value = "pass a contact Id for looking up a cotact", required = true) @Valid @RequestParam(value = "contactId", required = true) String contactId,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Contact>>(objectMapper.readValue("[ {  \"last_name\" : \"Doe\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"first_name\" : \"John\",  \"birthDate\" : \"2016-08-29T09:12:33.001Z\"}, {  \"last_name\" : \"Doe\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"first_name\" : \"John\",  \"birthDate\" : \"2016-08-29T09:12:33.001Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Contact>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Contact>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
