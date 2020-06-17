package py.una.pol.simplechat.service;

import org.springframework.stereotype.Service;
import py.una.pol.simplechat.domain.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Diego Ramírez
 * @version 1.0
 * @since 1.0 2020/06/16
 */
@Service
public class MessageService implements Serializable {
    private final List<Message> messages;

    public MessageService() {
        messages = new ArrayList<>();
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getAllMessages(LocalDateTime fromDateTime) {
        return messages.stream().filter(message ->
                message.getLocalDateTime().isAfter(fromDateTime)
        ).collect(Collectors.toList());
    }
}
