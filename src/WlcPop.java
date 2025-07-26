import javax.swing.*;
import java.util.ArrayList;

public class WlcPop extends JFrame {
    ArrayList <String> taskLists = new ArrayList<>();
    public WlcPop() {
        setTitle("To-Do List");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton addTask, viewTask;
        JLabel wlc = new JLabel("To-Do List");
        wlc.setBounds(220, 50, 200, 30);
        JLabel lb = new JLabel("Task Name");
        lb.setBounds(100, 100, 200, 30);
        JTextField taskName = new JTextField();
        taskName.setBounds(180, 100, 200, 30);

        addTask = new JButton("Add Task");
        addTask.setBounds(200, 150, 100, 30);

        viewTask = new JButton("View Task");
        viewTask.setBounds(200, 200, 100, 30);


        addTask.addActionListener(e -> {
            String task = taskName.getText().trim();
            if(!task.isEmpty())
            {
                taskLists.add(task);
                taskName.setText("");
//                JOptionPane.showMessageDialog(null, "Task Added!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Please Enter Task Name");
            }
        });
        viewTask.addActionListener(e -> {
            new TaskList(taskLists);
        });


        add(wlc);
        add(lb);
        add(taskName);
        add(addTask);
        add(viewTask);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
