package com.zhl.service;

import java.util.ArrayList;
import java.util.List;

import com.zhl.domain.Contact;

public class ContactService
{
	public List<Contact> getContacts()
	{
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(23, "黄     东", "12345678909"));
		contacts.add(new Contact(39, "江美琪", "12345678909"));
		contacts.add(new Contact(23, "钟何亮", "13049828225"));
		return contacts;
	}
}
