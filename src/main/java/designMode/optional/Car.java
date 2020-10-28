package designMode.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhongying
 * @description
 * @date 2020/8/4
 */
@Data
@AllArgsConstructor
public class Car {
    private String name;
    private Insurance insurance;
}
