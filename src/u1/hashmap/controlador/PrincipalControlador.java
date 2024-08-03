/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u1.hashmap.controlador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import u1.hashmap.modelo.Negocio;
import u1.hashmap.vista.PrincipalVista;

/**
 *
 * @author borisperezg
 */
public class PrincipalControlador {
    private Negocio negocio;
    private PrincipalVista frame;
    
    public PrincipalControlador(PrincipalVista frame){
        negocio = new Negocio();
        this.frame = frame;
    }
    
    public void registrarEstudiante(){
        String codigo = frame.getTxtCodigo().getText();
        String nombre = frame.getTxtNombreEstudiante().getText();
        String sPromedio = frame.getTxtPromedio().getText();
        double promedio = Double.parseDouble(sPromedio);
        
        negocio.agregarEstudiante(codigo, nombre, promedio);
        limpiarRegistrarEstudiante(); 
        actualizarListaEstudiantes();
        actualizarCombos();
    }
    
    public void registrarCurso(){
        String codigo = frame.getTxtCodigoCurso().getText();
        String nombre = frame.getTxtNombreCurso().getText();
        String sRequisitoPromedio = frame.getTxtRequisitoPromCurso().getText();
        double requisitoPromedio = Double.parseDouble(sRequisitoPromedio);
        
        negocio.agregarCurso(codigo, nombre, requisitoPromedio);
        limpiarRegistrarCurso();         
        actualizarCombos();
    }
    
    private void actualizarListaEstudiantes(){
        ArrayList<String> estudiates = negocio.listarEstudiantesHabilitados();
        DefaultListModel model = (DefaultListModel)frame.getlstEstudiantes().getModel();
        model.removeAllElements();
        for (String est : estudiates) {
            model.addElement(est);
        }
    }

    public void limpiarRegistrarEstudiante() {
        frame.getTxtCodigo().setText("");
        frame.getTxtNombreEstudiante().setText("");
        frame.getTxtPromedio().setText("");
    }
    
    public void limpiarRegistrarCurso() {
        frame.getTxtCodigoCurso().setText("");
        frame.getTxtNombreCurso().setText("");
        frame.getTxtRequisitoPromCurso().setText("");
    }
    
    private void actualizarCombos(){
        ArrayList<String> listaCodigoEstudiantes = negocio.listarEstudiantesHabilitadosCodigo();
        if(listaCodigoEstudiantes!=null){
            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>)frame.getCmbEstudiantes().getModel();
            modelo.removeAllElements();
            for (String codEst : listaCodigoEstudiantes) {
                modelo.addElement(codEst);
            }
        }
        
        
        ArrayList<String> listaCodigoCursos = negocio.listarCursosCodigo();
        if(listaCodigoCursos!=null){
            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>)frame.getCmbCursos().getModel();
            modelo.removeAllElements();
            for (String codCur : listaCodigoCursos) {
                modelo.addElement(codCur);
            }
        }
        
    }

    public void inhabilitar() {
        String estudianteSeleccionado = frame.getlstEstudiantes().getSelectedValue();
        // Se hace split para dividir la linea seleccionada
        String[] arreglo = estudianteSeleccionado.split(" - "); // codigo en posicion 0, y nombre en posicion 1
        
        negocio.inhabilitarEstudiante(arreglo[0]);
        actualizarListaEstudiantes();
        actualizarCombos();
        
    }
}
