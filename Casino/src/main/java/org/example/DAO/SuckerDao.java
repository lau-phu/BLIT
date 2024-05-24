package org.example.DAO;


import org.example.Entities.Sucker;

import java.util.List;

public interface SuckerDao {

    //CRUD - Create, Read, Update, Delete

    public int insertSucker();

    int insertSucker(Sucker sucker);

    public List<Sucker> getAllSuckers();
    public int updateSucker(int id, Sucker updateSucker);
    public int deleteSucker(int id);
}
