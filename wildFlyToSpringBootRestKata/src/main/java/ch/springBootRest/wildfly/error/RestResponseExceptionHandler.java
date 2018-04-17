package ch.springBootRest.wildfly.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    // HTTP 400

    @Override // Validation ErrorMessage
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        return handleExceptionInternal(ex, processArgumentNotValidException(ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    private ErrorMessage processArgumentNotValidException(final MethodArgumentNotValidException ex) {

        Map.Entry<String, Object> dtoModel = ex.getBindingResult().getModel().entrySet().stream().findFirst().get();
        Dto dto = new Dto.DtoBuilder(dtoModel.getKey(), dtoModel.getValue()).build();

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ErrorTypeEnum.ERROR_TYPE_BUSINESS_EXECTION.getErrorType(), dto);

        ex.getBindingResult().getFieldErrors()
                .stream()
                .forEach(error -> errorMessage.addError(error.getObjectName(), error.getField(), error.getDefaultMessage()));

        return errorMessage;
    }
}
