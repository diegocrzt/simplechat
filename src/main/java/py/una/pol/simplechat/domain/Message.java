package py.una.pol.simplechat.domain;

import java.time.LocalDateTime;

/**
 * Mensajes a transmitirse
 *
 * @author Diego Ramírez
 * @version 1.0
 * @since 1.0 2020/06/16
 */
public class Message {
    private String username;
    private String content;
    private LocalDateTime localDateTime;

    public Message(String username, String content, LocalDateTime localDateTime) {
        this.username = username;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
