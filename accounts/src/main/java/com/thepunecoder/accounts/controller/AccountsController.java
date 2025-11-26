package com.thepunecoder.accounts.controller;

import com.thepunecoder.accounts.constants.AccountsConstants;
import com.thepunecoder.accounts.dto.CustomerDto;
import com.thepunecoder.accounts.dto.ResponseDto;
import com.thepunecoder.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    //write code for send hello endpoint which returns "Hello from Accounts Service"
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello from Accounts Service");
    }

    @GetMapping("/fetchAccountDetails")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

}
