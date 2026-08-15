import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class bai8 {

    private JPanel panel1;

    private JTextField txtMaSV;
    private JTextField txtHoTen;
    private JTextField txtTuoi;
    private JTextField txtLop;

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnLamMoi;

    private JTable tableSinhVien;

    private DefaultTableModel model;

    public bai8() {

        // Tạo model cho JTable
        model = new DefaultTableModel(
                new Object[]{"Mã SV", "Họ tên", "Tuổi", "Lớp"}, 0
        );

        tableSinhVien.setModel(model);

        // Nút thêm
        btnThem.addActionListener(e -> themSinhVien());

        // Nút sửa
        btnSua.addActionListener(e -> suaSinhVien());

        // Nút xóa
        btnXoa.addActionListener(e -> xoaSinhVien());

        // Nút làm mới
        btnLamMoi.addActionListener(e -> lamMoi());

        // Khi click vào một dòng
        tableSinhVien.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                hienThiThongTin();
            }
        });
    }

    // ================= THÊM =================

    private void themSinhVien() {

        try {
            String maSV = txtMaSV.getText().trim();
            String hoTen = txtHoTen.getText().trim();
            String lop = txtLop.getText().trim();

            if (maSV.isEmpty() || hoTen.isEmpty() || txtTuoi.getText().isEmpty()
                    || lop.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Vui lòng nhập đầy đủ thông tin!"
                );
                return;
            }

            int tuoi = Integer.parseInt(txtTuoi.getText());

            model.addRow(new Object[]{
                    maSV,
                    hoTen,
                    tuoi,
                    lop
            });

            JOptionPane.showMessageDialog(
                    null,
                    "Thêm sinh viên thành công!"
            );

            lamMoi();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Tuổi phải là số!"
            );
        }
    }

    // ================= SỬA =================

    private void suaSinhVien() {

        int row = tableSinhVien.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Vui lòng chọn sinh viên cần sửa!"
            );
            return;
        }

        try {
            String maSV = txtMaSV.getText().trim();
            String hoTen = txtHoTen.getText().trim();
            int tuoi = Integer.parseInt(txtTuoi.getText());
            String lop = txtLop.getText().trim();

            model.setValueAt(maSV, row, 0);
            model.setValueAt(hoTen, row, 1);
            model.setValueAt(tuoi, row, 2);
            model.setValueAt(lop, row, 3);

            JOptionPane.showMessageDialog(
                    null,
                    "Sửa sinh viên thành công!"
            );

            lamMoi();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Tuổi phải là số!"
            );
        }
    }

    // ================= XÓA =================

    private void xoaSinhVien() {

        int row = tableSinhVien.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Vui lòng chọn sinh viên cần xóa!"
            );
            return;
        }

        int result = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn xóa sinh viên này?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {

            model.removeRow(row);

            JOptionPane.showMessageDialog(
                    null,
                    "Xóa thành công!"
            );

            lamMoi();
        }
    }

    // ================= HIỂN THỊ =================

    private void hienThiThongTin() {

        int row = tableSinhVien.getSelectedRow();

        if (row != -1) {

            txtMaSV.setText(
                    model.getValueAt(row, 0).toString()
            );

            txtHoTen.setText(
                    model.getValueAt(row, 1).toString()
            );

            txtTuoi.setText(
                    model.getValueAt(row, 2).toString()
            );

            txtLop.setText(
                    model.getValueAt(row, 3).toString()
            );
        }
    }

    // ================= LÀM MỚI =================

    private void lamMoi() {

        txtMaSV.setText("");
        txtHoTen.setText("");
        txtTuoi.setText("");
        txtLop.setText("");

        tableSinhVien.clearSelection();
    }

    public JPanel getPanel() {
        return panel1;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        JFrame frame = new JFrame("Quản lý sinh viên");

        bai8 form = new bai8();

        frame.setContentPane(form.getPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}