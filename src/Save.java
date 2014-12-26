
import Acteur.Joueur;
import Acteur.StateJoueur;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class Save {
    
    private void sauvegarder(Joueur joueur) throws FileNotFoundException, IOException { // throws -> la fonction peut renvoyer les erreurs suivantes. (voir try/catch plus tard).
        StateJoueur sauvegarde = new StateJoueur(joueur);

        FileOutputStream sortieDeFicher = sortieDeFicher = new FileOutputStream("ressource/Save/save.pkm");
        ObjectOutputStream sortieDObjet = new ObjectOutputStream(sortieDeFicher);
        sortieDObjet.writeObject(sauvegarde);
        sortieDObjet.close();
    }
    
    private void charger(Joueur joueur) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream entreeDeFicher  = new FileInputStream("ressource/Save/save.pkm");
        ObjectInputStream entreeDObjet = new ObjectInputStream(entreeDeFicher);
        StateJoueur sauvegarde = (StateJoueur) entreeDObjet.readObject();
        entreeDObjet.close();
        joueur.transformerEn(sauvegarde);
    }
    
}
