package domain.service;


import domain.dto.CurOperator;
import org.apache.log4j.Logger;

/**
 * 运算逻辑，无状态
 */
public class Oper {
    private static final Logger LOG = Logger.getLogger(Oper.class);
    private Oper(){
    }

    public static int calc(CurOperator curOperator, int num, int before) {
        int total = before;
        switch (curOperator) {
            case ADD:
                total += num;
                break;
            case SUB:
                total -= num;
                break;
            case MUIL:
                total *= num;
                break;
            case DIVI:
                total /= num;
                break;
        }
        LOG.debug(System.out.format("%d %s %d = %d", before, curOperator, num, total));
        return total;
    }

    public static CurOperator undo(CurOperator op) {
        CurOperator undo = null;
        switch (op) {
            case ADD:
                undo = CurOperator.SUB;
                break;
            case SUB:
                undo = CurOperator.ADD;
                break;
            case MUIL:
                undo = CurOperator.DIVI;
                break;
            case DIVI:
                undo = CurOperator.MUIL;
                break;
        }
        return undo;
    }

}
