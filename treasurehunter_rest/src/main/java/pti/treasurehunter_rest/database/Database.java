package pti.treasurehunter_rest.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import pti.treasurehunter_rest.model.Game;

@Repository
public class Database {
	
	private SessionFactory sessionFactory;

	
	public Database() {
		Configuration cfg = new Configuration();
		cfg.configure();
		this.sessionFactory = cfg.buildSessionFactory();
	}

	public void saveGame(Game game) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(game);
		
		tx.commit();
		session.close();
		
	}
	
	

}
