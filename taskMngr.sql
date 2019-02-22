SQL for task manager:


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
   task VARCHAR(500) NOT NULL,   
   start_date date,
   end_date date,
   priority INT,
   is_ended INT default 0,
   PRIMARY KEY ( task_id )
);


select * from tmgr.task_tbl;
insert into tmgr.parent_task_tbl (parent_task) 
values ('Parent Task 1');

insert into tmgr.parent_task_tbl (parent_task) 
values ('Parent Task 2');

insert into tmgr.task_tbl (task_id, task,start_date,end_date,priority) 
values (1,'Compile the code','2019-02-18','2019-02-20',1);

insert into tmgr.task_tbl (parent_id,task,start_date,end_date,priority) 
values (1,'Build the code','2019-02-19','2019-02-20',2);

insert into tmgr.task_tbl (parent_id,task,start_date,end_date,priority) 
values (2,'Deploy the code','2019-02-20','2019-02-22',3);

insert into tmgr.task_tbl (parent_id,task,start_date,end_date,priority) 
values (2,'Test the code','2019-02-20','2019-02-22',4);

insert into tmgr.task_tbl (parent_id,task,start_date,end_date,priority) 
values (2,'Support the code','2019-02-20','2019-02-28',5);

commit;



