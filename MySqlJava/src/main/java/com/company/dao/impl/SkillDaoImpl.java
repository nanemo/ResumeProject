    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package com.company.dao.impl;

    import com.company.dao.inter.AbstractDAO;
    import com.company.dao.inter.SkillDaoInter;
    import com.company.entity.Skill;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;

    /**
     * @author nnbak
     */
    public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

        private Skill getSkill(ResultSet rs) throws Exception {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            Skill skill = new Skill(id, name);

            return skill;
        }

        @Override
        public List<Skill> getAll() {
            List<Skill> result = new ArrayList<>();
            try (Connection c = connect()) {

                Statement stmt = c.createStatement();
                stmt.execute("select * from skill");
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    Skill s = getSkill(rs);
                    result.add(s);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return result;
        }

        @Override
        public Skill getById(int skillId) {
            Skill s = null;
            try (Connection c = connect()) {
                PreparedStatement stmt = c.prepareStatement("select * from skill where id=?");
                stmt.setInt(1, skillId);
                stmt.execute();

                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    s = getSkill(rs);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return s;
        }

        @Override
        public boolean updateSkill(Skill s) {
            try (Connection c = connect()) {
                PreparedStatement stmt = c.prepareStatement("update skill set name=? where id=?");
                stmt.setString(1, s.getName());
                stmt.setInt(2, s.getId());
                return stmt.execute();
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }

        @Override
        public boolean removeSkill(int id) {
            Skill result = null;
            try (Connection c = connect()) {
                Statement stmt = c.createStatement();
                return stmt.execute("delete from skill where id=" + id);
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }

        @Override
        public boolean addSkill(Skill s) {
            boolean b = true;
            try (Connection c = connect()) {
                PreparedStatement stmt = c.prepareStatement("insert into skill(name) values (?)", Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, s.getName());
                b = stmt.execute();

                ResultSet generatedKeys = stmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    s.setId(generatedKeys.getInt(1));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                b = false;
            }
            return b;
        }

    }
