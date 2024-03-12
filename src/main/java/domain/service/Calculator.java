package domain.service;

import domain.AggrRoot;
import domain.dto.Command;
import domain.dto.CurOperator;
import lombok.Getter;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Calculator 聚合根
 */
public class Calculator extends AggrRoot {
    private final static Logger LOG = Logger.getLogger(Calculator.class);
    private List<Command> commands = new LinkedList<>();
    private int currentIndex = 0;

    @Getter
    private int res;

    //计算
    public void calc(CurOperator curOperator, int num) {
        Command command = new Command(curOperator, num);
        commands.add(command);
        this.res = Oper.calc(command.getCurOperator(), command.getNum(), res);
        currentIndex++;
    }
    //重做
    public void redo(int levels) {
        LOG.debug(String.format("redo lv=%d", (levels)));
        for (int i = 0; i < levels; i++)
            if (currentIndex < commands.size() - 1) {
                Command command = commands.get(currentIndex++);
                this.res = Oper.calc(command.getCurOperator(), command.getNum(), res);
            }else {
                LOG.warn("no redo data");
            }
    }

    //撤销
    public void undo(int levels) {
        LOG.debug(String.format("String lv=%d", (levels)));
        for (int i = 0; i < levels; i++)
            if (currentIndex > 0) {
                int index = --currentIndex;
                Command command = commands.get(index);
                this.res = Oper.calc(Oper.undo(command.getCurOperator()), command.getNum(), res);
            }else {
                LOG.warn("no undo data");
            }
    }

}
