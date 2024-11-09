package dao;


import model.Membership;
import model.User;
import util.HibernateUtil;

import java.awt.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MembershipDAO {

    public Membership getMembershipByType(String membershipType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Membership membership = null;
        try {
            String hql = "FROM Membership WHERE type = :membershipType";
            Query query = session.createQuery(hql);
            query.setParameter("membershipType", membershipType);
            membership = (Membership) query.uniqueResult();
        } finally {
            session.close();
        }
        return membership;
    }

    public void updateUserMembership(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


    public List<Membership> getPendingMembershipRequests() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Membership> pendingRequests = session.createQuery("FROM Membership WHERE status = 'PENDING'", Membership.class).list();
        session.close();
        return pendingRequests;
    }





}
