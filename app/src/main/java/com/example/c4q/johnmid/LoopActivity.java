package com.example.c4q.johnmid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private TextView taskTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskTextView = findViewById(R.id.task_textview);
        new LoopTask().execute(0);
    }

    private class LoopTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {

            int counter = 0;
            for (int i = integers[0]; i < 100000; i++) {
                publishProgress(i);
                counter++;
            }
            return counter;
        }

        @Override
        protected void onProgressUpdate(Integer... n) {
            taskTextView.setText("Loops Completed: " + n);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            taskTextView.setText("Loops completed: " + integer);
            Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
