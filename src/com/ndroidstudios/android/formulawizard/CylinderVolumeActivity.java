package com.ndroidstudios.android.formulawizard;

import com.ndroidstudios.android.helper.Formulas;
import com.ndroidstudios.android.helper.FontHelper;
import com.ndroidstudios.android.helper.UIHelper;
import com.ndroidstudios.android.helper.Formulas.InvalidInputException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CylinderVolumeActivity extends Activity {
	
	// Private instance variables
	private EditText mVariableA;
	private EditText mVariableB;
	private Button mCalculateButton;
	private TextView mInfoText;
	private double result;
	
	// Helper instance variables
	private UIHelper uiHelper = new UIHelper();
	private Formulas calculator = new Formulas();
	
	/** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cylinder_volume);
   
        mVariableA = (EditText)findViewById(R.id.variable_radius);
        mVariableB = (EditText)findViewById(R.id.variable_height);
        mCalculateButton = (Button)findViewById(R.id.calculate_button);
        mInfoText = (TextView)findViewById(R.id.display_result);
        
        registerButtonListener();
        uiHelper.setDefaultText(mInfoText);
        FontHelper.overrideFonts(this, findViewById(android.R.id.content));
    }

    @Override
    protected void onPause() {
    	super.onPause();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    }
    
    private void registerButtonListener() {
    	mCalculateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handleInput();
			}
		});
    }
    
    private void handleInput() {
    	try {
    		if (uiHelper.editTextIsEmpty(mVariableA, mVariableB)) {
				uiHelper.setErrorText(mInfoText);
			} else {
				double radius = Double.parseDouble(mVariableA.getText().toString());
				double height = Double.parseDouble(mVariableB.getText().toString());
				result = calculator.cylinderVolume(radius, height);
				mInfoText.setText("Volume = " + result);				  
			}
    	} catch (InvalidInputException e) {
    		mInfoText.setText("The radius / height can't be negative! Enter a positive value!");
    	}
    }
}



