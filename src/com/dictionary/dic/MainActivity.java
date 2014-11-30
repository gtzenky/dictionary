package com.dictionary.dic;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.ldx.parser.LingoesLd2Reader;


public class MainActivity extends Activity {
  
  public static String SEARCH_FIELD = "com.dictionary.dic.MainActivity.search_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
          case R.id.action_search:
            return true;
  
          case R.id.action_settings:
            return true;
          
          default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public void sendMessage(View view) throws IOException {
      
      String ld2File = Environment.getExternalStorageDirectory().getAbsolutePath() + "/e.ld2";
      LingoesLd2Reader a = new LingoesLd2Reader();
      a.abc(ld2File);
      Intent intent = new Intent(this, DisplayMessageActivity.class);
      EditText searchText = (EditText) findViewById(R.id.search_message);
      String searchMessage = searchText.getText().toString();
      intent.putExtra(SEARCH_FIELD, searchMessage);
      startActivity(intent);
    }
}
