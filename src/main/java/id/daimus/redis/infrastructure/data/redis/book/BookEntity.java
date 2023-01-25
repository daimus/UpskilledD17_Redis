package id.daimus.redis.infrastructure.data.redis.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class BookEntity implements Serializable {
    @Id
    private String id;
    private String isbn;
    private String title;
    private String writer;
    private String description;
    private String category;
}
