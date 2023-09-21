package com.example.mvvm_pattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvm_pattern.R;
import com.example.mvvm_pattern.databinding.ActivityMainBinding;
import com.example.mvvm_pattern.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);    //DataBinding 에서 LiveData 의 변화를 감지 하기 위해서 사용할 LifecycleOwner 를 설정 해야 한다.(여기서는 Activity 로 지정)
        binding.setCounter(viewModel);  //바인딩된 변수에 viewModel 을 할당한다.

    }
}