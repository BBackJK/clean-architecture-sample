package bbackjk.test.caat.legacy.biz.model.article.input;


import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import bbackjk.test.caat.common.utils.StringUtilz;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ArticleModifyModel {

    private long id;
    private String title;
    private String contents;

    public boolean isCanModify() {
        return id > 0
                && StringUtilz.isNotEmpty(title)
                && StringUtilz.isNotEmpty(contents);
    }

    public BoardArticleDto toDto(long loginUserId) {
        return BoardArticleDto.createModifyInstance(
            this.id
            , this.title
            , this.contents
            , loginUserId
        );
    }
}
