package com.zhl.html;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zhl.domain.Contact;
import com.zhl.service.ContactService;

import android.test.AndroidTestCase;
import android.util.Log;

public class ContactTest extends AndroidTestCase
{
	private static final String TAG = "MainActivity";
	
	public void testgetContacts() throws Throwable
	{
		List<Contact> contacts = new ContactService().getContacts();
		JSONArray array = new JSONArray();
		for (Contact contact : contacts)
		{
			JSONObject item = new JSONObject();
			item.put("id", contact.getId());
			item.put("name", contact.getNameString());
			item.put("mobile", contact.getMobile());
			array.put(item);
		}
		String json = array.toString();
		Log.i(TAG, json);
	}

}
