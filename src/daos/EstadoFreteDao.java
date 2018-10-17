/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.ComboItens;
import entidades.EstadoFrete;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class EstadoFreteDao extends Dao {
    
    public static void populaCombo(JComboBox grupo) {
        ComboItens item;
        grupo.removeAllItems();
        
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = null;

            crit = sessao.createCriteria(EstadoFrete.class);

            List dados = crit.list();
            
            for (Object dado : dados) {
                EstadoFrete ef = (EstadoFrete) dado;
                item = new ComboItens();
                item.setCodigo(ef.getId());
                item.setDescricao(ef.getDescricao());
                grupo.addItem(item);                
            }
        } catch (Exception e) {

        }
    }
    
}
