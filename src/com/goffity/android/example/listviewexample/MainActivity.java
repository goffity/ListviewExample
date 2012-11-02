package com.goffity.android.example.listviewexample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayAdapter<String> adapter;
	List<String> listValue;
	String[] values;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.mylist);
		// values = new String[] { "Android", "iPhone", "WindowsMobile",
		// "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		// "Linux", "OS/2" };
		//
		// listValue = Arrays.asList(values);
		listValue = new ArrayList<String>();
		listValue.add("Android");
		listValue.add("iPhone");
		listValue.add("WindowsMobile");

		// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		// adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, android.R.id.text1, values);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listValue);

		// Assign adapter to ListView
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View rowView,
					int positon, long id) {
				Toast.makeText(
						rowView.getContext(),
						"Position: " + positon + ": "
								+ listValue.get(positon).toString(),
						Toast.LENGTH_SHORT).show();

				removeListItem(rowView, positon);

			}

		});
	}

	protected void removeListItem(View rowView, final int positon) {
		// TODO Auto-generated method stub
		final Animation animation = AnimationUtils.loadAnimation(
				rowView.getContext(), R.anim.splashfadeout);
		rowView.startAnimation(animation);
		Handler handle = new Handler();
		handle.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// values.remove(positon);
				listValue.remove(positon);
				adapter.notifyDataSetChanged();
				animation.cancel();
			}
		}, 1000);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}