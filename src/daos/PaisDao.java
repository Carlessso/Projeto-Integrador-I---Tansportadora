/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cidade;
import entidades.Estado;
import entidades.Pais;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import entidades.ComboItens;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class PaisDao extends Dao {

    public static void trocaCombo(int idPais, JComboBox estado, JComboBox cidade) {
        ComboItens item;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Pais p = (Pais) sessao.get(Pais.class, idPais);

            estado.removeAllItems();
            cidade.removeAllItems();

            Iterator<Estado> estados = p.getEstados().iterator();
            while (estados.hasNext()) {
                Estado e = estados.next();
                item = new ComboItens();
                item.setCodigo(e.getId());
                item.setDescricao(e.getSigla());
                estado.addItem(item);

                Iterator<Cidade> cidades = e.getCidades().iterator();
                while (cidades.hasNext()) {
                    Cidade c = cidades.next();
                    item = new ComboItens();
                    item.setCodigo(c.getId());
                    item.setDescricao(c.getNome());
                    cidade.addItem(item);
                }

            }
        } catch (Exception e) {

        }
    }

    public static void populaCombo(JComboBox pais, JComboBox estado, JComboBox cidade) {
        ComboItens item;

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = null;

            crit = sessao.createCriteria(Pais.class);

            List dados = crit.list();
            int primeiro = 0;
            for (Object dado : dados) {
                Pais p = (Pais) dado;
                item = new ComboItens();
                item.setCodigo(p.getId());
                item.setDescricao(p.getNome());
                pais.addItem(item);

                if (primeiro == 0) {
                    primeiro++;
                    Iterator<Estado> estados = p.getEstados().iterator();
                    while (estados.hasNext()) {
                        System.out.println("fui");
                        Estado e = estados.next();
                        item = new ComboItens();
                        item.setCodigo(e.getId());
                        item.setDescricao(e.getSigla());
                        estado.addItem(item);

                        Iterator<Cidade> cidades = e.getCidades().iterator();
                        while (cidades.hasNext()) {
                            Cidade c = cidades.next();
                            item = new ComboItens();
                            item.setCodigo(c.getId());
                            item.setDescricao(c.getNome());
                            cidade.addItem(item);
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
