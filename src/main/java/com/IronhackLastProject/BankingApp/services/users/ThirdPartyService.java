package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.repositories.users.ThirdPartyRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.ThirdPartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ThirdPartyService  {



/*
    public ThirdParty createThirdParty(ThirdParty thirdParty) {

        if (thirdPartyRepository.findByAccount(
                thirdParty.getHashKey(),thirdParty.getName().isPresent())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        return thirdPartyRepository.save(thirdParty);
    }
*/

}
