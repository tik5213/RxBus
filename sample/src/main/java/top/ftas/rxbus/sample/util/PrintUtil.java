package top.ftas.rxbus.sample.util;

import android.util.Log;

/**
 * Created by ybf326 on 17/6/24.
 */

public class PrintUtil {
	public static void print(String msg){
		Log.i("rxbus",msg + " -->" + Thread.currentThread());
	}
}
