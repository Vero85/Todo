package fr.eni.ihm;

/*
    La classe GUI est la fenêtre principal
 */

import fr.eni.bll.TodoManager;
import fr.eni.bllException.BLLException;
import fr.eni.bo.Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    // Création des panneaux, labels, bouton et champs
    private JPanel panneauPrincipal;
    private JPanel panneauSecondaire;
    private JPanel panneauTodos;
    private JLabel lblDate;
    private JLabel lblErreur;
    private JButton btnAjouter;
    private JTextField todoTexte;

public GUI() {
    this.setTitle("Ecran Todo");
    this.setSize(600,300);
    this.setResizable(false);
    this.setLocationRelativeTo(null); // centre la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arrête le programme qd clic sur la croix
    // colle le panneau sur le support
    this.setContentPane(getPanneauPrincipal()); // (1 seul panneau) je colle le panneau principal sur le support en bois
    this.pack();
    this.setVisible(true);
}

/*
création des singletons (composants)
 */
private JPanel getPanneauPrincipal() {
    if(panneauPrincipal == null) {
        panneauPrincipal = new JPanel(); // création du panneau principal
        panneauPrincipal.setLayout(new GridBagLayout()); // création des lignes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panneauPrincipal.add(getlblDate(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panneauPrincipal.add(gettodoTexte(), gbc);
        // - panneau secondaire
        gbc.gridx = 1;
        gbc.gridy = 1;
        panneauPrincipal.add(getpanneauSecondaire(), gbc);
        // - bouton ajouter
        gbc.gridx = 1;
        gbc.gridy = 7;
        panneauSecondaire.add(getbtnAjouter(), gbc);
    }
    return panneauPrincipal;
}


/*
Création d'un singleton pour le JLabel date
 */
public JLabel getlblDate() {
    if (lblDate == null) {
        lblDate = new JLabel("Nous sommes le "); // je crée le label date
        lblDate.setForeground(new Color(0xFFFFFF));
    }
    return lblDate;
}


    /*
    Création d'un singleton pour le JTextField
     */
    public JTextField gettodoTexte() {
        if (todoTexte == null) {
            todoTexte = new JTextField("Nous sommes le "); // je crée le champ texte
            todoTexte.setForeground(new Color(0xFFFFFF));
        }
        return todoTexte;
    }

    /*
    Création d'un singleton pour le Panneau secondaire
     */
    public JPanel getpanneauSecondaire() {
        if (panneauSecondaire == null) {
            panneauSecondaire = new JPanel(); // je crée le panneau secondaire
            panneauSecondaire.setLayout(new BoxLayout(panneauSecondaire, BoxLayout.Y_AXIS));
            panneauSecondaire.add(getbtnAjouter());
        }
        return panneauSecondaire;
    }

    /*
 Création d'un singleton pour le bouton Ajouter
  */
    public JButton getbtnAjouter() {
        if (btnAjouter == null) {
            btnAjouter = new JButton(); // je crée le panneau secondaire
            btnAjouter.setLayout(new BoxLayout(panneauSecondaire, BoxLayout.Y_AXIS));
            btnAjouter.add(getbtnAjouter());
        }
        return btnAjouter;
    }




/*
    Création d'un singleton pour le bouton enregistrer
 */

    /*public JButton gettbtnAjouter() {
        if (btnAjouter == null) {
            btnAjouter = new JButton(); // Je crée le bouton Ajouter
            btnAjouter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TodoManager cm = TodoManager.getInstance(); // j'appelle la BLL

                }
        }
        return btnAjouter;
    }

     */



}
