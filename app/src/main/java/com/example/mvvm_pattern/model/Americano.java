package com.example.mvvm_pattern.model;

public class Americano extends Beverage{
    public static final int PRICE = 1500;
    public Americano() {   //Americano 생성자
        super(PRICE);    //자신이 상속받은 부모의 생성자 호출 -> Beverage
    }

}