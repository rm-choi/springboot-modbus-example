package sun.woo.choi.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqWriteMultiRegisters {

    private String comport;
    private int startAddress;
    private int[] values;
}
