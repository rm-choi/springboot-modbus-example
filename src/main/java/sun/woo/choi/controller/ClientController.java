package sun.woo.choi.controller;


import sun.woo.choi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sun.woo.choi.vo.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/con")
    public boolean createConnection(@RequestBody ReqCreateConnection reqCreateConnection) throws Exception {
       return clientService.createConnection(reqCreateConnection);
    }

    @DeleteMapping("/con")
    public boolean removeConnection(@RequestParam("comPort") String comPort) throws Exception {
       return clientService.removeConnection(comPort);
    }

    @GetMapping("/data/registers/holding")
    public int[] readHoldingRegisters(@RequestParam("comPort") String comPort,
                                      @RequestParam("offset") int offset,
                                      @RequestParam("quantity") int quantity) throws Exception {
       return clientService.readHoldingRegisters(comPort, offset, quantity);
    }

    @GetMapping("/data/registers/input")
    public int[] readInputRegisters(@RequestParam("comPort") String comPort,
                                    @RequestParam("offset") int offset,
                                    @RequestParam("quantity") int quantity) throws Exception {
       return clientService.readInputRegisters(comPort, offset, quantity);
    }


    @GetMapping("/data/coil")
    public boolean[] readCoils(@RequestParam("comPort") String comPort,
                              @RequestParam("offset") int offset,
                              @RequestParam("quantity") int quantity) throws Exception {
       return clientService.readCoils(comPort, offset, quantity);
    }

    @GetMapping("/data/di")
    public boolean[] readDiscreteInputs(@RequestParam("comPort") String comPort,
                                        @RequestParam("offset") int offset,
                                        @RequestParam("quantity") int quantity) throws Exception {
       return clientService.readDiscreteInputs(comPort, offset, quantity);
    }

    @PutMapping("/data/coil")
    public boolean writeSingleCoil(@RequestBody ReqWriteSingleCoil reqWriteSingleCoil) throws Exception {
       return clientService.writeSingleCoil(reqWriteSingleCoil);
    }

    @PutMapping("/data/coils")
    public boolean writeMultipleCoils(@RequestBody ReqWriteMultiCoils reqWriteMultiCoils) throws Exception {
       return clientService.writeMultipleCoils(reqWriteMultiCoils);
    }

    @PutMapping("/data/register")
    public boolean writeSingleRegister(@RequestBody ReqWriteSingleRegister reqWriteSingleRegister) throws Exception {
       return clientService.writeSingleRegister(reqWriteSingleRegister);
    }

    @PutMapping("/data/registers")
    public boolean writeMultipleRegisters(@RequestBody ReqWriteMultiRegisters reqWriteMultiRegisters) throws Exception {
       return clientService.writeMultipleRegisters(reqWriteMultiRegisters);
    }






}
