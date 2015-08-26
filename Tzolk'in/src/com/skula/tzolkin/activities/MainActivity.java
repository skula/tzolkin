package com.skula.tzolkin.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.tzolkin.activities.views.BoardView;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new BoardView(this));
	}
}