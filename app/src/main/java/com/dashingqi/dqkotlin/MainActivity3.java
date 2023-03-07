package com.dashingqi.dqkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dashingqi.arithmetic.sort.BubbleSort;
import com.dashingqi.arithmetic.sort.InsertSort;
import com.dashingqi.arithmetic.sort.QuickSort;
import com.dashingqi.objects.Main;
import com.dashingqi.objects.Man;
import com.dashingqi.objects.ObjectMain;
import com.dashingqi.objects.ObjectMainKt;
import com.dashingqi.objects.Person;

import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = "MainActivity3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Person.foo();
        ObjectMain.INSTANCE.findMain();
        Man.InnerSingleton.INSTANCE.findMan();
        findViewById(R.id.testContext).setOnClickListener(view -> {
            int[] insertArray = {107, 56, 0, 33, 7, 24, 68, 12, 90, 100};
            int[] insertArrays = InsertSort.insertSort(insertArray);
            Log.d(TAG, "insertArrays = " + Arrays.toString(insertArrays));
        });

        findViewById(R.id.btnQuickSort).setOnClickListener(view -> {
            int[] insertArray = {107, 56, 0, 33, 7, 24, 68, 12, 90, 100};
            QuickSort.quickSort(insertArray, 0, insertArray.length - 1);
        });
        int[] array = {1, 6, 0, 3, 7, 4, 68, 12, 90, 100};
        int[] sortArray = BubbleSort.bubbleSort(array);
        Log.d(TAG, "sortArray = " + Arrays.toString(sortArray));
//        int[] insertArray = {107, 56, 0, 33, 7, 24, 68, 12, 90, 100};
//        int[] insertArrays = InsertSort.insertSort(insertArray);
//        Log.d(TAG, "insertArrays = " + Arrays.toString(insertArrays));

    }
}