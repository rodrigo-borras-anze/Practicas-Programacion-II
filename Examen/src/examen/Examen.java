package examen;
public class Examen {
    public static void main(String[] args) {

        Consultorio consultorio = new Consultorio();
        System.out.println("ALTA DE DATOS:");
        
        consultorio.registrarMedico(new Medico(1, "Juan", "Perez", 10));
        consultorio.registrarMedico(new Medico(2, "Ana", "Gomez", 5));
        consultorio.registrarMedico(new Medico(3, "Luis", "Salinas", 15));

        consultorio.registrarConsulta(new Consulta(101, "Carlos", "Mesa", 1, 10, "Octubre", 2025));
        consultorio.registrarConsulta(new Consulta(102, "Maria", "Rojas", 1, 25, "Diciembre", 2025)); // Navidad
        consultorio.registrarConsulta(new Consulta(103, "Pedro", "Lima", 1, 14, "Febrero", 2025));

       
        consultorio.registrarConsulta(new Consulta(104, "Sofia", "Claros", 2, 1, "Enero", 2025)); // Año Nuevo
        consultorio.registrarConsulta(new Consulta(105, "Raul", "Terceros", 2, 2, "Marzo", 2025));
        consultorio.registrarConsulta(new Consulta(106, "Elena", "Vargas", 2, 25, "Diciembre", 2025)); // Navidad

       
        consultorio.registrarConsulta(new Consulta(107, "Jose", "Torres", 3, 15, "Abril", 2025));
        consultorio.registrarConsulta(new Consulta(108, "Lucia", "Paz", 3, 20, "Mayo", 2025));
        consultorio.registrarConsulta(new Consulta(109, "Marco", "Solis", 3, 1, "Enero", 2025)); // Año Nuevo

        consultorio.mostrarTodo();
        consultorio.guardarDatosJson(); 

       
        System.out.println("BAJA DE MEDICO Y CONSULTAS:");
    
        consultorio.darBajaMedico("Juan", "Perez");
        
        consultorio.mostrarTodo();
        consultorio.guardarDatosJson(); 

        
        System.out.println("CAMBIO DE FECHAS ESPECIALES");
        consultorio.cambiarFechasEspeciales();
        
        consultorio.mostrarTodo();
        
      
        consultorio.guardarDatosJson();
    }
}