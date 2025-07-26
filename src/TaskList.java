import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class TaskList extends JFrame {
    private ArrayList<String> taskList ;
    TaskList(ArrayList<String> taskList) {
        this.taskList = taskList;
        setTitle("Your Tasks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        JLabel lblTaskList = new JLabel("Task List");
        lblTaskList.setFont(new Font("Arial", Font.BOLD, 24));
        lblTaskList.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));




        ArrayList<JCheckBox> checkBoxList = new ArrayList<>();


        for (String task : taskList) {
            JCheckBox checkBox = new JCheckBox(task);
            checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(checkBox);
            checkBoxList.add(checkBox);
            checkBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    taskList.remove(task);
                    panel.remove(checkBox);
                    panel.revalidate();
                    panel.repaint();
                }
            });
        }

        add(lblTaskList);
        add(new JScrollPane(panel), BorderLayout.CENTER); // Didn't wrote this first time and took help of AI :(

        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
