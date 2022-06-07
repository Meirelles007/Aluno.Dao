package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Disciplina;

public class DisciplinaDao implements IAlunoDisciplina<Disciplina>{
	private SessionFactory sf;

	public DisciplinaDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Disciplina disciplina) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(disciplina);
		transaction.commit();
	}

	@Override
	public void update(Disciplina disciplina) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(disciplina);
		transaction.commit();
	}

	@Override
	public void delete(Disciplina disciplina) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(disciplina);
		transaction.commit();
	}

	@Override
	public Disciplina selectOne(Disciplina disciplina) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		disciplina = entityManager.find(Disciplina.class, disciplina.getCod_disc());
		return disciplina;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * from disciplina");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> disciplinasResultSet = query.getResultList();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Object[] o : disciplinasResultSet) {
			Disciplina disciplina = new Disciplina();
			disciplina.setCod_disc((Integer.parseInt(o[0].toString())));
			disciplina.setCarga_horaria((Integer.parseInt(o[1].toString())));
			disciplina.setNome_disc((o[2].toString()));
			disciplinas.add(disciplina);
		}
		
		return disciplinas;
	}

}
