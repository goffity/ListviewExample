package com.goffity.android.example.listviewexample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewAnimSlideRight extends Activity {

	ArrayAdapter<String> adapter;

	List<String> listValue;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_anim_slide_right);

		ListView listView = (ListView) findViewById(R.id.listViewSlideOutRight);

		listValue = new ArrayList<String>();
		listValue.add("Android");
		listValue.add("iPhone");
		listValue.add("WindowsMobile");
		listValue.add("Blackberry");
		listValue.add("WebOS");
		listValue.add("Ubuntu");
		listValue.add("Windows7");
		listValue.add("Max OS X");
		listValue.add("Linux");
		listValue.add("OS/2");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listValue);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arparentg0, View rowView,
					int positon, long id) {
				removeListItem(rowView, positon);

			}
		});
	}

	protected void removeListItem(View rowView, final int positon) {
		final Animation animation = AnimationUtils.loadAnimation(
				rowView.getContext(), android.R.anim.slide_out_right);
		rowView.startAnimation(animation);
		Handler handle = new Handler();
		handle.postDelayed(new Runnable() {

			@Override
			public void run() {
				listValue.remove(positon);
				adapter.notifyDataSetChanged();
				animation.cancel();
			}
		}, 450);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.menu_main:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			this.startActivity(intent);
			break;
		case R.id.menu_silde_right:
			intent = new Intent(getApplicationContext(),
					ListViewAnimSlideRight.class);
			this.startActivity(intent);
			break;
		case R.id.menu_fade_out:
			intent = new Intent(getApplicationContext(),
					ListViewAnimationFadeOut.class);
			this.startActivity(intent);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
}
