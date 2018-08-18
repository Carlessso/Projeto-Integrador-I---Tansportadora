/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cidade;
import entidades.ComboItens;
import entidades.Estado;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class EstadoDao extends Dao {

    public static void trocaCombo(int idEstado, JComboBox cidade) {
        ComboItens item;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Estado e = (Estado) sessao.get(Estado.class, idEstado);

            cidade.removeAllItems();

            Iterator<Cidade> cidades = e.getCidades().iterator();
            while (cidades.hasNext()) {
                Cidade c = cidades.next();
                item = new ComboItens();
                item.setCodigo(c.getId());
                item.setDescricao(c.getNome());
                cidade.addItem(item);
            }
        } catch (Exception e) {

        }
    }
}
