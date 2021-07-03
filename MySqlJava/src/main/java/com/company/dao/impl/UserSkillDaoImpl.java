/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nnbak
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        Skill skill = new Skill(skillId, skillName);
        User user = new User(userId);

        return new UserSkill(userSkillId, user, skill, power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT"
                    + "	us.id as userSkillId, "
                    + " u.*,"
                    + "	us.skill_id, s.NAME AS skill_name,"
                    + "	us.power "
                    + "FROM"
                    + "	user_skill us"
                    + "	LEFT JOIN USER u ON us.user_id = u.id"
                    + "	LEFT JOIN skill s ON us.skill_id = s.id "
                    + "WHERE"
                    + "	us.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user_skill (user_id, skill_id, power) values(?,?,?);");

            stmt.setInt(1, u.getUser().getId());
            stmt.setInt(2, u.getSkill().getId());
            stmt.setInt(3, u.getPower());

            b = stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user_skill set skill_id=?, user_id=?, power=? where id=?");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            stmt.setInt(4, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeUserSkill(int id) {

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where id=?;");

            stmt.setInt(1, id);
            System.out.println("id :" + String.valueOf(id));
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
