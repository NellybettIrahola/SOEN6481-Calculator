package com.example.champernownecalculator.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import android.view.View.OnClickListener;
import com.example.champernownecalculator.R;
import com.example.champernownecalculator.auxiliar.LayoutListener;
import com.example.champernownecalculator.auxiliar.PageViewModel;
import com.example.champernownecalculator.model.Champernowne;

/**
 * A placeholder fragment containing a simple view.
 */
public class FirstFragment extends Fragment implements OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    Button calculateNumber;
    Button findButton;
    View root;

    public static FirstFragment newInstance(int index) {
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.first_fragment, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        textView.setText("Base");

        calculateNumber=(Button)root.findViewById(R.id.calculate_button);
        calculateNumber.setOnClickListener(this);

        LinearLayout layout=root.findViewById(R.id.fragment_one);
        layout.setOnTouchListener(new LayoutListener(getActivity()));

        findButton=(Button)root.findViewById(R.id.find_button);
        findButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        EditText decimals=root.findViewById(R.id.decimals_text);
        Spinner base= root.findViewById(R.id.base_spinner);
        EditText pattern=root.findViewById(R.id.pattern_text);
        EditText result=root.findViewById(R.id.calculate_text);
        EditText position=root.findViewById(R.id.position_text);
        Champernowne number=new Champernowne();

        position.setText("");


        if(view.getId()==R.id.calculate_button) {
            pattern.setText("");
            if (decimals.getText().toString().matches("\\d+")) {
                if (Integer.valueOf(decimals.getText().toString()) < 901)
                    result.setText(number.calculateAlternative(Integer.valueOf(decimals.getText().toString()), Integer.valueOf(base.getSelectedItem().toString())));
                else
                    decimals.setError("The maximum number of decimals is 900");
            } else {
                decimals.setError("Only integer numbers.");
            }
        }
        if(view.getId()==R.id.find_button) {
            if(!result.getText().toString().equals("") && !pattern.getText().toString().equals("")){
                String positionResult=String.valueOf(number.getPatternPosition(pattern.getText().toString(),result.getText().toString())+1);
                if(positionResult.equals(0)){
                    position.setText("Pattern not found");
                }else{
                    position.setText(positionResult);
                }

            }else{
                pattern.setError("Calculate the number first and remember to insert a pattern.");
            }
        }
    }
}