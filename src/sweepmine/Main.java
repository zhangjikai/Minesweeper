package sweepmine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        final SweepMine frame = new SweepMine("扫雷");

        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (!frame.bon[1].getText().equalsIgnoreCase("0")) {
                    int a = JOptionPane.showConfirmDialog(null, "游戏正在进行，确认退出游戏？",
                            "确认退出", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        frame.record.writeLevel(frame.level);
                        if (frame.level == 3)
                            frame.record.writeLevel4(frame.row, frame.column, frame.mine);
                        System.exit(0);
                    }

                } else {
                    frame.record.writeLevel(frame.level);
                    if (frame.level == 3)
                        frame.record.writeLevel4(frame.row, frame.column, frame.mine);
                    System.exit(0);
                }
            }
        });

    }
}
