package examen;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson; 

public class Consultorio {
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Consultorio() {
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }
    public void registrarMedico(Medico m) {
        medicos.add(m);
    }

    public void registrarConsulta(Consulta c) {
        consultas.add(c);
    }
    public void darBajaMedico(String nombre, String apellido) {
        int idMedicoEliminado = -1;
        Iterator<Medico> itMedico = medicos.iterator();
        while (itMedico.hasNext()) {
            Medico m = itMedico.next();
            if (m.getNombreMed().equalsIgnoreCase(nombre) && m.getApellidoMed().equalsIgnoreCase(apellido)) {
                idMedicoEliminado = m.getIdMed();
                itMedico.remove();
                System.out.println("Medico eliminado: " + nombre + " " + apellido);
                break;
            }
        }
        if (idMedicoEliminado != -1) {
            Iterator<Consulta> itConsulta = consultas.iterator();
            while (itConsulta.hasNext()) {
                Consulta c = itConsulta.next();
                if (c.getIdMed() == idMedicoEliminado) {
                    itConsulta.remove();
                    System.out.println("Consulta eliminada del paciente: " + c);
                }
            }
        } else {
            System.out.println("Medico no encontrado.");
        }
    }
    public void cambiarFechasEspeciales() {
        for (Consulta c : consultas) {
            boolean esNavidad = (c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre"));
            boolean esAnioNuevo = (c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero"));

            if (esNavidad || esAnioNuevo) {
                c.setDia(c.getDia() + 2);
                System.out.println("Fecha especial consulta reprogramada para el dia " + c.getDia());
            }
        }
    }

    public void mostrarTodo() {
        System.out.println(" LISTA DE MEDICOS");
        for(Medico m : medicos) System.out.println(m);
        System.out.println(" LISTA DE CONSULTAS ");
        for(Consulta c : consultas) System.out.println(c);
        System.out.println("--------------------------\n");
    }
    public void guardarDatosJson() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("consultorio.json")) {
            gson.toJson(this, writer);
            System.out.println(" Guardado en 'consultorio.json'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Consultorio cargarDatosJson() {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get("consultorio.json"))) {
            return gson.fromJson(reader, Consultorio.class);
        } catch (Exception e) {
            System.out.println("No se encontró archivo previo, iniciando nuevo consultorio.");
            return new Consultorio();
        }
    }
}