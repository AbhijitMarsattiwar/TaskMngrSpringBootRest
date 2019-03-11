/**	SQL for task manager: **/

create schema 'tmgr';

create table
tmgr.parent_task_tbl(
   parent_id INT NOT NULL AUTO_INCREMENT,
   parent_task VARCHAR(500) NOT NULL,   
   PRIMARY KEY ( parent_id )
);

create table
tmgr.task_tbl(
   task_id INT NOT NULL AUTO_INCREMENT,
   parent_id INT,
   project_id INT,
   user_id INT ,
   task VARCHAR(500) NOT NULL,   
   start_date date,
   end_date date,
   priority INT,
   is_ended INT default 0,
   PRIMARY KEY ( task_id )
);

create table
tmgr.project_tbl(
   project_id INT NOT NULL AUTO_INCREMENT,
   project_name VARCHAR(500) NOT NULL,   
   user_id INT,
   start_date date,
   end_date date,
   priority INT,   
   PRIMARY KEY ( project_id )
);

create table
tmgr.user_tbl(
   user_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(200) NOT NULL,   
   last_name VARCHAR(200) NOT NULL,   
   employee_id VARCHAR(20) NOT NULL,    
   PRIMARY KEY ( user_id )
);

select * from tmgr.task_tbl;
insert into tmgr.parent_task_tbl (parent_task) 
values ('Parent Task 1');

insert into tmgr.parent_task_tbl (parent_task) 
values ('Parent Task 2');

insert into tmgr.user_tbl (user_id, first_name,last_name,employee_id) 
values (1,'Abhijit','Marsattiwar','am10001');
insert into tmgr.user_tbl (user_id, first_name,last_name,employee_id) 
values (2,'Aman','Bansal','ab10002');
insert into tmgr.user_tbl (user_id, first_name,last_name,employee_id) 
values (3,'Sameer','Tambe','st10003');

insert into tmgr.project_tbl (project_id, project_name,start_date,end_date,priority,user_id) 
values (1,'FMC4ME','2019-02-18','2019-02-20',1,1);
insert into tmgr.project_tbl (project_id, project_name,start_date,end_date,priority,user_id) 
values (2,'TREASURY EYE','2019-03-05','2019-03-20',2,2);
insert into tmgr.project_tbl (project_id, project_name,start_date,end_date,priority,user_id) 
values (3,'GCMS','2019-03-05','2019-03-21',3,3);

insert into tmgr.task_tbl (task_id,project_id,user_id, task,start_date,end_date,priority) 
values (1,1,1,'Compile the code','2019-02-18','2019-02-20',1);

insert into tmgr.task_tbl (parent_id,project_id,user_id,task,start_date,end_date,priority) 
values (1,1,1,'Build the code','2019-02-19','2019-02-20',2);

insert into tmgr.task_tbl (parent_id,project_id,user_id,task,start_date,end_date,priority) 
values (2,2,2,'Deploy the code','2019-02-20','2019-02-22',3);

insert into tmgr.task_tbl (parent_id,project_id,user_id,task,start_date,end_date,priority) 
values (2,3,3,'Test the code','2019-02-20','2019-02-22',4);

insert into tmgr.task_tbl (parent_id,project_id,user_id,task,start_date,end_date,priority) 
values (2,2,2,'Support the code','2019-02-20','2019-02-28',5);

commit;



