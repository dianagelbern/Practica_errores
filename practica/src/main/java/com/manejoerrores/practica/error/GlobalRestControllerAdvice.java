package com.manejoerrores.practica.error;

import com.manejoerrores.practica.error.excepciones.EntityNotFoundException;
import com.manejoerrores.practica.error.model.ApiError;
import com.manejoerrores.practica.error.model.ApiSubError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiErrorStatus(status, ex, request);
    }
/*
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiErrorWithSubError(HttpStatus.BAD_REQUEST, "Errores varios en la validación",
                request,
                ex.getFieldError().stream())
    }
*/

    //Faltan dos métodos más
    private ResponseEntity<Object> buildApiErrorStatus(HttpStatus status, Exception ex, WebRequest request) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    private ResponseEntity<Object> buildApiError404(Exception ex, WebRequest request){
        return buildApiErrorStatus(HttpStatus.NOT_FOUND, ex, request);
    }

    private ResponseEntity<Object> buildApiError400(Exception ex, WebRequest request){
        return buildApiErrorStatus(HttpStatus.BAD_REQUEST, ex, request);
    }

    private ResponseEntity<Object> buildApiErrorWithSubError(HttpStatus estado, String mensaje, WebRequest request, List<ApiSubError> subErrores){
        return ResponseEntity
                .status(estado)
                .body(new ApiError(estado, mensaje, ((ServletWebRequest) request).getRequest().getRequestURI(), subErrores));
    }
/*
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException ex, WebRequest request){
        return buildApiError(ex, request);
    }
 */
}
