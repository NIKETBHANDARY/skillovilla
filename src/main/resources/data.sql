INSERT INTO Country(CountryCode,Country,IsDefault) VALUES ('US','United America',0);
INSERT INTO Country(CountryCode,Country,IsDefault) VALUES ('UK','United Kingdom',0);
INSERT INTO Country(CountryCode,Country,IsDefault) VALUES ('IN','India',1);

INSERT INTO Course(CourseName,CourseDescription,Price) VALUES ('J2EE','It is for Java Enterprise edison','900');
INSERT INTO Course(CourseName,CourseDescription,Price) VALUES ('J2ME','It is for Java Mobile edison','700');
INSERT INTO Course(CourseName,CourseDescription,Price) VALUES ('J2SW','It is for Java Standard edison','80');

INSERT INTO Charge(`Name`,Description,Price,IsCountryWise,IsDefault) VALUES ('Tax','Government Tax','90',0,1);
INSERT INTO Charge(`Name`,Description,Price,IsCountryWise,IsDefault) VALUES ('Additional Cost','Additional cost','80',0,0);
INSERT INTO Charge(`Name`,Description,Price,IsCountryWise,IsDefault) VALUES ('Conversion Charges','Convert from One curency to other','70',1,0);

INSERT INTO Strategy(`Name`,Description,IsDefault) VALUES ('Free','Free',0);
INSERT INTO Strategy(`Name`,Description,IsDefault) VALUES ('One Time','One Time',1);
INSERT INTO Strategy(`Name`,Description,IsDefault) VALUES ('Subscription','Subscription',0);

INSERT INTO CountryCharges(CountryID,ChargeID,Price) VALUES (1,1,'75');

INSERT INTO CourseCharges(CourseID,ChargeID,Price) VALUES (1,1,'75');
INSERT INTO CourseCharges(CourseID,ChargeID,Price) VALUES (1,2,'90');
INSERT INTO CourseCharges(CourseID,ChargeID,Price) VALUES (2,1,'100');

INSERT INTO CoursesStrategy(CourseID,StrategyID) VALUES (1,1);
INSERT INTO CoursesStrategy(CourseID,StrategyID) VALUES (2,2);