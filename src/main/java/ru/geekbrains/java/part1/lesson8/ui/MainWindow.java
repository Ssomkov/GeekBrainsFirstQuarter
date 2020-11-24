package ru.geekbrains.java.part1.lesson8.ui;

import com.sun.java.swing.action.ExitAction;
import ru.geekbrains.java.part1.lesson8.model.Cat;
import ru.geekbrains.java.part1.lesson8.utils.Handler;

import javax.swing.*;

public class MainWindow extends JFrame {

    private Handler handler;
    private JTextArea jTextArea;

    public MainWindow() {
        setBounds(500, 500, 500, 300);
        setResizable(false);
        setTitle("Lesson8");
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(createFileMenu());
        setJMenuBar(jMenuBar);
        jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        add(jScrollPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        handler = new Handler();
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("Меню");

        JMenuItem createCats = new JMenuItem("Создать котов");
        JMenuItem createPlate = new JMenuItem("Создать тарелку");
        JMenuItem goEat = new JMenuItem("Накормить котов");
        JMenuItem exit = new JMenuItem(new ExitAction());

        file.add(createCats);
        file.add(createPlate);
        file.add(goEat);
        file.addSeparator();
        file.add(exit);

        createCats.addActionListener(arg0 -> {
            handler.generateCats();
            updateInfoInTextArea("Cats was created:\n");
            for (Cat cat : handler.getCatList()) {
                updateInfoInTextArea(cat.toString() + "\n");
            }
        });

        createPlate.addActionListener(arg0 -> {
            handler.generateFood();
            updateInfoInTextArea(String.format("Food was added: %d\n", handler.getPlate().getFood()));
        });

        goEat.addActionListener(arg0 -> updateInfoInTextArea(handler.goEat()));

        exit.addActionListener(arg0 -> System.exit(0));

        return file;
    }

    public void updateInfoInTextArea(String value) {
        jTextArea.append(value);
    }
}
