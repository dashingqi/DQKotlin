package com.dashingqi.dqkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.view.View;

import com.dashingqi.objects.Main;
import com.dashingqi.objects.Man;
import com.dashingqi.objects.ObjectMain;
import com.dashingqi.objects.ObjectMainKt;
import com.dashingqi.objects.Person;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Person.foo();
        ObjectMain.INSTANCE.findMain();
        Man.InnerSingleton.INSTANCE.findMan();
        findViewById(R.id.testContext).setOnClickListener(view -> {
            ObjectMainKt.testContext(null);
        });

    }
}