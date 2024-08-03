/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u1.hashmap.modelo;

import java.util.ArrayList;

/**
 *
 * @author borisperezg
 */
public class Estudiante {
    private String codigo, nombres;
    private double promedio;
    private boolean habilitado;
    private ArrayList<Curso> cursosMatriculados;

    public Estudiante(String codigo, String nombres, double promedio) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.promedio = promedio;
        habilitado = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public boolean isHabilitado(){
        return habilitado;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    public void matricularCurso(Curso curso){
        
        // TODO Validar que el curso ya esté matriculado.
        
        cursosMatriculados.add(curso);
    }
    
    public ArrayList<Curso> listarCursosMatriculados(){
        return cursosMatriculados;
    }
    
    public void inhabilitar(){
        habilitado = false;
    }
    
}
