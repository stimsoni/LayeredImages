package com.example.android.layeredimages;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class ViewUtils
{

	private ViewUtils(){}
	
	/**
	 * 
	 * @param view
	 * @param imageFullPath
	 * @param imageSize If set to a value > 1, requests the decoder to
	 * 		subsample the original image, returning a smaller image to save
	 * 		memory. The sample size is the number of pixels in either dimension
	 * 		that correspond to a single pixel in the decoded bitmap. For example,
	 * 		inSampleSize == 4 returns an image that is 1/4 the width/height of
	 * 		the original, and 1/16 the number of pixels. Any value <= 1 is
	 * 		treated the same as 1. Note: the decoder will try to fulfill this
	 * 		request, but the resulting bitmap may have different dimensions that
	 * 		precisely what has been requested. Also, powers of 2 are often
	 * 		faster/easier for the decoder to honor.
	 * @throws IOException
	 */
	public static void setImageOnView(ImageView view, String imgFullPath, int imageSize)
		throws IOException
	{
		Bitmap bitmap = getScaledBitMap(view.getContext(), imgFullPath, imageSize);
		view.setImageBitmap(bitmap);
	}
	
	/**
	 * This method scales an image in the assets directory and returns a 
	 * BitmapDrawable object that can be passed to a views setImageDrawable or
	 * setBackgroundDrawable
	 * 
	 * @param context
	 * @param imgFullPath
	 * @param imageSize
	 * @return
	 * @throws IOException
	 */
	public static Bitmap getScaledBitMap(Context context, String imgFullPath,
		int imageSize)	throws IOException
	{
		InputStream instream;
		instream = context.getAssets().open(imgFullPath);
		
		BitmapFactory.Options options=new BitmapFactory.Options();
		options.inSampleSize = imageSize;
		Bitmap bitmap=BitmapFactory.decodeStream(instream, null, options);
		
		return bitmap;
	}
}
