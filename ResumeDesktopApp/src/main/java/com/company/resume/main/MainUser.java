package com.company.resume.main;

import com.company.resume.config.Config;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

public class MainUser extends javax.swing.JFrame {

    private UserDaoInter userDao = Context.instanceUserDao();

    public MainUser() {
        Config.loggedInUser = userDao.getById(1);
        initComponents();
        fillUserComponents();

        panelDetails.fillUserComponents();
        panelProfile.fillUserComponents();
        panelSkills.fillUserComponents();
    }

    public void fillUserComponents() {
        User loggedInUser = Config.loggedInUser;
        txtName.setText(loggedInUser.getName());
        txtSurname.setText(loggedInUser.getSurname());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        pnlUserInfo = new javax.swing.JPanel();
        lblSurname = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        tpUserInfo = new javax.swing.JTabbedPane();
        pnlDetails = new javax.swing.JPanel();
        panelDetails = new com.company.resume.panel.DetailsPanel();
        pnlProfile = new javax.swing.JPanel();
        panelProfile = new com.company.resume.panel.ProfilePanel();
        pnlSkills = new javax.swing.JPanel();
        panelSkills = new com.company.resume.panel.SkillsPanel();
        pnlHistory = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSurname.setText("Surname");

        lblName.setText("Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserInfoLayout = new javax.swing.GroupLayout(pnlUserInfo);
        pnlUserInfo.setLayout(pnlUserInfoLayout);
        pnlUserInfoLayout.setHorizontalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlUserInfoLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(27, 27, 27))))
        );
        pnlUserInfoLayout.setVerticalGroup(
            pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        tpUserInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tpUserInfo.setToolTipText("");
        tpUserInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.lightGray, null, null));
        pnlDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDetails.setPreferredSize(new java.awt.Dimension(621, 391));

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Details", pnlDetails);

        pnlProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.lightGray, null, null));
        pnlProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlProfile.setDoubleBuffered(false);
        pnlProfile.setPreferredSize(new java.awt.Dimension(621, 391));

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        tpUserInfo.addTab("Profile", pnlProfile);

        pnlSkills.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.lightGray, null, null));
        pnlSkills.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSkills.setPreferredSize(new java.awt.Dimension(621, 391));

        javax.swing.GroupLayout pnlSkillsLayout = new javax.swing.GroupLayout(pnlSkills);
        pnlSkills.setLayout(pnlSkillsLayout);
        pnlSkillsLayout.setHorizontalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        pnlSkillsLayout.setVerticalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addComponent(panelSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tpUserInfo.addTab("Skills", pnlSkills);

        pnlHistory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.lightGray, null, null));
        pnlHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlHistory.setPreferredSize(new java.awt.Dimension(621, 391));

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        tpUserInfo.addTab("Employement History", pnlHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 324, Short.MAX_VALUE))
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpUserInfo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSurnameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        String surname = txtSurname.getText();

        User user = Config.loggedInUser;
        user.setName(name);
        user.setSurname(surname);

        panelProfile.fillUser(user);
        panelDetails.fillUser(user);

        userDao.updateUser(user);
    }//GEN-LAST:event_btnSaveActionPerformed


    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private com.company.resume.panel.DetailsPanel panelDetails;
    private com.company.resume.panel.ProfilePanel panelProfile;
    private com.company.resume.panel.SkillsPanel panelSkills;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlSkills;
    private javax.swing.JPanel pnlUserInfo;
    private javax.swing.JTabbedPane tpUserInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables

}