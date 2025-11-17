package com.ams.servicedao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Address;
import com.model.Student;
import com.config.HibernateConfig;

public class ServiceDaoImpl implements ServiceDao {

    // ------------------ Create ------------------
    @Override
    public void createStudentWithAddressInDao(Student stud, Address add) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            // Ensure both sides linked
            stud.setAddress(add);

            session.save(stud); // cascade will save Address
            tx.commit();
            System.out.println("Student with Address saved successfully.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error saving student with address: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void createAddressWithStudentInDao(Address add, Student stud) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            // link both sides via student as the owning side
            stud.setAddress(add);

            session.save(stud);
            tx.commit();
            System.out.println("Address with Student saved successfully.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error saving address with student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void createStudentOnlyInDao(Student stud) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(stud);
            tx.commit();
            System.out.println("Student saved successfully.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error saving student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void createAddressOnlyInDao(Address add) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(add);
            tx.commit();
            System.out.println("Address saved successfully.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error saving address: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // ------------------ Display ------------------
    @Override
    public void displayAllDetailsInDao() {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            List<Student> students = session.createQuery("from Student", Student.class).list();

            System.out.println("----- All Student & Address Details -----");
            for (Student s : students) {
                System.out.println("Student ID: " + s.getSid());
                System.out.println("Student Name: " + s.getSname());
                Address add = s.getAddress();
                if (add != null) {
                    System.out.println("Address ID: " + add.getAid());
                    System.out.println("Address Name: " + add.getAname());
                } else {
                    System.out.println("Address: Not Available");
                }
                System.out.println("-----------------------------------------");
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error displaying details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void displayStudentUsingStudentIDInDao(int sid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student s = session.get(Student.class, sid);
            if (s == null) {
                System.out.println("No Student found with ID: " + sid);
            } else {
                System.out.println("----- Student Details -----");
                System.out.println("Student ID: " + s.getSid());
                System.out.println("Student Name: " + s.getSname());
                Address add = s.getAddress();
                if (add != null) {
                    System.out.println("Address ID: " + add.getAid());
                    System.out.println("Address Name: " + add.getAname());
                } else {
                    System.out.println("Address: Not Available");
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error displaying student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void displayStudentUsingAddressIdInDao(int aid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address add = session.get(Address.class, aid);
            if (add == null) {
                System.out.println("No Address found with ID: " + aid);
            } else {
                Student s = add.getStudent();
                if (s == null) {
                    System.out.println("No Student linked with Address ID: " + aid);
                } else {
                    System.out.println("----- Student Details -----");
                    System.out.println("Student ID: " + s.getSid());
                    System.out.println("Student Name: " + s.getSname());
                    System.out.println("----- Address Details -----");
                    System.out.println("Address ID: " + add.getAid());
                    System.out.println("Address Name: " + add.getAname());
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error displaying student using address id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void displayAddressUsingStudentIdInDao(int sid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student s = session.get(Student.class, sid);
            if (s == null) {
                System.out.println("No Student found with ID: " + sid);
            } else {
                Address add = s.getAddress();
                if (add == null) {
                    System.out.println("No Address linked with Student ID: " + sid);
                } else {
                    System.out.println("----- Address Details -----");
                    System.out.println("Address ID: " + add.getAid());
                    System.out.println("Address Name: " + add.getAname());
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error displaying address using student id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void displayAddressUsingAddressIdInDao(int aid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address add = session.get(Address.class, aid);
            if (add == null) {
                System.out.println("No Address found with ID: " + aid);
            } else {
                System.out.println("----- Address Details -----");
                System.out.println("Address ID: " + add.getAid());
                System.out.println("Address Name: " + add.getAname());
                Student s = add.getStudent();
                if (s != null) {
                    System.out.println("Linked Student ID: " + s.getSid());
                    System.out.println("Linked Student Name: " + s.getSname());
                } else {
                    System.out.println("No Student linked to this Address");
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error displaying address using address id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // ------------------ Update ------------------
    @Override
    public void updateAllDetailsInDao(int sid, String newSname, String newAname) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, sid);
            if (student == null) {
                System.out.println("No Student found with ID: " + sid);
                tx.commit();
                return;
            }

            if (newSname != null) student.setSname(newSname);

            Address address = student.getAddress();
            if (newAname != null) {
                if (address == null) {
                    Address newAddress = new Address();
                    newAddress.setAname(newAname);
                    student.setAddress(newAddress);
                    session.saveOrUpdate(student);
                } else {
                    address.setAname(newAname);
                }
            }

            tx.commit();
            System.out.println("Update completed for Student ID: " + sid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error updating all details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateStudentUsingStudentIDInDao(int sid, String newSname) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, sid);
            if (student == null) {
                System.out.println("No Student found with ID: " + sid);
                tx.commit();
                return;
            }

            student.setSname(newSname);

            tx.commit();
            System.out.println("Student updated successfully. ID: " + sid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateStudentUsingAddressIdInDao(int aid, String newSname) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address add = session.get(Address.class, aid);
            if (add == null) {
                System.out.println("No Address found with ID: " + aid);
                tx.commit();
                return;
            }

            Student student = add.getStudent();
            if (student == null) {
                System.out.println("No Student linked with Address ID: " + aid);
                tx.commit();
                return;
            }

            student.setSname(newSname);
            tx.commit();
            System.out.println("Student updated successfully using Address ID: " + aid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error updating student using address id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateAddressUsingStudentIdInDao(int sid, String newAname) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, sid);
            if (student == null) {
                System.out.println("No Student found with ID: " + sid);
                tx.commit();
                return;
            }

            Address address = student.getAddress();
            if (address == null) {
                Address newAddress = new Address();
                newAddress.setAname(newAname);
                student.setAddress(newAddress);
                session.saveOrUpdate(student);
                System.out.println("New Address created and linked to Student ID: " + sid);
            } else {
                address.setAname(newAname);
                System.out.println("Address updated for Student ID: " + sid);
            }

            tx.commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error updating address using student id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateAddressUsingAddressIdInDao(int aid, String newAname) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address address = session.get(Address.class, aid);
            if (address == null) {
                System.out.println("No Address found with ID: " + aid);
                tx.commit();
                return;
            }

            address.setAname(newAname);
            tx.commit();
            System.out.println("Address updated successfully. ID: " + aid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error updating address using address id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    // ------------------ Delete ------------------
    @Override
    public void deleteAllDetailsInDao() {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            // Delete all students (cascade to addresses)
            List<Student> students = session.createQuery("from Student", Student.class).list();
            for (Student s : students) {
                session.delete(s);
            }
            session.flush();

            // Delete any orphan addresses
            List<Address> addresses = session.createQuery("from Address", Address.class).list();
            for (Address a : addresses) {
                if (a.getStudent() == null) session.delete(a);
            }

            tx.commit();
            System.out.println("All Student and Address records deleted.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error deleting all details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteStudentUsingStudentIDInDao(int sid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, sid);
            if (student == null) {
                System.out.println("No Student found with ID: " + sid);
                tx.commit();
                return;
            }

            session.delete(student);
            tx.commit();
            System.out.println("Student deleted. ID: " + sid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteStudentUsingAddressIdInDao(int aid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address address = session.get(Address.class, aid);
            if (address == null) {
                System.out.println("No Address found with ID: " + aid);
                tx.commit();
                return;
            }

            Student student = address.getStudent();
            if (student == null) {
                System.out.println("No Student linked with Address ID: " + aid);
                tx.commit();
                return;
            }

            session.delete(student);
            tx.commit();
            System.out.println("Student (linked to Address ID: " + aid + ") deleted.");
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error deleting student by address id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteAddressUsingStudentIdInDao(int sid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, sid);
            if (student == null) {
                System.out.println("No Student found with ID: " + sid);
                tx.commit();
                return;
            }

            Address address = student.getAddress();
            if (address == null) {
                System.out.println("No Address linked with Student ID: " + sid);
                tx.commit();
                return;
            }

            // Unlink then delete
            student.setAddress(null);
            session.update(student);
            session.delete(address);

            tx.commit();
            System.out.println("Address deleted for Student ID: " + sid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error deleting address by student id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteAddressUsingAddressIdInDao(int aid) {
        SessionFactory sf = HibernateConfig.getConnection();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Address address = session.get(Address.class, aid);
            if (address == null) {
                System.out.println("No Address found with ID: " + aid);
                tx.commit();
                return;
            }

            Student student = address.getStudent();
            if (student != null) {
                // unlink both sides safely
                student.setAddress(null);
                address.setStudent(null);
                session.update(student);
            }

            session.delete(address);

            tx.commit();
            System.out.println("Address deleted. ID: " + aid);
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) session.getTransaction().rollback();
            System.err.println("Error deleting address: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
