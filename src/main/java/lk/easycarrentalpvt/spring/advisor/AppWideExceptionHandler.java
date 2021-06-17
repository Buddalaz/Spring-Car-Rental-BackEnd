package lk.easycarrentalpvt.spring.advisor;


import lk.easycarrentalpvt.spring.exception.NotFoundException;
import lk.easycarrentalpvt.spring.exception.ValidateException;
import lk.easycarrentalpvt.spring.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
//    client case = 400
    //server case = 500

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){
        return new ResponseEntity(new StandardResponse("500","Error",e.getMessage(),0L), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new StandardResponse("404","Error",e.getMessage(),0L), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e){
        return new ResponseEntity(new StandardResponse("400","Error",e.getMessage(),0L), HttpStatus.BAD_REQUEST);
    }
}
