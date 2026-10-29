package com.Learn.CreateCustomAnnotation.Controller;


import com.Learn.CreateCustomAnnotation.Configs.checkPasswordCriteria;
import com.Learn.CreateCustomAnnotation.Configs.checkPrimeNumber;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class FavouriteNumberController {

    @GetMapping("/enterFavouriteNumber/{inputNo}")
    public ResponseEntity<Integer> checkIfInputNoPrime(@checkPrimeNumber(message = "Please enter prime number") @PathVariable int inputNo)
    {
        return ResponseEntity.ok(inputNo);
    }

    @PostMapping("/checkPassword")
    public ResponseEntity<String> checkPassword(@RequestBody @checkPasswordCriteria String password)
    {
        return ResponseEntity.status(HttpStatus.OK).body(password);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> handleAllExceptions(Exception e)
    {
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("status",HttpStatus.BAD_REQUEST);
        errorBody.put("message",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
   }
}
