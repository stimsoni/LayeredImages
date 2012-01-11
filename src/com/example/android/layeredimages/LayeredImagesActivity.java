package com.example.android.layeredimages;

import java.io.IOException;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class LayeredImagesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupView();
    }
    
    /* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume()
	{
		super.onResume();
		
	}
	
	private void setupView()
	{
		FrameLayout mainMap = (FrameLayout)findViewById(R.id.map_flo_labels);
		ImageView gridLayer = (ImageView)findViewById(R.id.map_img_grid);
		ImageView bounderiesLayer = (ImageView)findViewById(R.id.map_img_boundries);
		ImageView lblsLayer = (ImageView)findViewById(R.id.map_img_labels);
		String mapPath = "NorthNaturalPositive16/StarDeepMilky.png";
		String gridPath = "NorthNaturalPositive16/GridCoordinates.png";
		String bounderiesPath = "NorthNaturalPositive16/BoundariesEcliptic.png";
		String lblsPath = "NorthNaturalPositive16/Labels.png";
		try
		{
			//load base map into Frame layout's background
			mainMap.setBackgroundDrawable(
				new BitmapDrawable(ViewUtils.getScaledBitMap(this, mapPath, 2)));
			
			//More or less information can be displayed on the base map
			//by loading one or more of the below layers.
			ViewUtils.setImageOnView(gridLayer, gridPath, 2);
			ViewUtils.setImageOnView(bounderiesLayer, bounderiesPath, 2);
			ViewUtils.setImageOnView(lblsLayer, lblsPath, 2);
		}
		catch(IOException e)
		{
			Log.e("LayeredImagesActivity", "Could not load maps" +
				"[" + e.toString() + "]");
		}
	}
}