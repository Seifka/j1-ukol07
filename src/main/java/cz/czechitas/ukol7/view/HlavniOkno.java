package cz.czechitas.ukol7.view;


import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.Barvy;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Oblíbená barva");
        this.controller = controller;
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:75:250,grow,fill]unrel[right]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));


        FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
                .label("Přezdívka")
                .textField("prezdivka")
                .add();

        formBuilder
                .label("&Oblibená barva")

                .radioButton("Bílá", "Barvy", Barvy.bílá.toString())
                .add("left, span")

                .radioButton("Zelená", "Barvy", Barvy.zelená.toString())
                .add("left, span")

                .radioButton("Modrá", "Barvy", Barvy.modrá.toString())
                .add("left, span")

                .radioButton("Fialová", "Barvy", Barvy.fialová.toString())
                .add("left, span")

                .radioButton("Žlutá", "Barvy", Barvy.žlutá.toString())
                .add("left, span");


        formBuilder
                .panel(panel -> {
                    JButton ulozitButton = new JButton(controller.getUlozitAction());

                    getRootPane().setDefaultButton(ulozitButton);

                    panel.add(ulozitButton);
                })
                .add("right, span");

        pack();
    }


}