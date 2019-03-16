package com.abhi.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="parent_task_tbl")
public class ParentTask {
	
	@Id
	@Column(name="parent_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parentId;

	@Column(name="parent_task")
	private String parentTask;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	
}
