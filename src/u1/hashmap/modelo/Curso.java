/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u1.hashmap.modelo;

/**
 *
 * @author borisperezg
 */
public class Curso {
    private String codigo, nombre;
    private double requisitoProm;

    public Curso(String codigo, String nombre, double requisitoProm) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.requisitoProm = requisitoProm;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRequisitoProm() {
        return requisitoProm;
    }

    public void setRequisitoProm(double requisitoProm) {
        this.requisitoProm = requisitoProm;
    }
    
    
}
