package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnKeyListener {
	
	private EditText m_vwEditTextName;
	private EditText m_vwEditTextValue;
    private Button m_vwButton;
    private ListView m_vwList;
    private ArrayAdapter<String> m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        
        m_vwEditTextName = (EditText) findViewById(R.id.editTextName);
        m_vwEditTextValue = (EditText) findViewById(R.id.editTextValue);
        m_vwButton = (Button) findViewById(R.id.buttonValidate);
        m_vwList = (ListView) findViewById(R.id.listView);
        
        
        m_adapter = new ArrayAdapter<String>(this, R.layout.textview);
        String[] listItems = getResources().getStringArray(R.array.listitems);
        for (String item : listItems) {
            m_adapter.add(item);
        }
        m_vwList.setAdapter(m_adapter);
        
        m_vwButton.setOnClickListener(this);
        m_vwEditTextName.setOnKeyListener(this);
        m_vwEditTextValue.setOnKeyListener(this);
        
        
        
//        TextView tv = new TextView(this);
//        tv.setText("Hello Site du Z�r0 !");
         
//        setContentView(tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                String item = m_vwEditTextName.getText().toString();
                m_vwEditTextName.setText("");
                if (!item.equals("")) m_adapter.add(item);
            }
            return true;
        }
        return false;
    }


	@Override
    public void onClick(View v) {
        String item = m_vwEditTextName.getText().toString();
        m_vwEditTextName.setText("");
        if (!item.equals("")) m_adapter.add(item);
    }
    
}
