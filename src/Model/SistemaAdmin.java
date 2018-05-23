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

    public boolean registrarAdmin(Admin a) {

        if (!administradores.contains(a)) {
            for (Admin adm : administradores) {
                if (adm.equals(a)) {
                    return false;
                }
            }
            // Si el admin no fue registrado y no hay otro con el mismo usuario
            administradores.add(a);
            return true;
        }
        return false;
    }

}
