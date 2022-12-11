# 클린코드

클린코드의 핵심은 기존 mvc에서 사용하던 controller -> service -> dao 로직에서

service와 dao 사이의 계층을 추가하여 service와 dao의 의존성을 줄이는게 핵심이라고 생각함.

이렇게되면 자연스럽게 큰 변경없이 비즈니스로직을 서술할 수 있기 때문.

해당 예제에서 사용하는 boardArticle 비즈니스로직은 단순하지만 

관리하는 게시판의 범위가 커질 수 있음. (ex. 공지사항, 1:1문의, 자주묻는질문, 카드뉴스 등등..)

이럴 때 각각 사용하는 컬럼들이 존재하게 되고, 각각 게시판 타입마다 비즈니스로직이 달라지게 됨.

이럴 경우 각 보드타입마다 비즈니스로직을 작성하게 되면 코드 의존성이 자연스럽게 사라짐.

이 때, 단점으로는 쓸데없는 코드가 많아진다고 생각할 수 있지만, 쓸데없는 코드가 아니라 의존성을 줄이는 코드라

사이드 이펙트를 최대한 줄이게 된다는 장점이 있음.

지금 사용하는 비즈니스로직에서는 입력모델, 비즈니스모델, 영속성 모델을 다 다르게 했지만

필요에 따라 세 계층에서 사용하는 모델이 정말 동일하다면 영속성 모델을 제외하고 입력모델, 비즈니스모델은 동일하게 가도 무방.
