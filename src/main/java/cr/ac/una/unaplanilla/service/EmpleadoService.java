/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanilla.service;

import cr.ac.una.unaplanilla.model.Empleado;
import cr.ac.una.unaplanilla.model.EmpleadoDto;
import cr.ac.una.unaplanilla.util.EntityManagerHelper;
import cr.ac.una.unaplanilla.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;


/**
 *
 * @author Carlos
 */
public class EmpleadoService {
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;
    
    public Respuesta getUsuario(String usuario, String clave) {
        try {
            Query query = em.createNamedQuery("Empleado.findByUsuClave",Empleado.class);
            query.setParameter("usuario", usuario);
            query.setParameter("clave", clave);
            EmpleadoDto empleado = new EmpleadoDto((Empleado)query.getSingleResult());
            return new Respuesta(true, "", "", "Empleado", empleado);
        } catch(NoResultException ex){
            return new Respuesta(false,"No existe un usuario con las credenciales ingresadas","getUsuario NoResultExeption");
        } catch(NonUniqueResultException ex){
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario", ex);
            return new Respuesta(false,"ocurrio un error al consultar el usuario","getUsuario NonUniqueResultExeption");
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta getEmpleado(Long id) {
        try {
            
            
            Query query = em.createNamedQuery("Empleado.findByEmpId",Empleado.class);
            query.setParameter("id", id);
            EmpleadoDto empleado = new EmpleadoDto((Empleado)query.getSingleResult());
            return new Respuesta(true, "", "", "Empleado", empleado);
        } catch(NoResultException ex){
            return new Respuesta(false,"No existe un empleado con las credenciales ingresadas","getUsuario NoResultExeption");
        } catch(NonUniqueResultException ex){
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario", ex);
            return new Respuesta(false,"ocurrio un error al consultar el usuario","getUsuario NonUniqueResultExeption");
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo el empleado [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el empleado.", "getEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta getEmpleados(String cedula, String nombre, String pApellido) {
        try {
            List<EmpleadoDto> empleados = new ArrayList<>();
            return new Respuesta(true, "", "", "Empleados", empleados);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error obteniendo empleados.", ex);
            return new Respuesta(false, "Error obteniendo empleados.", "getEmpleados " + ex.getMessage());
        }
    }
    
    public Respuesta guardarEmpleado(EmpleadoDto empleadoDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Empleado empleado;
            if(empleadoDto.getId() != null && empleadoDto.getId()>0){
                empleado= em.find(Empleado.class,empleadoDto.getId());
                if(empleado==null){
                    et.rollback();
                    return new Respuesta(false, "No se encontro el empleado a modificar","guardarEmpleado NoResultExeption");
                }
                empleado.actualizarEmpleado(empleadoDto);
                empleado = em.merge(empleado);
            }else{
                empleado = new Empleado(empleadoDto);
                em.persist(empleado);
            }
            et.commit();
            return new Respuesta(true, "", "", "Empleado", new EmpleadoDto(empleado));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error guardando el empleado.", ex);
            return new Respuesta(false, "Error guardando el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarEmpleado(Long id) {
        try {
           et = em.getTransaction();
           et.begin();
           Empleado empleado;
           if(id !=null && id >0){
               empleado= em.find(Empleado.class,id);
               if(empleado==null){
                   et.rollback();
                   return new Respuesta(false, "No se encontro el empleado a eliminar.", "eliminarEmpleado NoResultExeceprion");
               }
               em.remove(empleado);               
           }else{
                et.rollback();
                return new Respuesta(false, "Debe cargar el empleado a eliminar", "eliminarEmpleado NoResultExeceprion");
            }
           et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            
            if(ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class){
                return new Respuesta(false, "No se puede eliminar el emppleado porque tiene relacion con otro registro", "eliminarEmpleado " + ex.getMessage());
            }
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            return new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }
}
