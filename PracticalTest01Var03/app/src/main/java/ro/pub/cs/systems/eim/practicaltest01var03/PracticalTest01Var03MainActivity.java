package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private CheckBox checkBox1 = null;
    private CheckBox checkBox2 = null;
    private EditText editText1 = null;
    private EditText editText2 = null;
    private Button nextActivity = null;
    private Button displayInfo = null;
    private TextView textView = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.button:

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                    String firText = editText1.getText().toString();
                    String secText = editText2.getText().toString();
                    intent.putExtra("firText", firText);
                    intent.putExtra("secText", secText);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;

                case R.id.button2:
                    String firstText = editText1.getText().toString();
                    String secondText = editText2.getText().toString();
                    String toPrint = "";
                    if (checkBox1.isChecked() && editText1.getText() == null) {
                        Toast.makeText(PracticalTest01Var03MainActivity.this, "complete first text", Toast.LENGTH_LONG).show();
                    }
                    if (checkBox2.isChecked() && secondText == "") {
                        Toast.makeText(getApplicationContext(), "complete second text", Toast.LENGTH_LONG).show();
                    }
                    if (checkBox1.isChecked() && firstText != null) {
                        toPrint += firstText;
                    }
                    if (checkBox2.isChecked() && secondText != null) {
                        toPrint += secondText;
                    }
                    textView.setText(toPrint);

                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        nextActivity = (Button) findViewById(R.id.button);
        displayInfo = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);

        displayInfo.setOnClickListener(buttonClickListener);
        nextActivity.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstText", editText1.getText().toString());
        savedInstanceState.putString("secondText", editText2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("firstText")) {
            editText1.setText(savedInstanceState.getString("firstText"));
        } else {
            editText1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("secondText")) {
            editText2.setText(savedInstanceState.getString("secondText"));
        } else {
            editText2.setText(String.valueOf(0));
        }
    }
}
