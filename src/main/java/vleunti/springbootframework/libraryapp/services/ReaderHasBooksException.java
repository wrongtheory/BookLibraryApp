package vleunti.springbootframework.libraryapp.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Reader has still books")
@Component
public class ReaderHasBooksException extends RuntimeException {

    public String mess = "Reader has books";

    public String getMessage(){
        return "Reader has books";
    }
}

