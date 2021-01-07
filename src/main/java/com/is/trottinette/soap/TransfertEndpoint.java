package com.is.trottinette.soap;

import fr.univ_lyon1.tiw1_is.banque.service.ObjectFactory;
import fr.univ_lyon1.tiw1_is.banque.service.TransfertRequest;
import fr.univ_lyon1.tiw1_is.banque.service.TransfertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.is.trottinette.service.ActivationService;

@Endpoint
public class TransfertEndpoint {
    public final static String NAMESPACE_URI = "http:/univ-lyon1.fr/tiw1-is/emprunt/service";

    private final static ObjectFactory banqueObjectFactory = new ObjectFactory();

    @Autowired
    private ActivationService activationService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "transfertRequest")
    @ResponsePayload
    public TransfertResponse transfert(@RequestPayload TransfertRequest transfert) {
        boolean ok = activationService.activateEmprunt(transfert.getNumActivation());
        TransfertResponse response = banqueObjectFactory.createTransfertResponse();
        response.setActivationOk(ok);
        return response;
    }

}
