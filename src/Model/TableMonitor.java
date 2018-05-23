package Model;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableMonitor extends AbstractTableModel {

    private String[] columnNames = {"#", "Inicio", "Jugando", "Total apostado", "Manos jugadas"};

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return Sistema.getInstance().getPartidasActivas().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ArrayList<Partida> activas = Sistema.getInstance().getPartidasActivas();

        if (activas.size() > 0) {

            Partida partida = activas.get(rowIndex);
            DateTimeFormatter formato = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

            switch (columnIndex) {
                case 0:
                    return partida.getId();
                case 1:
                    return partida.getInicio().format(formato);
                case 2:
                    return partida.getJugadores().size();
                case 3:
                    return partida.getTotalApostado();
                case 4:
                    return partida.getManos().size();
            }
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return int.class;
            case 3:
                return int.class;
            case 4:
                return int.class;
        }
        return null;
    }
}
