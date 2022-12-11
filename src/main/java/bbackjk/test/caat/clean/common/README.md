# 공통 코드

Component annotation, Service annotation을 사용하여 특정 역할을 한다는 의미를 부여하는 어노테이션을 정의.

* SelfValidating

셀프벨리데이팅은 java validation api를 사용하여 

application 의 in pakcage에서 argument로 사용되는 객체들의 부모역할을 함.

이유:: 비즈니스로직의 입력 유효성은 비즈니스로직에 사용하기에는 비즈니스로직의 역할이 많아지고,
컨트롤러에서 체크하기에는 해당 객체를 사용하는 모든 컨트롤러에서 입력 유효성을 체크하기에는 의미없는 코드가 많아지기 때문에
생성하는 시점에 생성자를 통해 데이터 유효성을 체크
