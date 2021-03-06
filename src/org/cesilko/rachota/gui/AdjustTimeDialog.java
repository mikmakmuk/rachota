/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://rachota.sourceforge.net/license.txt.
 * 
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://rachota.sourceforge.net/license.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * The Original Software is Rachota.
 * The Initial Developer of the Original Software is Jiri Kovalsky
 * Portions created by Jiri Kovalsky are Copyright (C) 2006
 * All Rights Reserved.
 *
 * Contributor(s): Jiri Kovalsky
 * Created on January 27, 2009  8:05 AM
 * AdjustTimeDialog.java
 */

package org.cesilko.rachota.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import org.cesilko.rachota.core.Task;
import org.cesilko.rachota.core.Translator;

/** Dialog for user friendly setting up start/end day time.
 * @author Jiri Kovalsky
 */
public class AdjustTimeDialog extends javax.swing.JDialog {
    
    /** Creates new dialog for time selection and presets hours and minutes 
     * @param parent Parent window that invoked this dialog.
     * @parent title String that should be used as a title of this dialog.
     * @param task Source task whose time will be preset in the dialog.
     */
    public AdjustTimeDialog(Frame parent, String title, Task task) {
        this(parent, title);
        String shortDuration = Tools.getTimeShort(task.getDuration());
        Integer hours = new Integer(shortDuration.substring(0, 2));
        Integer minutes = new Integer(shortDuration.substring(3, 5));
        spHours.setValue(hours);
        spMinutes.setValue(minutes);
        this.task = task;
    }
    
    /** Creates new dialog for time selection and presets hours and minutes
     * @param parent Parent window that invoked this dialog.
     * @parent title String that should be used as a title of this dialog.
     * @param hours Number of hours to be preset in the dialog.
     * @param minutes Number of minutes to be preset in the dialog.
     */
    public AdjustTimeDialog(Frame parent, String title, int hours, int minutes) {
        this(parent, title);
        spHours.setValue(new Integer(hours));
        spMinutes.setValue(new Integer(minutes));
    }

    /** Creates new dialog for time selection.
     * @param parent Parent window that invoked this dialog.
     * @parent title String that should be used as a title of this dialog.
     */
    public AdjustTimeDialog(Frame parent, String title) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(parent);
        Dimension size = spHours.getPreferredSize();
        spHours.setPreferredSize(new Dimension((int) size.getWidth()*2, (int) size.getHeight()));
        spMinutes.setPreferredSize(new Dimension((int) size.getWidth()*2, (int) size.getHeight()));
        Tools.setupSelectAllListener(spHours);
        Tools.setupSelectAllListener(spMinutes);
        getRootPane().setDefaultButton(btOK);
        pack();
    }
    
    /** Returns font that should be used for all widgets in this component
     * based on the language preferences specified by user.
     * @return Font to be used in this component.
     */
    public java.awt.Font getFont() {
        return Tools.getFont();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbSelectTime = new javax.swing.JLabel();
        spHours = new javax.swing.JSpinner();
        lbColumn1 = new javax.swing.JLabel();
        spMinutes = new javax.swing.JSpinner();
        pnButtons = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lbSelectTime.setDisplayedMnemonic(Translator.getMnemonic("ADJUSTTIMEDIALOG.SET_TIME"));
        lbSelectTime.setFont(getFont());
        lbSelectTime.setLabelFor(spHours);
        lbSelectTime.setText(Translator.getTranslation("ADJUSTTIMEDIALOG.SET_TIME"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(lbSelectTime, gridBagConstraints);

        spHours.setFont(getFont());
        spHours.setToolTipText(Translator.getTranslation("MOVETIMEDIALOG.HOURS_TOOLTIP"));
        spHours.setMinimumSize(new java.awt.Dimension(40, 20));
        spHours.setPreferredSize(new java.awt.Dimension(40, 20));
        spHours.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spHoursStateChanged(evt);
            }
        });
        spHours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spHoursKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(spHours, gridBagConstraints);

        lbColumn1.setText(":");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        getContentPane().add(lbColumn1, gridBagConstraints);

        spMinutes.setFont(getFont());
        spMinutes.setToolTipText(Translator.getTranslation("MOVETIMEDIALOG.MINUTES_TOOLTIP"));
        spMinutes.setMinimumSize(new java.awt.Dimension(40, 20));
        spMinutes.setPreferredSize(new java.awt.Dimension(40, 20));
        spMinutes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spMinutesStateChanged(evt);
            }
        });
        spMinutes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spMinutesKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(spMinutes, gridBagConstraints);

        btOK.setFont(getFont());
        btOK.setMnemonic(Translator.getMnemonic("ADJUSTTIMEDIALOG.BT_OK"));
        btOK.setText(Translator.getTranslation("ADJUSTTIMEDIALOG.BT_OK"));
        btOK.setToolTipText(Translator.getTranslation("ADJUSTTIMEDIALOG.BT_OK_TOOLTIP"));
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });
        pnButtons.add(btOK);

        btCancel.setFont(getFont());
        btCancel.setMnemonic(Translator.getMnemonic("ADJUSTTIMEDIALOG.BT_CANCEL"));
        btCancel.setText(Translator.getTranslation("ADJUSTTIMEDIALOG.BT_CANCEL"));
        btCancel.setToolTipText(Translator.getTranslation("ADJUSTTIMEDIALOG.BT_CANCEL_TOOLTIP"));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        pnButtons.add(btCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        getContentPane().add(pnButtons, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void spMinutesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spMinutesKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        btOKActionPerformed(null);
    if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        btCancelActionPerformed(null);
}//GEN-LAST:event_spMinutesKeyPressed

private void spHoursKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spHoursKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        btOKActionPerformed(null);
    if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        btCancelActionPerformed(null);
}//GEN-LAST:event_spHoursKeyPressed

    /** Method called when minutes were be changed.
     * @param evt Event that invoked this method call.
     */
    private void spMinutesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spMinutesStateChanged
        Integer minutes = (Integer) spMinutes.getValue();//GEN-HEADEREND:event_spMinutesStateChanged
        int value = minutes.intValue();
        if ((value < 0) || (value > 59)) spMinutes.setValue(previousMinutes);
    }//GEN-LAST:event_spMinutesStateChanged
    
    /** Method called when hours were be changed.
     * @param evt Event that invoked this method call.
     */
    private void spHoursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spHoursStateChanged
        Integer hours = (Integer) spHours.getValue();//GEN-HEADEREND:event_spHoursStateChanged
        int value = hours.intValue();
        if ((value < 0) || (value > 23)) spHours.setValue(previousHours);
    }//GEN-LAST:event_spHoursStateChanged
    
    /** Method called when cancel button was pressed.
     * @param evt Event that invoked this method call.
     */
    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        setVisible(false);//GEN-HEADEREND:event_btCancelActionPerformed
    }//GEN-LAST:event_btCancelActionPerformed
    
    /** Method called when ok button was pressed.
     * @param evt Event that invoked this method call.
     */
    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        setVisible(false);//GEN-HEADEREND:event_btOKActionPerformed
        Integer hours = (Integer) spHours.getValue();
        Integer minutes = (Integer) spMinutes.getValue();
        if (task == null) {
            String newTime = "" + minutes.toString();
            if (minutes.intValue() < 10) newTime = "0" + newTime;
            newTime = hours.toString() + ":" + newTime;
            if (hours.intValue() < 10) newTime = "0" + newTime;
            firePropertyChange("time_adjusted", null, newTime);
        } else {
            long newDuration = hours.intValue()*3600 + minutes.intValue()*60;
            task.setDuration(newDuration*1000);
            if (newDuration == 0) task.setState(Task.STATE_NEW);
            else if (task.getState() == Task.STATE_NEW) task.setState(Task.STATE_STARTED);
            firePropertyChange("duration_corrected", null, null);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        Tools.recordActivity();
    }//GEN-LAST:event_formMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel lbColumn1;
    private javax.swing.JLabel lbSelectTime;
    private javax.swing.JPanel pnButtons;
    private javax.swing.JSpinner spHours;
    private javax.swing.JSpinner spMinutes;
    // End of variables declaration//GEN-END:variables
    /** Last correct value of hours specified by user. */
    private Integer previousHours = new Integer(0);
    /** Last correct value of minutes specified by user. */
    private Integer previousMinutes = new Integer(0);
    /** Task whose time should be edited. */
    private Task task = null;
}
