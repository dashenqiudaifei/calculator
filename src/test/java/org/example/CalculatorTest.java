package org.example;

import application.service.CalculatorApp;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    public static CalculatorApp calculatorApp;

    @Before
    public void init(){
        calculatorApp = new CalculatorApp();
    }

    @Test
    public void addTest(){
        calculatorApp.add(100);//加法
        assert 100 == calculatorApp.print();
    }

    @Test
    public void subTest(){
        calculatorApp.sub(100);//减法
        assert -100 == calculatorApp.print();
    }

    @Test
    public void multiTest(){
        calculatorApp.add(100);//加法
        calculatorApp.multi(2);
        assert 200 == calculatorApp.print();
    }

    @Test
    public void diviTest(){
        calculatorApp.add(100);//加法
        calculatorApp.divi(2);
        assert 50 == calculatorApp.print();
    }

    @Test
    public void mixTest(){
        calculatorApp.add(100);//加法
        calculatorApp.sub(50);//减法
        calculatorApp.multi(10);//乘法
        calculatorApp.divi(2);//除法
        calculatorApp.undo(4);//撤销前四个步骤
        calculatorApp.redo(3);//再次执行三个步骤
        //再次执行
        calculatorApp.add(2);//加法
        assert 502 == calculatorApp.print();
    }

}
