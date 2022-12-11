package bbackjk.test.caat.clean.article.adapter.out.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BoardCommentEntity {

    private long id;
    private long boardArticleId;
    private long userId;
    private String contents;

}
