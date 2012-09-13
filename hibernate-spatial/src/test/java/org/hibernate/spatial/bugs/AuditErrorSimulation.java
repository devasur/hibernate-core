package org.hibernate.spatial.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 9/12/12
 */
public class AuditErrorSimulation {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
		Incident inc = new Incident(3L);
		inc.setGeom( new Point(new Coordinate(2, 5), new PrecisionModel(10), 4326) );
        entityManager.persist(inc);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}


