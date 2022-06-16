package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;

public class PreferenceBean implements ObservableBean {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);
    private String prezdivka;
    private String oblibenaBarva;


    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        String oldValue = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("prezdivka", oldValue, prezdivka);
    }

    public String getOblibenaBarva() {
        return oblibenaBarva;
    }

    public void setOblibenaBarva(String oblibenaBarva) {
        String oldValue = this.prezdivka;
        this.oblibenaBarva = oblibenaBarva;
        pcs.firePropertyChange("oblibena barva", oldValue, oblibenaBarva);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

