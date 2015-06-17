package com.example.simplelsit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {

	// List view
	ListView lv;

	// Listview Adapter
	ArrayAdapter<String> adapter;

	// Search EditText
	EditText search;


	// ArrayList for Listview
	ArrayList<HashMap<String, String>> productList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	// Listview Data
	String websites[] = {"Google","Gmail","Gplus","Facebook","Linkedin","Instagram","Pintrest","Twitter","Snapchat","Skype"};

	lv = (ListView) findViewById(R.id.list_view);
	search = (EditText) findViewById(R.id.search);

	// Adding items to list view
	adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.singleitem, R.id.website_name,websites);
	lv.setAdapter(adapter);

	/**
	* Enabling Search Filter
	* */

	/*If the user  want to react to the user typing inside an EditText , we use  the addTextChangedListener method.
	When the user types a single character the code of onTextChanged is running and everything ok.
	So if for example the user types "g" then onTextChanged will begin to run.*/

	search.addTextChangedListener(new TextWatcher()
	{

	/*This method is called to notify you that, within s,
	the count characters beginning at start have just replaced old text that had length before.
	It is an error to attempt to make changes to s from this callback.
	*/
	@Override
	public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3)
	{
	// When user changed the Text
	MainActivity.this.adapter.getFilter().filter(cs);
	}

	/*This method is called to notify you that, within s,
	*  the count characters beginning at start are about to be replaced by new text with length after.
	*  It is an error to attempt to make changes to s from this callback. (non-Javadoc)
	* @see android.text.TextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
	*/
	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3)

	{
	// TODO Auto-generated method stub

	}
	/*This method is called to notify you that,
	* somewhere within s, the text has been changed.
	*  It is legitimate to make further changes to s from this callback,
	*  but be careful not to get yourself into an infinite loop,
	*  because any changes you make will cause this method to be called again recursively.
	*  (You are not told where the change took place because other afterTextChanged() methods
	*  may already have made other changes and invalidated the offsets.
	*  But if you need to know here, you can use setSpan(Object, int, int, int)
	*  in onTextChanged(CharSequence, int, int, int) to mark your place and then
	*  look up from here where the span ended up. (non-Javadoc)
	* @see android.text.TextWatcher#afterTextChanged(android.text.Editable)
	*/

	@Override
	public void afterTextChanged(Editable arg0)
	{
	// TODO Auto-generated method stub
	}
	});
	}

	}