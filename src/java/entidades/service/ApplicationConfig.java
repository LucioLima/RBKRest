/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author luciolima
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entidades.service.AcoesFacadeREST.class);
        resources.add(entidades.service.GerenciaFacadeREST.class);
        resources.add(entidades.service.JobFacadeREST.class);
        resources.add(entidades.service.OrigemFacadeREST.class);
        resources.add(entidades.service.PerfilFacadeREST.class);
        resources.add(entidades.service.PredecessorFacadeREST.class);
        resources.add(entidades.service.RunbookFacadeREST.class);
        resources.add(entidades.service.SistemaFacadeREST.class);
        resources.add(entidades.service.SucessorFacadeREST.class);
        resources.add(entidades.service.UsuarioFacadeREST.class);
    }
    
}
