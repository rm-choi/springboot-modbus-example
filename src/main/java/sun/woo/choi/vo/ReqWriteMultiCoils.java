package sun.woo.choi.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqWriteMultiCoils {

    private String comport;
    private int startAddress;
    private boolean[] values;
}
