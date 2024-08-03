/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u1.hashmap.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author borisperezg
 */
public class Negocio {

    private HashMap<String, Estudiante> estudiantes;
    private HashMap<String, Curso> cursos;

    public Negocio() {
        estudiantes = new HashMap<String, Estudiante>();
        cursos = new HashMap<String, Curso>();
    }
    
    public void agregarEstudiante(String codigo, String nombres, double promedio){
        // TODO Validar que no esté ya registrado el estudiante
        
        // TODO Validar que el estudiante tengo promedio por encima de 3
        
        estudiantes.put(codigo, new Estudiante(codigo, nombres, promedio));
    }
    
    public void agregarCurso(String codigo, String nombre, double requisitoProm){
        // TODO Validar que no esté ya registrado el curso

        // TODO Validar que el requisito de promedio esté por encima de 3.
        
        cursos.put(codigo, new Curso(codigo, nombre, requisitoProm));
    }
    
    /**
     * Lista los estudiantes habilitados retornando el codigo y el nombre.
     * @return 
     */
    public ArrayList<String> listarEstudiantesHabilitados(){
        // Se arma una lista de Strings
        ArrayList<String> listaEstudiantes = new ArrayList<>();
        
        for (Map.Entry<String, Estudiante> entrada : estudiantes.entrySet()) {
            String key = entrada.getKey();
            Estudiante val = entrada.getValue();
            
            if(val.isHabilitado())            
                listaEstudiantes.add(key + " - " + val.getNombres());
            
        }
        
        return listaEstudiantes;
    }
    
    /**
     * Lista los estudiantes habilitados retornando el codigo.
     * @return 
     */
    public ArrayList<String> listarEstudiantesHabilitadosCodigo(){
        // Se arma una lista de Strings
        ArrayList<String> listaEstudiantes = new ArrayList<>();
        
        for (Map.Entry<String, Estudiante> entrada : estudiantes.entrySet()) {
            String key = entrada.getKey();
            Estudiante val = entrada.getValue();
            
            if(val.isHabilitado())            
                listaEstudiantes.add(key);
            
        }
        
        return listaEstudiantes;
    }
    
    public void inhabilitarEstudiante(String codigo){
        Estudiante est = estudiantes.get(codigo);
        if(est!=null)
            est.inhabilitar();
    }
    
    public ArrayList<String> listarCursosCodigo(){
        // Se arma una lista de Strings
        ArrayList<String> listaCursos = new ArrayList<>();
        
        for (Map.Entry<String, Curso> entrada : cursos.entrySet()) {
            String key = entrada.getKey();
            Curso val = entrada.getValue();
                     
            listaCursos.add(key);
            
        }
        
        return listaCursos;
    }
    
    public ArrayList<String> listarCursosEstudiante(String codigoEstudiante){
        // Se arma una lista de Strings
        ArrayList<String> listaCursosEstudiante = new ArrayList<>();
        
        Estudiante est = estudiantes.get(codigoEstudiante);
        if(est!=null){            
            ArrayList<Curso> listaCursos = est.listarCursosMatriculados();
            for (Curso curso : listaCursos) {
                listaCursosEstudiante.add(curso.getCodigo() + " - " + curso.getNombre());
            }            
        }
        
        return listaCursosEstudiante;
    }

}
