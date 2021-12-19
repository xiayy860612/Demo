package com.s2u2m.demo.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = "/{ping}", method = RequestMethod.GET)
    public String getPingPong(@PathVariable String ping) {
        return ping;
    }

    @GetMapping(value = "/{ping}", params = "ex=1")
    public String getPingPongEx(@PathVariable String ping) {
        return ping + " Ex";
    }

    /**
     * convert "money=cn 12" from request param
     * to {@link Money} object by {@link MoneyFormatter}
     */
    @GetMapping(value = "/price")
    public Money price(@RequestParam Money money) {
        return money;
    }

    @PostMapping(value = "/price")
    public Money priceFromBody(@RequestBody Money money) {
        return money;
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<String> handleMissingRequestValueException(MissingRequestValueException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
