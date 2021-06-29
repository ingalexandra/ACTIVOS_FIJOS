package com.group.asd.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

/**
 * REST API response types
 * 
 * @author ingalexandrasarmiento
 */
@Getter
@AllArgsConstructor
public enum ApiResponseCode {

    SUCCESS("A001", "Proceso exitoso. ", HttpStatus.OK),
    ERROR("A002", "Ha ocurrido un error. ", HttpStatus.INTERNAL_SERVER_ERROR),
    LIST_EMPTY("A003", "No fue posible obtener registros para la consulta. ", HttpStatus.NOT_FOUND),
    DATA_NOT_FOUND("A004", "No fue posible obtener un registro para la consulta. ", HttpStatus.NOT_FOUND),
    DATABASE_EXCEPTION("E001", "Ha ocurrido un error al intentar acceder a la base de datos. ", HttpStatus.SERVICE_UNAVAILABLE),
    DATA_INTEGRITY_VIOLATION_EXCEPTION("E002", "Ha ocurrido una violacion de una restriccion de integridad. ", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String description;
    private final HttpStatus status;

}
