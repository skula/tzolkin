package com.skula.tzolkin.cnst;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.skula.tzolkin.R;


public class PictureLibrary {
	private Map<Integer, Bitmap> map;

	@SuppressLint("UseSparseArrays")
	public PictureLibrary(Resources res) {
		this.map = new HashMap<Integer, Bitmap>();
		this.map.put(R.drawable.background, BitmapFactory.decodeResource(res, R.drawable.background));
		this.map.put(R.drawable.building_1, BitmapFactory.decodeResource(res, R.drawable.building_1));
	}

	public Bitmap get(int id) {
		return map.get(id);
	}
}