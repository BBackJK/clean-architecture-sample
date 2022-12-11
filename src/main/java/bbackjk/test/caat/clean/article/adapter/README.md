# adapter

adapter

아키텍처의 가장자리의 위치.

in : 해당 서비스로 들어오는 로직을 정의 (ex: controller)
out: 해당 서비스에서 바깥쪽에 위치하는 로직을 정의 (ex: persistence 영속성계층, 혹은 외부 api 호출)

adapter 의 핵심은 각각 코드들이 변경되어도(DAO를 mybatis를 사용하던지, hibernate를 사용하던지) 
비즈니스로직 (UseCase)는 변경될 일이 없도록 의존성을 낮춘다.



