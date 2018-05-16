package Model;

import java.util.ArrayList;

class SistemaAdmin {

    //==================  Attributes  ==================//
    private ArrayList<Admin> administradores = new ArrayList();

    //==================  Methods  ==================//
    public Admin loginAdmin(String user, String pass) {
        for (Admin a : administradores) {
            if (a.getUsuario().equalsIgnoreCase(user) && a.getContrasena().equals(pass)) {

                return a;
            }
        }
        return null;
    }

    public void agregarAdmin(Admin a) {
        administradores.add(a);
    }
}
