package Model;

import java.util.ArrayList;

class SistemaAdmin {

    //==================  Attributes  ==================//
    private ArrayList<Admin> administradores = new ArrayList();
    private ArrayList<Admin> logueados = new ArrayList();

    //==================  Methods  ==================//
    public Admin loginAdmin(String user, String pass) {

        Admin adm = null;

        for (Admin a : administradores) {
            if (a.getUsuario().equalsIgnoreCase(user) && a.getContrasena().equals(pass)) {

                if (!logueados.contains(a)) {
                    logueados.add(a);
                    adm = a;
                }
            }
        }
        return adm;
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

    public void logoutAdmin(Admin a) {
        if (logueados.contains(a)) {
            logueados.remove(a);
        }
    }

}
