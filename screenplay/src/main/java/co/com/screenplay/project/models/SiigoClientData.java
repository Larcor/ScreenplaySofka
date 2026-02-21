package co.com.screenplay.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de datos para la creación de un cliente en Siigo.
 * Encapsula los campos requeridos del formulario "Crear un tercero".
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiigoClientData {

    private String tipoId;
    private String numeroId;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String correo;
}
