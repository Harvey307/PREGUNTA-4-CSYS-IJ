package org.example;

public class TextProcessor {
    public static String reverseAndCapitalize(String input) {
        // 1. Validar nulo
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // 2. Validar longitud
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // 3. Validar si está vacío o son solo espacios
        // trim() quita espacios, si queda vacío es que solo eran espacios
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío o contener solo espacios");
        }

        // 4. Procesar el texto
        String sinEspacios = input.trim();          // Quitar espacios inicio/fin
        String mayusculas = sinEspacios.toUpperCase(); // Convertir a Mayúsculas

        // Usamos StringBuilder para invertir el texto fácilmente
        StringBuilder sb = new StringBuilder(mayusculas);
        return sb.reverse().toString();
    }
}
