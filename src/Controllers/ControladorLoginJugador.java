package Controllers;

import Model.Participante;
import Model.Partida;
import Model.Sistema;
import Views.PartidaDialog;

public class ControladorLoginJugador {

    private Sistema sistema = Sistema.getInstance();
    private IVistaLoginJugador vista;

    public ControladorLoginJugador(IVistaLoginJugador vista) {
        this.vista = vista;
    }

    public void login(String user, String pass) {
        Participante ppte = sistema.loginJugador(user, pass);

        if (ppte == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            vista.salir();
            // Create partida interface and update participantes
            new PartidaDialog(null, false, ppte).setVisible(true);
            ppte.getPartida().avisar(Partida.Eventos.actualizarParticipantes);
        }
    }
}
