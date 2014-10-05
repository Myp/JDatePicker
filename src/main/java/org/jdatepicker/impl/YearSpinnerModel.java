package org.jdatepicker.impl;

import org.jdatepicker.CalendarModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.HashSet;

public class YearSpinnerModel implements SpinnerModel {
    private HashSet<ChangeListener> spinnerChangeListeners;
    private CalendarModel<?> model;

    public void notifyListeners(){
        //Update year spinner
        for (ChangeListener cl : spinnerChangeListeners) {
            cl.stateChanged(new ChangeEvent(this));
        }
    }


    public YearSpinnerModel(CalendarModel<?> model) {
        this.spinnerChangeListeners = new HashSet<ChangeListener>();
        this.model = model;
    }

    /**
     * Part of SpinnerModel, year
     */
    public void addChangeListener(ChangeListener arg0) {
        spinnerChangeListeners.add(arg0);
    }

    /**
     * Part of SpinnerModel, year
     */
    public void removeChangeListener(ChangeListener arg0) {
        spinnerChangeListeners.remove(arg0);
    }

    /**
     * Part of SpinnerModel, year
     */
    public Object getNextValue() {
        return Integer.toString(model.getYear() + 1);
    }

    /**
     * Part of SpinnerModel, year
     */
    public Object getPreviousValue() {
        return Integer.toString(model.getYear() - 1);
    }

    /**
     * Part of SpinnerModel, year
     */
    public void setValue(Object text) {
        model.setYear(new Integer((String)text));
    }

    /**
     * Part of SpinnerModel, year
     */
    public Object getValue() {
        return Integer.toString(model.getYear());
    }

}
