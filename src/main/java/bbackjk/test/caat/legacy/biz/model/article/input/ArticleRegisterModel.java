package bbackjk.test.caat.legacy.biz.model.article.input;


import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import bbackjk.test.caat.common.utils.StringUtilz;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ArticleRegisterModel {

    private String boardType;
    private String title;
    private String contents;

    public boolean isCanRegister() {
        return StringUtilz.isNotEmpty(boardType)
                && StringUtilz.isNotEmpty(title)
                && StringUtilz.isNotEmpty(contents);
    }

    public BoardArticleDto toDto(long loginUserId) {
        return BoardArticleDto.createRegisterInstance(
            this.boardType
            , this.title
            , this.contents
            , loginUserId
        );
    }
}
