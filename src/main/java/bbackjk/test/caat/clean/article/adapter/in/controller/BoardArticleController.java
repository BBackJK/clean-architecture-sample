package bbackjk.test.caat.clean.article.adapter.in.controller;

import bbackjk.test.caat.clean.article.adapter.in.controller.model.input.ArticleModifyInput;
import bbackjk.test.caat.clean.article.adapter.in.controller.model.input.ArticleRegisterInput;
import bbackjk.test.caat.clean.article.adapter.in.controller.model.output.BoardArticleDetailJson;
import bbackjk.test.caat.clean.article.application.port.in.*;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.common.exception.ParameterNotValidException;
import bbackjk.test.caat.common.model.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board-article")
public class BoardArticleController {

    private final ArticleModifyUseCase articleModifyUseCase;
    private final ArticleRegisterUseCase articleRegisterUseCase;
    private final BoardArticleDetailQuery boardArticleDetailQuery;
    private final BoardArticleListQuery boardArticleListQuery;

    @GetMapping(value = "{boardArticleId}")
    JsonResult getById(@PathVariable long boardArticleId) {
        if (boardArticleId < 1) {
            throw new ParameterNotValidException();
        }

        return JsonResult.success(
                BoardArticleDetailJson.of(
                        boardArticleDetailQuery.getById(
                                new BoardArticle.BoardArticleId(boardArticleId)
                        )
                )
        );
    }

    @GetMapping(value = "{boardArticleId}/read")
    JsonResult readById(@PathVariable long boardArticleId) {
        if (boardArticleId < 1) {
            throw new ParameterNotValidException();
        }

        return JsonResult.success(
                BoardArticleDetailJson.of(
                        boardArticleDetailQuery.readById(
                                new BoardArticle.BoardArticleId(boardArticleId)
                        )
                )
        );
    }

    @PostMapping(value = "")
    JsonResult post(@RequestBody ArticleRegisterInput input) {
        // 세션으로 처리해야하지만 로그인 시스템 안만들었으니 이걸로 박음.
        final long loginUserId = 1;
        articleRegisterUseCase.register(input.toCommand(loginUserId));
        return JsonResult.success(201);
    }

    @PatchMapping(value = "")
    JsonResult patch(@RequestBody ArticleModifyInput input) {
        // 세션으로 처리해야하지만 로그인 시스템 안만들었으니 이걸로 박음.
        final long loginUserId = 1;
        articleModifyUseCase.modify(input.toCommand(loginUserId));
        return JsonResult.success(200);
    }

}
