# exception

각종 exception에 대한 정의

Exception Handler에서 모든 runtime exception을 캐치하여 논리적 실패 메세지를 내려주고있다.

* 논리적 실패 메세지
    원래 rest api 라면 회원이 없으면 404 not found를 내려주어야 하는데 404를 내려주면 client쪽에서는 그냥 Exception처럼 받아버림.
    따라서 200으로 내려주는데 JsonResult 에서 httpStatus 만 404과 result를 false로 내려주어서 처리
