/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.NameBirthplace;
import com.company.entity.NameNationality;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nnbak
 */
public  class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        int age = rs.getInt("age");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profileDesc");
        String address = rs.getString("address");
        String number = rs.getString("number");
        Date birthdate = rs.getDate("birthdate");
        String nationalityStr = rs.getString("nationality");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String birthplaceStr = rs.getString("birthplace");

        NameBirthplace nationality = new NameBirthplace(nationalityId, null, nationalityStr);
        NameNationality birthplace = new NameNationality(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, age, email, profileDesc, number, address, birthdate, null, birthplace, nationality);
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {


            String sql = "select "
                    + " u.*, "
                    + "	n.nationality, "
                    + "c.name as birthplace "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id where 1=1 ";
            if(name!=null && !name.trim().isEmpty()){
                sql += " and u.name=? ";
            }

            if(surname!=null && !surname.trim().isEmpty()){
                sql += " and u.surname=? ";
            }

            if(nationalityId!=null){
                sql += " and u.nationality_id=? ";
            }

            PreparedStatement stmt = c.prepareStatement(sql);

            int i=1;
            if(name!=null && !name.trim().isEmpty()){
                stmt.setString(i, name);
                i++;
            }

            if(surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i, surname);
                i++;
            }

            if(nationalityId!=null){
                stmt.setInt(i, nationalityId);
            }

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,age=?,email=?,profileDesc=?,number=?,birthdate=?,address=?,birthplace_id=?,nationality_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setInt(3, u.getAge());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getNumber());
            stmt.setDate(7, u.getBirthdate());
            stmt.setString(8, u.getAddress());
            stmt.setInt(9, u.getBirthplace().getId());
            stmt.setInt(10, u.getNationality().getId());
            stmt.setInt(11, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select "
                    + " u.*, "
                    + "	n.nationality, "
                    + " c.name as birthplace "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                result = getUser(rs);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,age,email,number,profileDesc,getAddress) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setInt(3, u.getAge());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getNumber());
            stmt.setString(7, u.getAddress());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
