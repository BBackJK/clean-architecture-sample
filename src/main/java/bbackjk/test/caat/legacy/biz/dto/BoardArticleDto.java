package bbackjk.test.caat.legacy.biz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardArticleDto {

    private long id;
    private String boardId;
    private long userId;
    private String title;
    private String contents;
    private int viewCount;

    private LocalDateTime createdAt;
    private long createdId;

    private LocalDateTime updatedAt;
    private long updatedId;


    private String boardName;
    private String userName;

    private List<BoardCommentDto> commentList;

    private BoardArticleDto (String boardId, String title, String contents, long loginUserId) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.userId = loginUserId;
    }

    private BoardArticleDto (long id, String title, String contents, long loginUserId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userId = loginUserId;
    }

    public static BoardArticleDto createRegisterInstance(String boardId, String title, String contents, long createdId) {
        return new BoardArticleDto(boardId, title, contents, createdId);
    }

    public static BoardArticleDto createModifyInstance(long id, String title, String contents, long loginUserId) {
        return new BoardArticleDto(id, title, contents, loginUserId);
    }

    public boolean isNotSameUser(long loginUserId) {
        return this.userId != loginUserId;
    }
}
