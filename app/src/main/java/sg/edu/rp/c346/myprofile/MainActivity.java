package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;

    //This is a line for GitHub updating123123

    @Override
    protected void onPause() {
        super.onPause();

        //Step1a: Retrieve data input of the user
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        boolean boolLike = ckbLike.isChecked();
        int intGender = rgGender.getCheckedRadioButtonId();

        //Step1b: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step1c: Obtain an instance of the Shared Preference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step1d: Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putBoolean("like", boolLike);
        prefEdit.putInt("gender", intGender);


        //Step1e: Call commit() method to save the changes into the Shared Preference
        prefEdit.commit();
}

    @Override
    protected void onResume() {
        super.onResume();


        //Step2a: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step2b: Retrieve the saved data with the key, name from the SharedPreferences object.
        String strName = prefs.getString("name","John");
        float gpa = prefs.getFloat("gpa", 0);
        boolean boolLike = prefs.getBoolean("like", false);
        int intGender = prefs.getInt("gender", R.id.radioButtonGenderMale);


        //step2c: Update the UI element with the value.
        etName.setText(strName);
        etGPA.setText(gpa+"");
        ckbLike.setChecked(boolLike);
        rgGender.check(intGender);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.editTextName);
        etGPA = (EditText)findViewById(R.id.editTextGPA);
        rgGender = (RadioGroup)findViewById(R.id.RadioGroupGender);
        ckbLike = (CheckBox)findViewById(R.id.checkBoxLikeProgramming);
    }
}
