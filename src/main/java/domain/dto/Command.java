package domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 每次操作的value object
 */
@Data
@AllArgsConstructor
public class Command {
    CurOperator curOperator;
    int num;
}