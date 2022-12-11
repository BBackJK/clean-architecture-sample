package bbackjk.test.caat.legacy.biz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardCommentDto {

    private long id;
    private long boardArticleId;
    private long userId;
    private String contents;


    private String userName;


    public boolean isNotSameUser(long loginUserId) {
        return this.userId != loginUserId;
    }

}
