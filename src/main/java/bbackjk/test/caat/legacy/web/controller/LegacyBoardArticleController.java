package bbackjk.test.caat.legacy.web.controller;

import bbackjk.test.caat.legacy.biz.model.article.input.ArticleModifyModel;
import bbackjk.test.caat.legacy.biz.model.article.input.ArticleRegisterModel;
import bbackjk.test.caat.legacy.biz.model.article.output.LegacyBoardArticleDetailJson;
import bbackjk.test.caat.legacy.biz.service.BoardArticleService;
import bbackjk.test.caat.common.exception.ParameterNotValidException;
import bbackjk.test.caat.common.model.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/legacy/api/board-article")
public class LegacyBoardArticleController {

    private final BoardArticleService boardArticleService;

    @GetMapping(value = "{boardArticleId}")
    JsonResult getById(@PathVariable long boardArticleId) {

        if (boardArticleId < 1) {
            throw new ParameterNotValidException();
        }

        return JsonResult.success(
                LegacyBoardArticleDetailJson.of(boardArticleService.getById(boardArticleId))
                , 200
        );
    }

    @PostMapping(value = "")
    JsonResult post(@RequestBody ArticleRegisterModel model) {

        if (!model.isCanRegister()) {
            throw new ParameterNotValidException();
        }

        // TODO: 세션이나 jwt등 로그인한 사람의 정보로 알아야 하는데귀찮아서 그냥 정적으로 박아놓음.
        final long loginUserId = 1;

        boardArticleService.register(model.toDto(loginUserId));

        return JsonResult.success(201);
    }

    @PutMapping(value = "")
    JsonResult put(@RequestBody ArticleModifyModel model) {

        if (!model.isCanModify()) {
            throw new ParameterNotValidException();
        }

        // TODO: 세션이나 jwt등 로그인한 사람의 정보로 알아야 하는데귀찮아서 그냥 정적으로 박아놓음.
        final long loginUserId = 1;

        boardArticleService.modify(model.toDto(loginUserId));

        return JsonResult.success();
    }

}
