package com.dashingqi.dqkotlin;

import android.util.Log;

/**
 * @author zhangqi61
 * @since 2022/2/22
 */
public class TruCatch {
    private static final String TAG = "TruCatch";
    public static void perform(String str){
        try{
          str.length();
        }catch (Exception exception){

        }

        Log.d(TAG, "perform: ");
    }
}
