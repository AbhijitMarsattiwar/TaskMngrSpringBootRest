package com.abhi.task.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task_tbl")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="task_id")
	private Integer taskId;
	
	//@Column(name="parent_id")
	//public Integer parentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", nullable = true)
    private ParentTask parentTask;

	@Column(name="task")
	private String taskName;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
		
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="is_ended")
	private Integer isEnded;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getIsEnded() {
		return isEnded;
	}

	public void setIsEnded(Integer isEnded) {
		this.isEnded = isEnded;
	}
	
	
	
}
