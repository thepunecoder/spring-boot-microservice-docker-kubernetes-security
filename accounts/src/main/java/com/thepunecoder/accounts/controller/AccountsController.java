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

/**
 * AccountsController is a REST controller that handles HTTP requests related to customer accounts.
 * It provides endpoints for creating, fetching, updating, and deleting customer account details.
**/

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

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam String mobileNumber) {
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}

/* What is rest controller in spring boot write in short ?
A REST controller in Spring Boot is a specialized type of controller that handles HTTP requests and responses in a RESTful web service.
It is annotated with @RestController, which combines @Controller and @ResponseBody, allowing the controller to return data directly as JSON or XML instead of rendering a view.
REST controllers are used to create APIs that enable communication between clients and servers using standard HTTP methods like GET, POST, PUT, and DELETE.

What is the use of ResponseEntity in spring boot?
ResponseEntity is a class in Spring Boot that represents the entire HTTP response, including the status code, headers, and body.
It is used to provide more control over the HTTP response returned from a RESTful web service.
By using ResponseEntity, developers can customize the response status, add headers, and include a response body, making it easier to handle different scenarios such as success, errors, and redirects in a more flexible manner.

What is the use of @RequestBody in spring boot?
@RequestBody is an annotation in Spring Boot that is used to bind the HTTP request body to a method parameter in a controller.
It allows developers to automatically deserialize the incoming JSON or XML data from the request body into a Java object.
This is particularly useful for handling POST and PUT requests where the client sends data to the server, enabling easy access and manipulation of the data within the controller method.

What is the use of @RequestParam in spring boot and difference between @PathVariable?
@RequestParam is an annotation in Spring Boot used to extract query parameters from the URL of an HTTP request and bind them to method parameters in a controller.
It is typically used for optional parameters or when the parameter names in the URL do not match the method parameter names.
On the other hand, @PathVariable is used to extract values from the URI path itself, binding them to method parameters.
It is commonly used for mandatory parameters that are part of the URL structure, such as resource identifiers.

Difference between @RestController and @Controller in spring boot?
@RestController is a specialized version of @Controller in Spring Boot that is used to create RESTful web services.
It combines the functionality of @Controller and @ResponseBody, allowing methods to return data directly as JSON or XML without the need for additional annotations.
In contrast, @Controller is used for traditional web applications where methods typically return views (like HTML pages) and require the use of @ResponseBody to return data directly.

Difference between PUT and POST method in REST API?
The main difference between PUT and POST methods in REST API lies in their purpose and idempotency.
POST is used to create a new resource on the server and is not idempotent, meaning that multiple identical POST requests can result in multiple resources being created.
PUT, on the other hand, is used to update an existing resource or create a resource if it does not exist, and it is idempotent, meaning that multiple identical PUT requests will have the same effect as a single request.

 */