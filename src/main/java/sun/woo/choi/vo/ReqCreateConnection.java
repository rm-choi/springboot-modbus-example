package sun.woo.choi.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqCreateConnection {

    private String comport;
    private int baudRate;
    private int parity;
    private int dataBits;
    private int stopBits;

}
