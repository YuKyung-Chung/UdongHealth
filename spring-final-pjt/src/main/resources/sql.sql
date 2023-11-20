DROP DATABASE IF EXISTS udong_health;
CREATE DATABASE udong_health DEFAULT CHARACTER SET utf8mb4;

USE udong_health;

CREATE TABLE if not exists `place` (
	place_id INT AUTO_INCREMENT,
    place_name VARCHAR(20) NOT NULL,
    eq_year VARCHAR(10),
    address VARCHAR(50) NOT NULL,
	address_gu VARCHAR(20),
    address_dong VARCHAR(20),
    address_detail VARCHAR(50),
    eq_kind VARCHAR(500),
    eq_broken VARCHAR(50),
    eq_fix VARCHAR(10),
    latitude DOUBLE,
    longitude DOUBLE,
    dept VARCHAR(50),
    dept_phone VARCHAR(50),
    update_date DATE,
    PRIMARY KEY(place_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE if not exists `user` (
	user_id INT AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(20) NOT NULL,
    favorites VARCHAR(20),
    reg_date DATETIME,
    login_date DATETIME,
    is_retired VARCHAR(1) DEFAULT 'N',
    PRIMARY KEY(user_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE if not exists `review` (
	review_id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    place_id INT NOT NULL,
    writer VARCHAR(20) NOT NULL,
    view_cnt INT default 0,
    content TEXT NOT NULL,
    PRIMARY KEY(review_id),
    FOREIGN KEY (user_id) REFERENCES `user` (user_id),
    FOREIGN KEY (place_id) REFERENCES `place` (place_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE if not exists `equipment` (
	eq_id INT AUTO_INCREMENT,
    eq_part VARCHAR(20) NOT NULL,
    eq_div JSON,
	eq_name TEXT,
    eq_div_count int,
    PRIMARY KEY(eq_id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- 데이터 삽입
INSERT INTO equipment(eq_part, eq_div,eq_name)
VALUES('온몸','["온몸","몸","몸통","바디"]','[]'),
('상체','["상체"]','[]'),
('허리','["허리","옆"]','[]'),
('가슴','["가슴","바스트"]','[]'),
('배','["뱃살","배","복근"]','[]'),
('어깨','["어깨","숄더"]','[]'),
('등','["등"]','[]'),
('팔','["양팔","팔","암"]','[]'),
('하체','["다리","레그","하체","발"]','[]'),
('지구력','["철봉","봉","턱걸이","매달리기","노젓기"]','[]'),
('웨이트','["웨이트","역기","당기기","프레스"]','[]'),
('유산소','["달리기","런닝","마라톤","조깅","유산소","걷기","워킹","워크","워커","스탭","사이클","싸이클","자전거"]','[]'),
('스트레칭','["지압","안마","마사지","풀기","스트레칭"]','[]'),
('유연성','["유연성","돌리기","트위스트","스윙","롤링"]','[]'),
('기타','[]','[]');

-- 계산된 값 업데이트
UPDATE equipment
SET eq_div_count = (SELECT COUNT(*) FROM JSON_TABLE(eq_div, '$[*]' COLUMNS(cnt FOR ORDINALITY)) AS eq_div_count);

-- 데이터 검색
SELECT *
FROM equipment
WHERE eq_div LIKE '%몸%';



SELECT *
FROM place
ORDER BY (6371
		*ACOS(COS(RADIANS(37.5013068))
    	*COS(RADIANS(latitude))
        *COS(radians(longitude)-RADIANS(127.0396597))
        +SIN(RADIANS(37.5013068))*SIN(RADIANS(latitude))))
LIMIT 4;


INSERT INTO user(name, email, password, favorites, reg_date)
VALUES('정유경','ssafy1@gmail.com','1234',null,now()),
('조용환','ssafy2@gmail.com','1234',null,now());

INSERT INTO review(user_id, place_id, writer, content)
VALUES(1,1,'정유경','여기 완전 추천이에용'),
(2,1,'조용환','운동하기 아주 좋네요');

commit;

SELECT * FROM place;
SELECT * FROM user;
SELECT * FROM review;
SELECT * FROM equipment;