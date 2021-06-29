package com.group.asd.exception;

import com.group.asd.dto.ResponseDTO;
import com.group.asd.util.ApiResponseCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class to catch REST API exceptions
 * 
 * @author ingalexandrasarmiento
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = { DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        logger.error("handleConstraintViolationException() - {}", ex.getMessage());
        return ResponseEntity.status(ApiResponseCode.DATA_INTEGRITY_VIOLATION_EXCEPTION.getStatus())
                .body(new ResponseDTO<>(null, ApiResponseCode.DATA_INTEGRITY_VIOLATION_EXCEPTION.getCode(), ApiResponseCode.DATA_INTEGRITY_VIOLATION_EXCEPTION.getDescription().concat(ex.getMessage())));
    }

    @ExceptionHandler(value = { DataAccessException.class })
    public ResponseEntity<Object> handleDataAccessException(DataAccessException ex) {
        logger.error("handleDataAccessException() - {}", ex.getMessage());
        return ResponseEntity.status(ApiResponseCode.DATABASE_EXCEPTION.getStatus())
                .body(new ResponseDTO<>(null, ApiResponseCode.DATABASE_EXCEPTION.getCode(), ApiResponseCode.DATABASE_EXCEPTION.getDescription().concat(ex.getMessage())));
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        logger.error("handleGlobalException() - {}", ex.getMessage());
        return ResponseEntity.status(ApiResponseCode.ERROR.getStatus())
                .body(new ResponseDTO<>(null, ApiResponseCode.ERROR.getCode(), ApiResponseCode.ERROR.getDescription().concat(ex.getMessage())));
    }

}
