package bbackjk.test.caat.legacy.biz.model.article.output;


import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import bbackjk.test.caat.common.utils.DateUtilz;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LegacyBoardArticleDetailJson {

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

    public static LegacyBoardArticleDetailJson of(final BoardArticleDto dto) {
        if (dto == null) {
            return null;
        }

        return new LegacyBoardArticleDetailJson(
                dto.getId()
                , dto.getBoardName()
                , dto.getUserName()
                , dto.getTitle()
                , dto.getContents()
                , dto.getViewCount()
                , dto.getCreatedAt()
                , dto.getUpdatedAt()
        );
    }
}
