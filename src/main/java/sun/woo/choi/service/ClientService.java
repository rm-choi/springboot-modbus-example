package sun.woo.choi.service;


import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.serial.SerialParameters;
import com.intelligt.modbus.jlibmodbus.serial.SerialPort;
import sun.woo.choi.data.DataInfo;
import sun.woo.choi.exception.SimpleException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.woo.choi.vo.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {


    public boolean createConnection(ReqCreateConnection reqCreateConnection) throws Exception {
    	SerialParameters sp = new SerialParameters();
        sp.setDevice(reqCreateConnection.getComport());
        sp.setBaudRate(SerialPort.BaudRate.getBaudRate(reqCreateConnection.getBaudRate()));
        sp.setDataBits(reqCreateConnection.getDataBits());
        sp.setParity(SerialPort.Parity.getParity(reqCreateConnection.getParity()));
        sp.setStopBits(reqCreateConnection.getStopBits());
        try {
            ModbusMaster m = ModbusMasterFactory.createModbusMasterRTU(sp);
            m.connect();
            DataInfo.clientConMap.put(reqCreateConnection.getComport(), m);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
        return true;
    }


    public boolean removeConnection(String comPort) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(comPort);
            m.disconnect();
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
        return true;
    }

    public int[] readHoldingRegisters(String comPort, int offset, int quantity) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(comPort);
            return m.readHoldingRegisters(1, offset, quantity);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }

    public int[] readInputRegisters(String comPort, int offset, int quantity) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(comPort);
            return m.readInputRegisters(1, offset, quantity);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }


    public boolean[] readCoils(String comPort, int offset, int quantity) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(comPort);
            return m.readCoils(1, offset, quantity);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }

    public boolean[] readDiscreteInputs(String comPort, int offset, int quantity) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(comPort);
            return m.readDiscreteInputs(1, offset, quantity);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }


    public boolean writeSingleCoil(ReqWriteSingleCoil reqWriteSingleCoil) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(reqWriteSingleCoil.getComport());
            m.writeSingleCoil(1, reqWriteSingleCoil.getStartAddress(), reqWriteSingleCoil.isValue());
            return true;
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }

    public boolean writeMultipleCoils(ReqWriteMultiCoils reqWriteMultiCoils) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(reqWriteMultiCoils.getComport());
            m.writeMultipleCoils(1, reqWriteMultiCoils.getStartAddress(), reqWriteMultiCoils.getValues());
            return true;
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }

    public boolean writeSingleRegister(ReqWriteSingleRegister reqWriteSingleRegister) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(reqWriteSingleRegister.getComport());
            m.writeSingleRegister(1, reqWriteSingleRegister.getStartAddress(), reqWriteSingleRegister.getValue());
            return true;
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }

    public boolean writeMultipleRegisters(ReqWriteMultiRegisters reqWriteMultiRegisters) throws Exception {
        try {
            ModbusMaster m = DataInfo.clientConMap.get(reqWriteMultiRegisters.getComport());
            m.writeMultipleRegisters(1, reqWriteMultiRegisters.getStartAddress(), reqWriteMultiRegisters.getValues());
            return true;
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
    }








}
