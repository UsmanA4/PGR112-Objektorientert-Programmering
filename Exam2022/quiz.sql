create table binaryquiz(
 id int not null ,
 question varchar(50),
 correctAnswer varchar (15)
);
create table multichoicequiz(
   id int not null,
   question varchar(100),
   answerA varchar(50),
    answerB varchar(50),
	answerC varchar(50),
    answerD varchar(50),
	correctAnswer varchar(50)
   
);
create table scoretable(
 user varchar(30),
 score int not null,
 topic varchar(40)
)

select * from multichoicequiz;
select * from binaryquiz;
select * from scoretable;