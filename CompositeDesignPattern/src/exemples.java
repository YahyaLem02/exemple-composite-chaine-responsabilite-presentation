// Interface commune pour les menus et sous-menus
public interface MenuComponent {
    void afficher();
}

// Implémentation des menus simples
public class MenuSimple implements MenuComponent {
    private String nom;

    public MenuSimple(String nom) {
        this.nom = nom;
    }

    public void afficher() {
        System.out.println(nom);
    }
}

// Implémentation des sous-menus (composés)
import java.util.ArrayList;
import java.util.List;

public class SousMenu implements MenuComponent {
    private String nom;
    private List<MenuComponent> elements;

    public SousMenu(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    public void ajouter(MenuComponent element) {
        elements.add(element);
    }

    public void supprimer(MenuComponent element) {
        elements.remove(element);
    }

    public void afficher() {
        System.out.println("Sous-menu : " + nom);
        for (MenuComponent element : elements) {
            element.afficher();
        }
    }
}

// Exemple d'utilisation
public class ExempleUtilisation {
    public static void main(String[] args) {
        MenuComponent menuPrincipal = new SousMenu("Menu Principal");

        MenuComponent menu1 = new SousMenu("Menu 1");
        menu1.ajouter(new MenuSimple("Sous-menu 1.1"));
        menu1.ajouter(new MenuSimple("Sous-menu 1.2"));

        MenuComponent menu3 = new SousMenu("Menu 3");
        MenuComponent sousMenu3_1 = new SousMenu("Sous-menu 3.1");
        sousMenu3_1.ajouter(new MenuSimple("Sous-sous-menu 3.1.1"));
        sousMenu3_1.ajouter(new MenuSimple("Sous-sous-menu 3.1.2"));
        menu3.ajouter(sousMenu3_1);
        menu3.ajouter(new MenuSimple("Sous-menu 3.2"));

        menuPrincipal.ajouter(menu1);
        menuPrincipal.ajouter(new MenuSimple("Menu 2"));
        menuPrincipal.ajouter(menu3);

        menuPrincipal.afficher();
    }
}
