package com.example.mvvm_pattern.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_pattern.model.Americano;
import com.example.mvvm_pattern.model.Beverage;
import com.example.mvvm_pattern.model.CafeLatte;
import com.example.mvvm_pattern.model.TotalPrice;

//ViewModel 동작기능
//1. 메뉴(아메리카노) 수량 증감 요청(to View)
//2. UI에 DataBinding 할 LiveData 값에 수량 정보 할당(to View)
//3. 수량 증감에 따른 합계 가격 증감 요청(to Model)
//4. UI에 DataBinding 할 LiveData 값에 합계 가격 정보 할당(for View)
public class MainViewModel extends ViewModel {      //JetPack 라이브러리인 ViewModel을 상속받는다.

    //activity_main.xml 에서 DataBinding 라이브러리를 사용하여 실현될 수 있도록 ViewModel의 LiveData를 바인딩한다
    public MutableLiveData<String> americanoQty = new MutableLiveData<>("0");   //수량 정보를 담을 LiveData 선언
    public MutableLiveData<String> latteQty = new MutableLiveData<>("0");


    //activity_main.xml 에서 DataBinding 라이브러리를 사용하여 실현될 수 있도록 ViewModel의 LiveData를 바인딩한다
    public MutableLiveData<String> totalPrice = new MutableLiveData<>("0"); //합계 가격 정보를 담을 LiveData 선언

    Beverage americanoModel = new Americano();
    Beverage latteModel = new CafeLatte();
    TotalPrice totalModel = new TotalPrice();

    public void upAmericano(){      //layout 에서 수량 증가 버튼에 대한 입력 이벤트를 처리할 함수 설정 -> activity_main.xml 에서 곧바로 ViewModel 로 입력 이벤트 전달
        //수량 정보를 증가 시킨 후 증가된 값을 LiveData 에 할당 하고 합계 가격 정보 증가를 위한 함수 호출
        americanoModel.up();
        americanoQty.setValue(String.valueOf(americanoModel.getQuantity()));
//        updateTotalPriceAdd(americanoModel.getPrice());
        updateTotalPrice();
    }



    public void downAmericano(){    //layout 에서 수량 감소 버튼에 대한 입력 이벤트를 처리할 함수 설정 -> activity_main.xml 에서 곧바로 ViewModel 로 입력 이벤트 전달
        //수량 정보를 감소 시킨 후 감소된 값을 LiveData 에 할당 하고 합계 가격 정보 감소를 위한 함수 호출
        americanoModel.down();
        americanoQty.setValue(String.valueOf(americanoModel.getQuantity()));
//        updateTotalPriceSub(americanoModel.getPrice());
        updateTotalPrice();
    }

    public void upLatte(){
        latteModel.up();
        latteQty.setValue(String.valueOf(latteModel.getQuantity()));
        updateTotalPrice();
    }
    public void downLatte(){
        latteModel.down();
        latteQty.setValue(String.valueOf(latteModel.getQuantity()));
        updateTotalPrice();
    }


    private void updateTotalPrice() {
        int americanoTotalPrice = americanoModel.calculateTotalPrice();
        int latteTotalPrice = latteModel.calculateTotalPrice();
        int total_result = americanoTotalPrice + latteTotalPrice;
        totalModel.setTotalPrice(total_result);
        totalPrice.setValue(String.valueOf(totalModel.getTotalPrice()));

    }

//    private void updateTotalPriceAdd(int price) {
//        totalModel.Americano_increaseTotalPrice(price);
//        totalPrice.setValue(String.valueOf(totalModel.getTotalPrice()));
//    }
//
//    private void updateTotalPriceSub(int price) {
//        totalModel.Americano_decreaseTotalPrice(price);
//        totalPrice.setValue(String.valueOf(totalModel.getTotalPrice()));
//    }






}
