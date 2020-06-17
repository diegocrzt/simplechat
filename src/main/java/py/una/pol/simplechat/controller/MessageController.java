package py.una.pol.simplechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import py.una.pol.simplechat.domain.Message;
import py.una.pol.simplechat.service.MessageService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Diego Ramírez
 * @version 1.0
 * @since 1.0 2020/06/16
 */
@RestController
@RequestMapping("/")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "")
    public String home() {
        return "Simple Chat Server";
    }

    @GetMapping(path = {"messages/{datetime}", "messages"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Message> getMessagesFrom(@PathVariable(required = false, name = "datetime") String dateTime) {
        if (dateTime == null) {
            return messageService.getAllMessages();
        } else {
            final LocalDateTime fromDateTime = LocalDateTime.parse(dateTime);
            return messageService.getAllMessages(fromDateTime);
        }
    }


    @PostMapping(path = "messages", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void acceptMessage(@RequestBody Message message) {
        if (null == message.getUsername() || message.getUsername().isEmpty() ||
                null == message.getContent() || message.getContent().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "The attributes username and content should be non-empty string");
        }
        message.setLocalDateTime(LocalDateTime.now());

        messageService.addMessage(message);
    }
}
