package br.com.projeto.lp2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
            = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema.";

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public HttpErrorInfo handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.info(ex.toString());
        var msg = "";
        var cause = ex.getBindingResult();
        var firstProblem = cause.getAllErrors().stream().findFirst();

        if (firstProblem.isPresent()) {
            msg = firstProblem.get().getDefaultMessage();
        }

        return createHttpErrorInfo(msg);
    }
//
//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler(TransactionSystemException.class)
//    @ResponseBody
//    public HttpErrorInfo handleTransactionSystemException(TransactionSystemException ex) {
//        var cause = ex.getRootCause();
//        var msg = "";
//        if (cause instanceof ConstraintViolationException) {
//            var constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();
//            msg = constraintViolations.stream().findFirst().map(f -> f.getMessage()).orElse("");
//        }
//        return createHttpErrorInfo(msg);
//    }

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
//    public HttpErrorInfo handleConstraintExceptions(ConstraintViolationException ex) {
//
//        var constraintViolations = ex.getConstraintViolations();
//        var msg = constraintViolations.stream().findFirst().map(f -> f.getMessage()).orElse("");
//
//        return createHttpErrorInfo(msg);
//    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(SecurityException.class)
    @ResponseBody
    public HttpErrorInfo handleSecurityExceptions(SecurityException ex) {
        log.info("Message: {}", ex.getMessage());
        return createHttpErrorInfo(ex.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public HttpErrorInfo handleRuntimeExceptions(RuntimeException ex) {
        log.info("Message: {}", ex.getMessage());
        return createHttpErrorInfo(ex.getMessage());
    }


    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpErrorInfo handleExceptions(Exception ex) {
        log.info("Message: {}", ex);
        return createHttpErrorInfo(MSG_ERRO_GENERICA_USUARIO_FINAL);
    }

    private HttpErrorInfo createHttpErrorInfo(String msg) {
        final String message = msg;

        return HttpErrorInfo.builder()
                .message(message)
                .build();
    }

}
