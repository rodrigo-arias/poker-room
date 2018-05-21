package Model;

import javax.swing.table.AbstractTableModel;

public class TableJugando extends AbstractTableModel {

    private String[] columnNames = {"#", "Nombre", "Total apostado", "Saldo inicial", "Total ganado"};
    private final Partida partida;

    public TableJugando(Partida partida) {
        this.partida = partida;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        if (this.partida != null) {
            return this.partida.getJugadores().size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (this.partida != null && this.partida.getJugadores().size() > 0) {

            Jugador jugador = this.partida.getJugadores().get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return rowIndex + 1;
                case 1:
                    return jugador.getNombre();
                case 2:
                    return jugador.getTotalApostado();
                case 3:
                    return jugador.getSaldoInicial();
                case 4:
                    return jugador.getTotalGanado();
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
