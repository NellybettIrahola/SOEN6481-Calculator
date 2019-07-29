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
public class ThirdFragment extends Fragment implements OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    Button decrypt;
    View root;

    public static ThirdFragment newInstance(int index) {
        ThirdFragment fragment = new ThirdFragment();
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
        this.root = inflater.inflate(R.layout.third_fragment, container, false);
        final TextView textView = root.findViewById(R.id.section_label_third);
        textView.setText("Method");

        decrypt=(Button)root.findViewById(R.id.decrypt_button);
        decrypt.setOnClickListener(this);


        LinearLayout layout=root.findViewById(R.id.fragment_three);
        layout.setOnTouchListener(new LayoutListener(getActivity()));
        return root;
    }

    @Override
    public void onClick(View view) {
        EditText decryptMessage= root.findViewById(R.id.decrypt_text);
        EditText decryptedMessage= root.findViewById(R.id.result_decrypt_text);
        EditText key=root.findViewById(R.id.key_text);

        decryptedMessage.setText("");

        if(!(decryptMessage.getText().toString().equals("") || key.getText().toString().equals("") || !(key.getText().toString().matches("\\d+")))){
            Spinner encryptType= root.findViewById(R.id.decrypt_spinner);
            Champernowne number=new Champernowne();
            if("Substitution".equals(encryptType.getSelectedItem().toString())){
                decryptedMessage.setText(number.decryptSubstitution(decryptMessage.getText().toString(),Integer.valueOf(key.getText().toString())));
            }
            if("One-time Pad".equals(encryptType.getSelectedItem().toString())){
                decryptedMessage.setText(number.decryptOneTimePad(decryptMessage.getText().toString(),Integer.valueOf(key.getText().toString())));
            }
        }else{
            decryptMessage.setError("Missing parameter.");
            key.setError("Missing parameter.");
        }

    }
}