package com.example.IPApp.error;

public enum Error {
    GENERIC_ERROR("Ups!! A ocurrido un error desconocido"),
    SERVICE_ERROR("Algunos servicios no están respondiendo en este momento"),
    INCONSISTENT_DATA("Hubo un error con los datos obtenidos para esta búsqueda"),
    UNDEFINED("Desconocido");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
