package application.service;

import domain.Aggr;
import domain.AggrRoot;
import domain.service.Calculator;
import domain.dto.CurOperator;

/**
 * 程序入口，无状态类
 */
public class CalculatorApp {

    Calculator calculator;
    public CalculatorApp(){
        AggrRoot root = Aggr.getRoot();
        calculator = (Calculator)root;
    }

    public void add(int num){
        calculator.calc(CurOperator.ADD, num);
    }
    public void sub(int num){
        calculator.calc(CurOperator.SUB, num);
    }
    public void multi(int num){
        calculator.calc(CurOperator.MUIL, num);
    }
    public void divi(int num){
        calculator.calc(CurOperator.DIVI, num);
    }
    public void undo(int num){
        calculator.undo(num);
    }
    public void redo(int num){
        calculator.redo(num);
    }
    public int print(){
        return calculator.getRes();
    }
}
