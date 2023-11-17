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
    password VARCHAR(20) NOT NULL,
    favorites VARCHAR(20),
    reg_date DATE,
    login_date DATE,
    is_retired VARCHAR(1),
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
	eq_name VARCHAR(20) NOT NULL,
    eq_part VARCHAR(20) NOT NULL,
    eq_img BLOB,
    PRIMARY KEY(eq_name)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO user(name, password, favorites, reg_date, login_date, is_retired)
VALUES('ssafy','1234',null,null,null,'N');

-- This will insert a file in a BLOB column.
-- INSERT INTO stu_information (stu_photograph) VALUES(LOAD_FILE('/image_path/image_fileName.png'));

--  INSERT INTO place (place_name, eq_year, address, address_gu, address_dong, address_detail, eq_kind, eq_broken, eq_fix, latitude, longitude, dept, dept_phone, update_date)
-- 		VALUES ('갈매기근린공원', null, '서울특별시 강남구 압구정동 480(갈매기근린공원)', substring_index(substring_index(address,' ',2),' ',-1), substring_index(substring_index(address,' ',3),' ',-1), substring_index(address,' ',-1), '농구대, 공중걷기, 평행봉, 역기올리기', '없음', '12회 이상', 37.531496, 127.030123, '공원녹지과', '02-3423-6244', '2022-08-08' );

commit;

SELECT * FROM place;
-- SELECT * FROM user;
-- SELECT * FROM review;
-- SELECT * FROM equipment;