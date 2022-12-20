package com.example.fragmenttask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentTaskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText taskText;
    Button writeButton;
    TextView taskListText;
    ArrayList<String> tasks;

    public CurrentTaskFragment(ArrayList<String> tasks) {
        // Required empty public constructor
        this.tasks = tasks;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentTaskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentTaskFragment newInstance(String param1, String param2) {
        CurrentTaskFragment fragment = new CurrentTaskFragment(new ArrayList<>());
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_current_task, container, false);
        taskText = v.findViewById(R.id.current_task);
        writeButton = v.findViewById(R.id.write_task_btn);
        taskListText = v.findViewById(R.id.current_task_list);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasks.add(taskText.getText().toString());
                taskListText.append(taskText.getText());
            }
        });
        return v;
    }
}