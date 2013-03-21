package com.zhl.domain;

public class Contact
{
	private Integer id;
	private String nameString;
	private String mobile;
	
	public Contact(Integer id,String name,String mobile)
	{
		super();
		this.id = id;
		this.nameString = name;
		this.mobile = mobile;
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getNameString()
	{
		return nameString;
	}
	public void setNameString(String nameString)
	{
		this.nameString = nameString;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	
}
