package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Matricula;

public interface IMatriculaDao<T> {
	public void insert(T t) throws SQLException;
	public void delete(T t) throws SQLException;
	public List<T> selectAll(Matricula matricula);
}
