/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permissao;

import entidades.GrupoAcao;
import entidades.Programas;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class Controle {
    public static void permissiona(JTabbedPane pane, Programas tela){

        Set<GrupoAcao> grupoAcao = TranSOFT.USUARIO.getGrupo().getGrupoAcaos();
        ArrayList<GrupoAcao> ga = new ArrayList<>();
        
        grupoAcao.stream().filter((g) -> (g.getAcao().getProgramas().getVariavel().equalsIgnoreCase(tela.getVariavel()))).forEachOrdered((g) -> {
            ga.add(g);
        });
        
        for (Component tabbed : pane.getComponents()) {
            for (Component comp : ((JPanel) tabbed).getComponents()) {
                if (comp instanceof JButton) {
                    for (int i = 0; i < ga.size(); i++) {
                        GrupoAcao gAtual = ga.get(i);
                        if(((JButton)comp).getName().equalsIgnoreCase(gAtual.getAcao().getVariavel())){
                            comp.setEnabled(gAtual.getPermissao());
                        }
                    }
                }
            }
        }
    }
}
