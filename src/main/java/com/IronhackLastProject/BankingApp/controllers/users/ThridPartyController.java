package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.controllers.users.interfaces.ThirdPartyControllerInterface;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.services.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ThridPartyController {
    @Autowired
    ThirdPartyService ThirdPartyService;

   /*@PostMapping("/createThirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty) {

        return ThirdPartyService.createThirdParty(thirdParty);

    }*/

}

/*
*
* There must be a way for third-party users to receive and send money to other accounts.
Third-party users must be added to the database by an admin.
In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request.
*  They also must provide the amount, the Account id and the account secret key.

* */
