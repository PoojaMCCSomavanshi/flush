package com.java.practice.eagerlazy;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Alian_info")
public class Alian {
	@Id
	private int aid;
	private String aname;
	@OneToMany(mappedBy="alian", fetch=FetchType.EAGER)
	private Collection<Laptop> lap=new ArrayList<Laptop>();
	
	
	public Collection<Laptop> getLap() {
		return lap;
	}
	public void setLap(Collection<Laptop> lap) {
		this.lap = lap;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Alian(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}
	public Alian() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Alian [aid=" + aid + ", aname=" + aname + "]";
	}
	

}
