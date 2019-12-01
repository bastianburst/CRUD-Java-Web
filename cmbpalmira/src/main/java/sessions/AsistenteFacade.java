/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Asistente;

/**
 *
 * @author Familia
 */
@Stateless
public class AsistenteFacade extends AbstractFacade<Asistente> {
    @PersistenceContext(unitName = "com.mycompany_cmbpalmira_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenteFacade() {
        super(Asistente.class);
    }
    
}
