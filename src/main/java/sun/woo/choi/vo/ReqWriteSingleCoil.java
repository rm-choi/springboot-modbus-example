package sun.woo.choi.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqWriteSingleCoil {

    private String comport;
    private int startAddress;
    private boolean value;
}
