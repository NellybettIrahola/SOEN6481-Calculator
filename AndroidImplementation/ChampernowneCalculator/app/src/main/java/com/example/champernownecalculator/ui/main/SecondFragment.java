package com.example.champernownecalculator.ui.main;

import android.content.Intent;
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
import android.view.View.OnClickListener;
import androidx.lifecycle.ViewModelProviders;

import com.example.champernownecalculator.R;
import com.example.champernownecalculator.auxiliar.LayoutListener;
import com.example.champernownecalculator.auxiliar.PageViewModel;
import com.example.champernownecalculator.model.Champernowne;

/**
 * A placeholder fragment containing a simple view.
 */
public class SecondFragment extends Fragment implements OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    Button encrypt;
    Button share;
    View root;

    public static SecondFragment newInstance(int index) {
        SecondFragment fragment = new SecondFragment();
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
        root = inflater.inflate(R.layout.second_fragment, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        textView.setText("Encryption Type");

        encrypt=(Button)root.findViewById(R.id.encrypt_button);
        encrypt.setOnClickListener(this);
        share=(Button)root.findViewById(R.id.share_button);
        share.setOnClickListener(this);

        LinearLayout layout=root.findViewById(R.id.fragment_two);
        layout.setOnTouchListener(new LayoutListener(getActivity()));
        return root;
    }

    @Override
    public void onClick(View view) {
        EditText encryptMessage= root.findViewById(R.id.encryption_text);
        EditText encryptedMessage= root.findViewById(R.id.result_encryption_text);


        if (view.getId()==R.id.encrypt_button){
            if(!encryptMessage.getText().toString().equals("")){
                Spinner encryptType= root.findViewById(R.id.encryption_spinner);
                Champernowne number=new Champernowne();
                if("Substitution".equals(encryptType.getSelectedItem().toString())){
                    encryptedMessage.setText(number.encryptSubtitution(encryptMessage.getText().toString()));
                }
                if("OneTimePad".equals(encryptType.getSelectedItem().toString())){
                    encryptedMessage.setText(number.encryptOneTimePad(encryptMessage.getText().toString()));
                }
            }else{
                encryptMessage.setError("Introduce a message");
            }

        }
        if (view.getId()==R.id.share_button){
            if(!encryptedMessage.getText().toString().equals("")) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, encryptedMessage.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }else{
                encryptedMessage.setError("No message available");
            }

        }
    }
}