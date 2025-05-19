package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;

public class PartidaDAO implements OperacionDAO<PartidaDTO, Partida> {

    private final String TEXT_FILE_NAME = "partida.csv";
    private final String SERIAL_FILE_NAME = "partida.dat";
    private ArrayList<Partida> listaPartidas;

    public PartidaDAO() {
        listaPartidas = new ArrayList<>();
        leerArchivoSerializado();
    }

    @Override
    public boolean showAll(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        if (listaPartidas.isEmpty()) {
            modelo.setRowCount(0);
            return false;
        } else {
            modelo.setRowCount(0);
            for (Partida partida : listaPartidas) {
                Object[] row = {
                    partida.getId(),
                    partida.getEquipo1().getNombre(),
                    partida.getEquipo2().getNombre(),
                    partida.getGanador().getNombre(),
                    partida.getJuego(),
                    partida.getFecha(),
                    partida.getTorneoAlQuePertenece().getNombre()
                };
                modelo.addRow(row);
            }
        }
        return true;
    }

    @Override
    public ArrayList<PartidaDTO> getAll() {
        ArrayList<PartidaDTO> dtos = new ArrayList<>();
        for (Partida p : listaPartidas) {
            dtos.add(DataMapper.PartidaToPartidaDTO(p));
        }
        return dtos;
    }

    @Override
    public boolean add(PartidaDTO newData) {
        listaPartidas.add(DataMapper.PartidaDTOToPartida(newData));
        escribirArchivoSerializado();
        escribirArchivoTxt();
        return true;
    }

    @Override
    public boolean delete(PartidaDTO toDelete) {
        Partida partida = find(DataMapper.PartidaDTOToPartida(toDelete));
        if (partida != null) {
            listaPartidas.remove(partida);
            escribirArchivoSerializado();
            escribirArchivoTxt();
            return true;
        }
        return false;
    }

    @Override
    public Partida find(Partida toFind) {
        for (Partida p : listaPartidas) {
            if (p.getId() == toFind.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean update(PartidaDTO previous, PartidaDTO newData) {
        Partida partida = find(DataMapper.PartidaDTOToPartida(previous));
        if (partida != null) {
            listaPartidas.remove(partida);
            listaPartidas.add(DataMapper.PartidaDTOToPartida(newData));
            escribirArchivoSerializado();
            escribirArchivoTxt();
            return true;
        }
        return false;
    }

    public void escribirArchivoTxt() {
        StringBuilder contenido = new StringBuilder();
        for (Partida partida : listaPartidas) {
            contenido.append(partida.toString()); // Asegúrate de que Partida tiene un toString adecuado
        }
        FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
    }

    public void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPartidas);
    }

    public void leerArchivoSerializado() {
        listaPartidas = (ArrayList<Partida>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaPartidas == null) {
            listaPartidas = new ArrayList<>();
        }
    }

    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
}
