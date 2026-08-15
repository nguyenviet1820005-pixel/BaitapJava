import javax.swing.*;

public class bai5 {
    private JPanel panel1;
    private JTextField txtN;
    private JButton btnHienThi;
    private JTextArea txtResult;

    public bai5() {
        btnHienThi.addActionListener(e -> hienThiFibonacci());
    }

    private void hienThiFibonacci() {
        try {
            int n = Integer.parseInt(txtN.getText());

            if (n <= 0) {
                JOptionPane.showMessageDialog(null, "n phải lớn hơn 0!");
                return;
            }

            long a = 0;
            long b = 1;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(a).append(" ");

                long c = a + b;
                a = b;
                b = c;
            }

            txtResult.setText(sb.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên!");
        }
    }

    public JPanel getPanel() {
        return panel1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bài 5 - Fibonacci");

        bai5 form = new bai5();

        frame.setContentPane(form.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}