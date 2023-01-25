package id.daimus.redis.application.book.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    @NotBlank(message = "isbn can not blank")
    private String isbn;
    @NotBlank(message = "title can not blank")
    private String title;
    @NotBlank(message = "writer can not blank")
    private String writer;
    @NotBlank(message = "description can not blank")
    @NotNull
    private String description;
    @NotBlank(message = "category can not blank")
    @NotNull
    private String category;
}
