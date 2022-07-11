package com.example.jingyidemo.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jingyidemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_NAME = "name";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String name;

    private TextView contentTv;

    public MyFirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyFirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFirstFragment newInstance(String param1, String param2) {
        MyFirstFragment fragment = new MyFirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //只传递一个参数
    public static MyFirstFragment newInstance(String name) {
        MyFirstFragment fragment = new MyFirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * 用于实例化-先
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从外部传送的数据
        //打开Fragment前往里面塞数据Bundle类型
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
            name = getArguments().getString(ARG_NAME);
        }
    }

    /**
     * 用于创建控件树的-后
     * ViewGroup container 是Fragment嵌套进Activity的容器
     *
     * @param savedInstanceState
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //LayoutInflater用于把xml转化成控件树的
        View root = inflater.inflate(R.layout.fragment_my_first, container, false);
        contentTv = root.findViewById(R.id.frag_my_first_content_tv);
        contentTv.setText(name);
        return root;
    }
}