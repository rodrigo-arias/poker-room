package Controllers;

import Model.Participante;

public interface IVistaPartida {

    public void mostrarError(String msg);

    public void actualizarParticipantes(Participante ppte);
}
