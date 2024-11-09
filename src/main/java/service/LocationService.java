package service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.UUID;

public class LocationService {

    // Get village_id from Location table using village name
    public UUID getVillageIdByName(String villageName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UUID villageId = null;

        try {
            String hql = "SELECT locationId FROM Location WHERE LocationName = :villageName AND locationType = 'Village'";
            Query query = session.createQuery(hql);
            query.setParameter("villageName", villageName);
            villageId = (UUID) query.uniqueResult();  // Returns UUID instead of String
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return villageId;
    }

    // Get village_id from Location table using village ID
    public UUID getVillageIdById(UUID locationId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UUID villageId = null;

        try {
            String hql = "SELECT locationId FROM Location WHERE locationId = :locationId AND locationType = 'Village'";
            Query query = session.createQuery(hql);
            query.setParameter("locationId", locationId);
            villageId = (UUID) query.uniqueResult();  // Returns UUID instead of String
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return villageId;
    }
}
