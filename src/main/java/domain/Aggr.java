package domain;

import domain.service.Calculator;

/**
 * 聚合
 */
public class Aggr {
    /**
     * 获取聚合根
     * @return
     */
    public static AggrRoot getRoot(){
        return new Calculator();
    }
}
