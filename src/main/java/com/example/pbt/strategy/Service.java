package com.example.pbt.strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    public enum AvailableComm {OUT,ERR};

    private ErrComunicateStrategy errComunicateStrategy;
    private OutComunicateStrategy outComunicateStrategy;

    private BusinessLogic bl;

    public String execute(AvailableComm comm) {
        ComunicateStrategy comStrat = null;

        switch(comm) {
            case OUT: comStrat = outComunicateStrategy; break;
            case ERR: comStrat = errComunicateStrategy; break;
        }

        bl.setComunicate(comStrat);
        return bl.run();
    }
}

