package bbackjk.test.caat.clean.article.adapter.in.controller.model.output;


import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.common.utils.DateUtilz;
import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BoardArticleDetailJson {

    private long id;
    private String boardName;
    private String userName;

    private String title;
    private String contents;
    private long viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public String getCreatedAtText() {
        return DateUtilz.toString(createdAt);
    }

    public String getUpdatedAtText() {
        return DateUtilz.toString(updatedAt);
    }


    public static BoardArticleDetailJson of(final BoardArticle article) {
        if (article == null) {
            return null;
        }

        return new BoardArticleDetailJson(
                article.getId().getValue()
                , article.getBoard().getName()
                , article.getUser().getName()
                , article.getTitle()
                , article.getContents()
                , article.getViewCount()
                , article.getCreatedAt()
                , article.getUpdatedAt()
        );
    }
}
