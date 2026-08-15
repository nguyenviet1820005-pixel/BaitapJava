import javax.swing.*;

public class bai6 {
    private JPanel panel1;
    private JTextField txtTaiKhoan;
    private JPasswordField txtMatKhau;
    private JComboBox<String> cboLoaiTaiKhoan;
    private JCheckBox chkGhiNho;
    private JButton btnDangNhap;
    private JLabel lblKetQua;

    public bai6() {

        cboLoaiTaiKhoan.addItem("Sinh viên");
        cboLoaiTaiKhoan.addItem("Giảng viên");
        cboLoaiTaiKhoan.addItem("Quản trị viên");

        btnDangNhap.addActionListener(e -> {

            String taiKhoan = txtTaiKhoan.getText();
            String matKhau = new String(txtMatKhau.getPassword());

            String loaiTaiKhoan =
                    (String) cboLoaiTaiKhoan.getSelectedItem();

            if (taiKhoan.equals("admin") && matKhau.equals("123456")) {

                lblKetQua.setText("Đăng nhập thành công!");

                JOptionPane.showMessageDialog(
                        panel1,
                        "Đăng nhập thành công!\n"
                                + "Tài khoản: " + taiKhoan + "\n"
                                + "Loại tài khoản: " + loaiTaiKhoan
                );

            } else {

                lblKetQua.setText("Sai tài khoản hoặc mật khẩu!");

                JOptionPane.showMessageDialog(
                        panel1,
                        "Sai tài khoản hoặc mật khẩu!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            if (chkGhiNho.isSelected()) {
                System.out.println("Đã chọn ghi nhớ tài khoản");
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Form đăng nhập");

        bai6 bai6 = new bai6();

        frame.setContentPane(bai6.panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 250);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}