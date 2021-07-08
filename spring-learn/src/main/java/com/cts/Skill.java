package com.cts;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {
	
	@NotNull
	private int skill_id;
	@NotNull
	@NotBlank
	@Size(min=1, max=30)
	private String skill_name;
	public Skill() {}
	public Skill(int skill_id, String skill_name) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	@Override
	public String toString() {
		return "Skill [skill_id=" + skill_id + ", skill_name=" + skill_name + "]";
	}

}
