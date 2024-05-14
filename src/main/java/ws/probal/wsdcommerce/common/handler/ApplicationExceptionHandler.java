package ws.probal.wsdcommerce.common.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ws.probal.wsdcommerce.common.exception.ValidationException;
import ws.probal.wsdcommerce.common.exception.RecordNotFoundException;
import ws.probal.wsdcommerce.common.logger.ApplicationLoggerService;
import ws.probal.wsdcommerce.domain.common.ApplicationErrorResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {

    private final ApplicationLoggerService loggerService;

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<ApplicationErrorResponse> handleValidationException(ValidationException ex) {
        loggerService.error(ex.getLocalizedMessage(), ex);
        ApplicationErrorResponse response = new ApplicationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ApplicationErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex) {
        loggerService.error(ex.getLocalizedMessage(), ex);
        ApplicationErrorResponse response = new ApplicationErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApplicationErrorResponse> commonException(Exception ex) {
        loggerService.error(ex.getLocalizedMessage(), ex);
        ApplicationErrorResponse response = new ApplicationErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
