package com.zhl.html;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.zhl.domain.Contact;
import com.zhl.service.ContactService;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

/**
 * @author dehoo-ZhongHeliang 2013-3-20下午午21:17:23
 * @version jdk 1.6; sdk 4.2.0
 */
public class MainActivity extends Activity
{
	private static final String TAG = "MainActivity";
	private ContactService contactService;
	private WebView webView;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		contactService = new ContactService();
		webView = (WebView)this.findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new ContactPlugin(), "contact");
		webView.loadUrl("file:///android_asset/index.html");
//		webView.loadUrl("http://192.168.1.110/version.xml");
	}
	
	private final class ContactPlugin
	{
		public void getContacts()
		{
			List<Contact> contacts = contactService.getContacts();
			try
			{
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
				webView.loadUrl("javascript:show('"+json+"')");
			}
			catch (JSONException e)
			{
				e.printStackTrace();
			}
		}
		
		public void call(String mobile)
		{
			Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+mobile));
			startActivity(intent);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
