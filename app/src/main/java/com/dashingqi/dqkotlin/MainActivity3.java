package com.dashingqi.dqkotlin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dashingqi.annotation.KotlinJvmAnnotation;
import com.dashingqi.annotation.KotlinJvmAnnotationKt;
import com.dashingqi.annotation.KotlinJvmAnnotationOne;
import com.dashingqi.arithmetic.solution.DQJavaSolution;
import com.dashingqi.arithmetic.sort.BubbleSort;
import com.dashingqi.arithmetic.sort.InsertSort;
import com.dashingqi.arithmetic.sort.QuickSort;
import com.dashingqi.design.lsp.LSPMain;
import com.dashingqi.intents.IntentsKt;
import com.dashingqi.objects.Main;
import com.dashingqi.objects.Man;
import com.dashingqi.objects.ObjectMain;
import com.dashingqi.objects.ObjectMainKt;
import com.dashingqi.objects.Person;
import com.dashingqi.operators.OperatorsMainKt;
import com.dashingqi.screen.AndroidScreen;
import com.dashingqi.trys.TryMainKt;

import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = "MainActivity3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        recordViewCreateTime();
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
        int[] sortArray = BubbleSort.bubbleSortOne(array);
        Log.d(TAG, "sortArray = " + Arrays.toString(sortArray));
//        int[] insertArray = {107, 56, 0, 33, 7, 24, 68, 12, 90, 100};
//        int[] insertArrays = InsertSort.insertSort(insertArray);
//        Log.d(TAG, "insertArrays = " + Arrays.toString(insertArrays));
        int intValue = TryMainKt.tryMain();
        Log.d("TryMain", "intValue = " + intValue);

        String intentUri = IntentsKt.getIntentUri();
        Log.d(TAG, "intentUri = " + intentUri);

        LSPMain.lspMethod();
        String num2 = DQJavaSolution.decimalToBinary(8);
        System.out.println("num2 = " + num2);


        OperatorsMainKt.operatorMain();
        KotlinJvmAnnotation.INSTANCE.getMethod();
        KotlinJvmAnnotationOne.Companion.getMethod();
        KotlinJvmAnnotationKt.getStaticMethod();

        KotlinJvmAnnotationOne kotlinJvmAnnotationOne = new KotlinJvmAnnotationOne();
        KotlinJvmAnnotationOne one = kotlinJvmAnnotationOne;
        kotlinJvmAnnotationOne.setName("heiha");
        String name = one.getName();
        Log.d(TAG, "onCreate: name ----> " + name);
        kotlinJvmAnnotationOne = null;
        String afterName = one.getName();
        Log.d(TAG, "after onCreate: name ----> " + afterName);
//        String name = kotlinJvmAnnotationOne.name;
//        kotlinJvmAnnotationOne.name = "";

    }

    /**
     * 收集每个空间的加载耗时
     */
    private void recordViewCreateTime() {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new LayoutInflater.Factory2() {
            @Nullable
            @Override
            public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
                Log.d(TAG, "onCreateView ---> name is " + name);
                long start = System.currentTimeMillis();
                getDelegate().createView(parent, name, context, attrs);
                long end = System.currentTimeMillis();
                Log.d(TAG, "onCreateView cost time is ---> " + (end - start));
                return null;
            }

            @Nullable
            @Override
            public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
                return null;
            }
        });
    }
}