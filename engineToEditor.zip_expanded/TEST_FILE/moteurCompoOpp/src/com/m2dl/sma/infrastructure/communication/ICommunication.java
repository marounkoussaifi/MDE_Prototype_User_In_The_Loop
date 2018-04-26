package com.m2dl.sma.infrastructure.communication;

import java.util.Optional;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface ICommunication {

    void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire,
           IMessageAgent IMessageAgent); // pourquoi on passe de l'expediteur alors qu'il est ds le msg
   
    void diffuserMessage(ReferenceAgent expediteur, IMessageAgent IMessageAgent);// pourquoi on passe de l'expediteur alors qu'il est ds le msg
    Optional<IMessageAgent> recevoirMessage(ReferenceAgent destinataire);
}
