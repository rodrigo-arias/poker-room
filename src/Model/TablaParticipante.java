package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TablaParticipante extends AbstractTableModel {

    private String[] columnNames = {"Nombre", "Saldo inicial", "Total apostado", "Total ganado"};
    private final Partida partida;

    public TablaParticipante(Partida partida) {
        this.partida = partida;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        if (partida != null && Sistema.instancia().participantesPartida(partida) != null) {
            return Sistema.instancia().participantesPartida(partida).size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (partida != null) {

            ArrayList<Participante> aux = Sistema.instancia().participantesPartida(partida);

            if (aux.size() > 0 && partida.getInicio() != null) {
                Participante p = aux.get(rowIndex);

                if (p != null) {
                    switch (columnIndex) {
                        case 0:
                            return p.getNombre();
                        case 1:
                            return p.getInicial();
                        case 2:
                            return p.getApostado();
                        case 3:
                            return p.getGanado();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return int.class;
            case 2:
                return int.class;
            case 3:
                return int.class;
        }
        return null;
    }
}
