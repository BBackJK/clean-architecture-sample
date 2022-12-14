package bbackjk.test.caat.clean.article.application.port.in;

public interface ArticleRegisterUseCase {

    // CURD READ를 뺀 나머지를 UseCase라고 하고 Read같은 경우는 Query 라고

    void register(RegisterBoardArticleCommand command);
}
