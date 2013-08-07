package com.ndroidstudios.android.formulawizard;

import com.ndroidstudios.android.helper.Formulas;
import com.ndroidstudios.android.helper.FontHelper;
import com.ndroidstudios.android.helper.UIHelper;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exponent2positiveActivity extends Activity {
	
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
        setContentView(R.layout.exponent_2_positive);
                
        mVariableA = (EditText)findViewById(R.id.variable_a);
        mVariableB = (EditText)findViewById(R.id.variable_b);
        mCalculateButton = (Button)findViewById(R.id.calculate_button);
        mInfoText = (TextView)findViewById(R.id.display_x1);
        
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
    	if (uiHelper.editTextIsEmpty(mVariableA, mVariableB)) {
			uiHelper.setErrorText(mInfoText);
		} else {
			double a = Double.parseDouble(mVariableA.getText().toString());
			double b = Double.parseDouble(mVariableB.getText().toString());
			result = calculator.exponent2Positive(a, b);
			String resultFormated = calculator.formatResult(result);
			mInfoText.setText(Html.fromHtml(String.format("(%s + %s)<sup><small>2</small></sup> = %s",
	                a, b, resultFormated)));				  
		}
    }
}


