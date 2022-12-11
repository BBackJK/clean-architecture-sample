package bbackjk.test.caat.legacy.web.controller;

import bbackjk.test.caat.common.model.JsonResult;
import bbackjk.test.caat.legacy.biz.service.BoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/legacy/api/board-comment")
public class LegacyBoardCommentController {

    private final BoardCommentService boardCommentService;

    @PostMapping(value = "")
    JsonResult post() {

        //         boardCommentService.register();

        return JsonResult.success(201);
    }

    @PutMapping(value = "")
    JsonResult put() {

        //         boardCommentService.modify();

        return JsonResult.success();
    }

}
