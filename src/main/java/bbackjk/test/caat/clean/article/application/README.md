# application

비즈니스로직 및 요구사항을 정의

기존 mvc에서는 해당 패키지의 여러 service들이 하나의 service로 들어가 있었지만

그럴 경우 하나의 서비스가 하는일이 너무 많아지게 됨.

서비스를 잘게 쪼개서 나누어서 단일책임의 원칙을 지키도록 함.

* crud중 cud는 command 라는 suffix를 사용하는 인터페이스를 구현
* r은 query라는 suffix를 사용하는 인터페이스를 구현




* in 패키지 해당 코드들을 호출할 때 외부에서 호출되는 코드들을 정의함.
* 즉, in 패키지는 주로 controller에서 사용하게 됨.
* 주로 Query suffix, UseCase suffix를 사용

* out 패키지는 주로 port suffix를 사용
* dao를 사용하는 adapter의 인터페이스들을 정의해놓는다. --> 이렇게 해놓은 이유는 비즈니스로직과 영속성 로직의 의존성을 낮추기 위함 
