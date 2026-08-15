import javax.swing.*;

public class bai7 {

    private JPanel panel1;
    private JTextField txtSo1;
    private JTextField txtSo2;
    private JButton btnCong;
    private JButton btnTru;
    private JButton btnNhan;
    private JButton btnChia;
    private JButton btnClear;
    private JLabel lblKetQua;
    private JTextArea txtLichSu;

    public bai7() {

        btnCong.addActionListener(e -> tinhToan("+"));
        btnTru.addActionListener(e -> tinhToan("-"));
        btnNhan.addActionListener(e -> tinhToan("*"));
        btnChia.addActionListener(e -> tinhToan("/"));

        btnClear.addActionListener(e -> {
            txtSo1.setText("");
            txtSo2.setText("");
            lblKetQua.setText("Kết quả: ");
        });
    }

    private void tinhToan(String phepTinh) {

        try {
            double so1 = Double.parseDouble(txtSo1.getText());
            double so2 = Double.parseDouble(txtSo2.getText());

            double ketQua = 0;

            switch (phepTinh) {
                case "+":
                    ketQua = so1 + so2;
                    break;

                case "-":
                    ketQua = so1 - so2;
                    break;

                case "*":
                    ketQua = so1 * so2;
                    break;

                case "/":
                    if (so2 == 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Không thể chia cho 0!"
                        );
                        return;
                    }
                    ketQua = so1 / so2;
                    break;
            }

            lblKetQua.setText("Kết quả: " + ketQua);

            txtLichSu.append(
                    so1 + " " + phepTinh + " " + so2
                            + " = " + ketQua + "\n"
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Vui lòng nhập số hợp lệ!"
            );
        }
    }

    public JPanel getPanel() {
        return panel1;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Máy tính mini");

        bai7 form = new bai7();

        frame.setContentPane(form.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}