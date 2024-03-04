package br.com.azship.admshipping.application.exception;

import br.com.azship.admshipping.application.dto.ApiResponseDTO;
import br.com.azship.admshipping.application.dto.FieldErrorDTO;
import br.com.azship.admshipping.domain.exception.ClientNotFoundException;
import br.com.azship.admshipping.domain.exception.FreightNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerException {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(ClientNotFoundException.class)
    public void handleClientNotFoundException(ClientNotFoundException exception) {
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(FreightNotFoundException.class)
    public void handleFreightNotFoundException(FreightNotFoundException exception) {
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();

        return fieldErrorList.stream().map(f -> new FieldErrorDTO(f.getField(), f.getDefaultMessage())).toList();

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception exception) {
        return "Houve uma falha ao processar essa solicitação.";
    }

}

