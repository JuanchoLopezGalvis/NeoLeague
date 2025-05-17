package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Torneo;

public class EquipoDAO implements OperacionDAO<EquipoDTO, Equipo> {
	
	private ArrayList<Equipo> listaEquipos;
	
	public EquipoDAO() {
		listaEquipos = new ArrayList<Equipo>();
	}
	
	@Override
	public boolean showAll(JTable tabla) {
		if (listaEquipos.isEmpty()) {
			return false;
		}else {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			modelo.setRowCount(0);
			for (Equipo equipo : listaEquipos) {
				Object[] row = {equipo.getNombre(), equipo.getJuego(), equipo.getFechaInicio(), equipo.getFechaFin(), equipo.getFormato(), equipo.getMaxEquipos(), equipo.getPremio(), size};
				modelo.addRow(row);
			}
		}
		return true;
	}

	@Override
	public ArrayList<EquipoDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(EquipoDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EquipoDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Equipo find(Equipo toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(EquipoDTO previous, EquipoDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
}
