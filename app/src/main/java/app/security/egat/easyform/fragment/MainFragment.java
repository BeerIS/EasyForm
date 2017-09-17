package app.security.egat.easyform.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import app.security.egat.easyform.R;
import app.security.egat.easyform.utility.MyAlertDialog;

/**
 * Created by Phakpoom.I on 17/9/2560.
 */

public class MainFragment extends Fragment{
    //Explicit
    private String nameString, genderString, provinceString;
    private boolean genderABoolean = true;
    private int indexAnInt = 0;
    private String[] provinceStrings=new String[]{
            "--Select Province--",
            "Bangkok",
            "Nonthaburi",
            "Pathum Thani",
            "Samut Prakarn"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //AddData Controller
        addDataController();

        //Radio Controller
        radioController();

        //Spinner Controller
        spinnerController();

    }

    private void spinnerController() {
        Spinner spnProvince = (Spinner) getView().findViewById(R.id.spnProvince);
        //สร้าง Adapter เป็น Array สำหรับเอาไว้ Bind Spinner
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                provinceStrings
        );
        spnProvince.setAdapter(stringArrayAdapter);
        spnProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indexAnInt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                indexAnInt = 0;
            }
        });
    }

    private void radioController() {
        RadioGroup rdgGender = (RadioGroup)getView().findViewById(R.id.rdgGender);
        rdgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                genderABoolean = false;
                switch (checkedId) {
                    case R.id.rdoMale:
                        genderString = "Male";
                        break;
                    case R.id.rdoFemale:
                        genderString = "Female";
                        break;
                    default:
                }
            }
        });
    }

    private void addDataController() {
        Button button = (Button)getView().findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get value from edittext
                EditText edtName  = (EditText)getView().findViewById(R.id.edtName);
                nameString = edtName.getText().toString().trim();
                //Check Space
                if (nameString.equals("")) {
                    //have space
                    MyAlertDialog alertDialog = new MyAlertDialog(getActivity());
                    alertDialog.myDialog("Name Required", "Please fill your name.");
                }
                else if (genderABoolean) {
                    //Gender is not selected
                    MyAlertDialog alertDialog = new MyAlertDialog(getActivity());
                    alertDialog.myDialog("Gender Required","Please select a gender, male or female");
                }
                else if (indexAnInt==0) {
                    //Province is not selected
                    MyAlertDialog alertDialog = new MyAlertDialog(getActivity());
                    alertDialog.myDialog(getResources().getString(R.string.titleProvince),
                            getResources().getString(R.string.strProvince));
                }
            }
        });
    }
}
