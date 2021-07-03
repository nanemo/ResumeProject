/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Country;
import com.company.entity.NameBirthplace;
import com.company.entity.NameNationality;

import java.util.List;

/**
 * @author nnbak
 */
public interface CountryDaoInter {

    public List<Country> getAll();
    
    public List<NameBirthplace> getAllBirthplace();

    public List<NameNationality> getAllNationality();
    
    public Country getById(int id);

    public boolean updateCountry(Country u);

    public boolean removeCountry(int id);

    public boolean addCountry(Country u);


}
