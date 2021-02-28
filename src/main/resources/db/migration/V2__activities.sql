CREATE TABLE activities (
id BIGINT AUTO_INCREMENT,
start_time TIMESTAMP,
activity_desc VARCHAR (255),
activity_type VARCHAR (255),
PRIMARY KEY (id));

INSERT INTO activities(start_time, activity_desc, activity_type) VALUES('2021-2-12 12:10:11','Biking in Bükk','BIKING');
INSERT INTO activities(start_time, activity_desc, activity_type) VALUES('2021-2-12 12:10:11','Hiking in Bükk','HIKING');
INSERT INTO activities(start_time, activity_desc, activity_type) VALUES('2020-2-11 12:10:11','Biking in Mátra','BIKING');
INSERT INTO activities(start_time, activity_desc, activity_type) VALUES('2011-6-12 12:10:11','Basketball in Park','BASKETBALL');