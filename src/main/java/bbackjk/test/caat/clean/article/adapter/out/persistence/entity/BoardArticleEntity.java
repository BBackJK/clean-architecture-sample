package bbackjk.test.caat.clean.article.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardArticleEntity {

    private long id;
    private String boardId;
    private long userId;

    private String title;
    private String contents;
    private long viewCount;

    private LocalDateTime createdAt;
    private long createdId;
    private LocalDateTime updatedAt;
    private long updatedId;

}
