package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;
import model.Matricula;

public class MatriculaDao implements IMatriculaDao<Matricula> {
	private SessionFactory sf;

	public MatriculaDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Matricula matricula) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(matricula);
		transaction.commit();
	}

	@Override
	public void delete(Matricula matricula) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM matricula");
		sql.append("WHERE cod_disc = '" + matricula.getCod_disc().toString() + "'");
		sql.append(" AND ");
		sql.append("ra = '" + matricula.getRaAluno() + "';");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		System.out.println(query);
	}

	@Override
	public List<Matricula> selectAll(Matricula matricula) {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT m.ano, m.semestre, ");
		buffer.append("a.ra, a.nome, a.email, a.posic_vestibular ");
		buffer.append("FROM matricula m ");
		buffer.append("INNER JOIN aluno a ON a.ra = m.cod_disc ");
		buffer.append("WHERE ");
		buffer.append("matricula.cod_disc = '" + String.valueOf(matricula.getCod_disc().getCod_disc()) + "';");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();

		for (Object[] obj : lista) {
			Matricula m = new Matricula();
			Aluno aluno = new Aluno();
			m.setAno(Integer.parseInt(obj[0].toString()));
			m.setSemestre(Integer.parseInt(obj[1].toString()));

			aluno.setRa(obj[2].toString());
			aluno.setNome(obj[3].toString());
			aluno.setEmail(obj[4].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[5].toString()));

			m.setRaAluno(aluno);

			matriculas.add(m);
		}

		return matriculas;
	}

}
