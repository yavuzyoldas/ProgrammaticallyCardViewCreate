package com.yoldasoftware.dynamicedittexttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.os.Bundle;

import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {




    RelativeLayout relativeLayout2;
    LinearLayout linearLayout;

    ScrollView scrollView;
    Button btnCreateCardView;
    Button btnComplete;

    int hint = 0;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout2 = findViewById(R.id.relativeLayout2);

        linearLayout = findViewById(R.id.linearLayout);



        scrollView = findViewById(R.id.scrollView);

        btnComplete = findViewById(R.id.btnComplete);



        btnCreateCardView = findViewById(R.id.btnCreateCardView);

        btnCreateCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createCardView();
            }
        });

    }

    protected void createCardView() {

        final  EditText editTxt = new EditText(this);
        int maxLength = 50;
        hint++;
        id ++;
        editTxt.setHint("Product Name "+ hint);
        editTxt.setInputType(InputType.TYPE_CLASS_TEXT);
        editTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        editTxt.setId(id);
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        editTxt.setFilters(fArray);

        EditText editTxt1 = new EditText(this);

        editTxt1.setHint("Product Type "+hint);
        editTxt1.setInputType(InputType.TYPE_CLASS_TEXT);
        editTxt1.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        InputFilter[] fArray1 = new InputFilter[1];
        fArray1[0] = new InputFilter.LengthFilter(maxLength);
        editTxt1.setFilters(fArray1);

        id++;
        editTxt1.setId(id);

        CardView cardView = new CardView(this);

        CardView.LayoutParams cardViewParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT,CardView.LayoutParams.WRAP_CONTENT);

        cardViewParams.setMargins(10,10,10,10);

        cardView.setLayoutParams(cardViewParams);

        LinearLayout linearLayout1 = new LinearLayout(this);

        linearLayout1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(10,10,10,10);

        linearLayout1.setLayoutParams(layoutParams);

        cardView.addView(linearLayout1);

        linearLayout1.addView(editTxt);

        linearLayout1.addView(editTxt1);

        RelativeLayout.LayoutParams s1 = new RelativeLayout.LayoutParams (RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        s1.addRule(RelativeLayout.ABOVE,hint);

        linearLayout.addView(cardView);

        RelativeLayout.LayoutParams s = new RelativeLayout.LayoutParams (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        s.addRule(RelativeLayout.BELOW,R.id.relativeLayout2);//LinearLayout un içinde sol tarafından

        s.addRule(RelativeLayout.CENTER_IN_PARENT);

        btnCreateCardView.setLayoutParams(s);

        scrollView.post(new Runnable() {
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_DOWN);
                editTxt.requestFocus();
            }
        });

    }

}
