package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    private TextView fText = null;
    private TextView sText = null;
    private Button okButton = null;
    private Button cancelButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button3:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button4:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        fText = (TextView)findViewById(R.id.textView2);
        sText = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("firText")) {
            String s1 = intent.getStringExtra("firText");
            fText.setText(String.valueOf(s1));
        }
        if (intent != null && intent.getExtras().containsKey("secText")) {
            String s2 = intent.getStringExtra("secText");
            sText.setText(String.valueOf(s2));
        }


        okButton = (Button)findViewById(R.id.button3);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.button4);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}
