/*
영화 예매 사이트(CGV)
조회(무비 차트)
  - 사용자는 등록된 현재 상영 중이거나 상영 예정인 영화를 조회한다.
  - 영화는 예매 내역이 많은 순으로 조회한다. -> 내역 기준으로 DESC
조회(상영 시간) - 예매하기 전
  - 사용자는 영화, 극장, 날짜를 선택해서 상영시간을 확인한다.
  - 사용자는 현재 상영 중이거나 상영 예정인 영화를 선택한다.
  - 사용자는 현재 운영 중인 극장을 선택한다.
  - 사용자는 상영시간이 등록된 날짜를 선택한다. (상영시간이 등록되지 않으면 날짜 선택이 안됨.)
  - 사용자는 영화, 극장, 날짜를 선택하여 상영시간 및 관과 전체 좌석수/예매 가능 좌석 수를 확인한다.
조회(영화 상세 조회)
  - 사용자는 영화를 선택하여 상세 조회를 한다.
  - 상세 정보는 감독, 배우, 장르, 기본정보, 개봉일, 영화 설명, 트레일러, 스틸컷이 있다.
  - 감독은 영화를 연출한 감독으로 등록된 감독 모두를 조회한다.
  - 배우는 영화에 참여한 배우로, 영화를 등록할 때 참여한 배우를 등록한 순으로 조회한다.
  - 장르는 영화 장르로, 등록된 장르 모두를 조회한다.
  - 기본 정보는 관람 나이, 런닝시간(분), 제작 국가가 조회된다.
  - 여러 나라에서 제작한 경우 제작 국가가 여러 나라가 된다.
검색
  - 사용자는 검색어를 입력하여 검색한다.
  - 검색어를 포함하는 영화와 인물을 조회한다.
  - 영화는 개봉일 순으로 조회된다.
  - 인물은 이름순으로 조회된다.
예매
  - 예매는 회원만 가능하다.
  - 상영시간을 선택하면 인원을 선택하고, 인원수에 맞게 좌석을 선택하여 예매한다.
  - 인원은 성인과 청소년으로 나누어 선택한다.
  - 좌석은 예매되지 않은 좌석들을 선택한다.
  - 예매시 할인은 적용되지 않는다.
  - 12시 이전 상영되는 영화는 조조할인 금액으로 예매한다.
영화 관리
  - 
감독/배우 관리
  - 관리자는 감독/배우를 등록, 수정, 삭제한다.
  - 감독/배우는 등록된 인물과 역할, 대표 사진을 선택하여 등록한다.
  - 한 영화인이 감독도 하고 배우도 했으면 각각 등록한다.

*/