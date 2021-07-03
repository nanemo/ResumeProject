/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.NameBirthplace;
import com.company.entity.NameNationality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nnbak
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        Country birthplace = new Country(id, name, nationality);

        return birthplace;
    }
    
    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country u = getCountry(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
    
    private NameNationality getNationality(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        NameNationality nameNationality = new NameNationality(id, null, nationality);

        return nameNationality;
    }
    
    @Override
    public List<NameNationality> getAllNationality() {
        List<NameNationality> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                NameNationality u = getNationality(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
    
    private NameBirthplace getBirthplace(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        NameBirthplace nameBirthplace = new NameBirthplace(id, name, nationality);

        return nameBirthplace;
    }
    
     @Override
    public List<NameBirthplace> getAllBirthplace() {
        List<NameBirthplace> result = new ArrayList<>();
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                NameBirthplace u = getBirthplace(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public Country getById(int userId) {
        Country u = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from country where id=?");
            stmt.setInt(1, userId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                u = getCountry(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean updateCountry(Country u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update country set name=?,nationality=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getNationality());
            stmt.setInt(3, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(int id) {
        Country result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from country where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCountry(Country u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into country(id,name,nationality) values (?,?,?)");
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getNationality());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

   

}
