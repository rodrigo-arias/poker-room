package Model;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TablaPartida extends AbstractTableModel {

    private String[] columnNames = {"Inicio", "Jugando", "Total apostado", "Manos jugadas"};

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return Sistema.instancia().partidasTodas().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ArrayList<Partida> partidas = Sistema.instancia().partidasTodas();
        Partida partida = partidas.get(rowIndex);

        if (partidas.size() > 0 && partida.getInicio() != null) {

            DateTimeFormatter formato = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

            switch (columnIndex) {
                case 0:
                    return partida.getInicio().format(formato);
                case 1:
                    return Sistema.instancia().participantesPartida(partida).size();
                case 2:
                    return partida.getApostado();
                case 3:
                    return partida.getCantManos();
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
