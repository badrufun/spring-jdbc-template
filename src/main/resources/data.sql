create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO "PUBLIC"."PERSON"("ID","NAME","LOCATION","BIRTH_DATE")
VALUES(
10001,
'Badru',
'Dubai',
sysdate()
);

INSERT INTO "PUBLIC"."PERSON"("ID","NAME","LOCATION","BIRTH_DATE")
VALUES(
10002,
'Monu',
'Deoria',
sysdate()
);

INSERT INTO "PUBLIC"."PERSON"("ID","NAME","LOCATION","BIRTH_DATE")
VALUES(
10003,
'Tonu',
'Mumbai',
sysdate()
);

INSERT INTO "PUBLIC"."PERSON"("ID","NAME","LOCATION","BIRTH_DATE")
VALUES(
10004,
'Rahmat',
'Gujrat',
sysdate()
);

INSERT INTO "PUBLIC"."PERSON"("ID","NAME","LOCATION","BIRTH_DATE")
VALUES(
10005,
'Umar',
'Delhi',
sysdate()
);
