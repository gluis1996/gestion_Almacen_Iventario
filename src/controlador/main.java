package controlador;

import vista.*;
import controlador.*;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        v_login vista = new v_login();
        c_login cl = new c_login(vista);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

}
