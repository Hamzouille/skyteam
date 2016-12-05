package xcarpaccio;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY // mandatory for serialization
)
public class Message {

    final String type;
    final String message;

    @JsonCreator
    public Message(
            @JsonProperty("type") String type,
            @JsonProperty("message") String message) {
        this.type = type;
        this.message = message;
    }
}
