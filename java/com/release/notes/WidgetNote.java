package com.release.notes;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.release.notes.ExampleAppWidgetConfig.SHARED_PREFS;
import static com.release.notes.ExampleAppWidgetConfig.KEY_BUTTON_TEXT;

public class WidgetNote extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
       //     Intent intent = new Intent(context, MainActivity.class); //on click widget opens this activity
        //    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
            String buttonText = prefs.getString(KEY_BUTTON_TEXT + appWidgetId, "Press me");


            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_widget);
         //   views.setOnClickPendingIntent(R.id.example_widget_button, pendingIntent);

            views.setCharSequence(R.id.example_widget_button, "setText", buttonText);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
