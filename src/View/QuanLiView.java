package View;

import DAO.Datahepler;
import DAO.QuanliDao;
import Model.KTX;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLiView extends JFrame implements ActionListener, MouseListener {
    private JPanel pn1, pn2, pn3;
    private JLabel lbMaSv, lbName, lbLop, lbSdt, lbSoPhong, lbTinhTrang;
    private JTextField tfMaSv, tfName, tfLop, tfSdt, tfSoPhong, tfTinhTrang, tfFind;
    private JButton btnAdd;
    private  JButton btnDelete;
    private  JButton btnEdit;
    private  JButton btnReset;
    private  JButton btnFind;

    private JScrollPane scrollPane;
    private static DefaultTableModel tableModel;
    private JTable table;

    QuanliDao modify = new QuanliDao();

    public QuanLiView(){
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        lbMaSv = new JLabel("Ma sinh vien");
        lbName = new JLabel("Ten sinh vien");
        lbLop = new JLabel("Lop");
        lbSdt = new JLabel("So dien thoai");
        lbSoPhong = new JLabel("So phong");
        lbTinhTrang = new JLabel("Tinh trang");
        tfMaSv = new JTextField();
        tfName = new JTextField();
        tfLop = new JTextField();
        tfSoPhong = new JTextField();
        tfTinhTrang = new JTextField();
        tfSdt = new JTextField();
        tfFind = new JTextField();
        btnAdd = new JButton("Them");
        btnEdit = new JButton("Sua");
        btnDelete = new JButton("Xoa");
        btnReset = new JButton("Lam moi");
        btnFind = new JButton("Tim kiem");

        scrollPane = new JScrollPane();
        table = new JTable();
        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[] {"Ma SV", "Ho va ten", "Lop", "So dien thoai ", "So phong", "Tinh trang"});
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        lbMaSv.setBounds(10, 43, 100, 35);
        lbName.setBounds(10, 103, 100, 35);
        lbLop.setBounds(10, 163, 100, 35);
        lbSdt.setBounds(10, 223, 100, 35);
        lbSoPhong.setBounds(10, 282, 100, 35);
        lbTinhTrang.setBounds(10, 343, 100, 35);


        tfMaSv.setBounds(125, 43, 220, 34);
        tfName.setBounds(125, 103, 220, 34);
        tfLop.setBounds(125, 163, 220, 34);
        tfSdt.setBounds(125, 223, 220, 34);
        tfSoPhong.setBounds(125, 282, 220, 34);
        tfTinhTrang.setBounds(125, 343, 220, 35);
        tfFind.setBounds(170,500,160,35);

        btnAdd.setBounds(40,400,100,35);
        btnEdit.setBounds(200,400,100,35);
        btnDelete.setBounds(40,450,100,35);
        btnReset.setBounds(200,450,100,35);
        btnFind.setBounds(40,500,100,35);

        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnFind.addActionListener(this);
        btnReset.addActionListener(this);
        btnDelete.addActionListener(this);
        table.addMouseListener(this);

        pn1.setLayout(null);
        pn1.setBorder(BorderFactory.createTitledBorder("Nhap thong tin"));
        pn1.setBounds(0,5,360,560);
        pn1.add(lbMaSv);
        pn1.add(lbName);
        pn1.add(lbLop);
        pn1.add(lbSdt);
        pn1.add(lbSoPhong);
        pn1.add(lbTinhTrang);
        pn1.add(tfMaSv);
        pn1.add(tfName);
        pn1.add(tfLop);
        pn1.add(tfSdt);
        pn1.add(tfSoPhong);
        pn1.add(tfTinhTrang);
        pn1.add(tfFind);
        pn1.add(btnAdd);
        pn1.add(btnDelete);
        pn1.add(btnEdit);
        pn1.add(btnReset);
        pn1.add(btnFind);

        pn2.setLayout(new BorderLayout());
        pn2.setBounds(360, 50, 820, 500);
        pn2.add(scrollPane, BorderLayout.CENTER);
        pn2.add(pn3, BorderLayout.SOUTH);

        loadTable();

        this.add(pn1);
        this.add(pn2);


        this.setBounds(150, 100, 1200, 600);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);


    }
    public void loadTable(){
        try{
            Connection connection = Datahepler.openConnection();
            String sql = "select * from KTX";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            tableModel.setRowCount(0);
            while(rs.next()){
                String[] row;
                row = new String[]{
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        String.valueOf(rs.getInt(4)),rs.getString(5),rs.getString(6)
                };
                tableModel.addRow(row);
            }
            connection.close();
            statement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public  static  int rowCount()
    {
        return tableModel.getRowCount()+1;

    }
    public  void  AddList(){
        KTX ktx = new KTX();
        ktx.setMasv(tfMaSv.getText());
        ktx.setName(tfName.getText());
        ktx.setLop(tfLop.getText());
        ktx.setSdt(Integer.parseInt(tfSdt.getText()));
        ktx.setSophong(tfSoPhong.getText());
        ktx.setTinhtrang(tfTinhTrang.getText());
        modify.Add(ktx);
        loadTable();
    }
    public  void  EditList()
    {
        KTX ktx = new KTX();
        ktx.setMasv(tfMaSv.getText());
        ktx.setName(tfName.getText());
        ktx.setLop(tfLop.getText());
        ktx.setSdt(Integer.parseInt(tfSdt.getText()));
        ktx.setSophong(tfSoPhong.getText());
        ktx.setTinhtrang(tfTinhTrang.getText());
        modify.Edit(ktx);
        loadTable();


    }

    public  void  delete(){
        String masv = tfMaSv.getText();
        modify.delete(masv);
        loadTable();
    }
    public  void  reset(){
        loadTable();
        tfMaSv.setText("");
        tfName.setText("");
        tfLop.setText("");
        tfSdt.setText("");
        tfSoPhong.setText("");
        tfTinhTrang.setText("");
    }
    public  void findName(){
        String name =tfFind.getText();
        if(name.equals(""))
            JOptionPane.showMessageDialog(this,"Ban chua nhap du lieu");
        else {
            List<KTX> list = new ArrayList<>();
            list = modify.getByName(name);
            tableModel.setRowCount(0);
            for(KTX ktx : list){
                tableModel.addRow(new Object[]{ktx.getMasv(),ktx.getName(),ktx.getLop(),ktx.getLop(),ktx.getSdt(),ktx.getSophong(),ktx.getTinhtrang()});


            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd)
            AddList();
        if(e.getSource()==btnEdit)
        {
            EditList();
        }
        if(e.getSource()==btnDelete)
        {
            delete();
        }
        if(e.getSource()==btnReset)
            reset();

        if(e.getSource()==btnFind)
            findName();

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int id = table.rowAtPoint(e.getPoint());
        String selectRow = tableModel.getValueAt(id, 0).toString();
        KTX ktx = null;
        ktx = modify.getBYID((selectRow));
        tfMaSv.setText(String.valueOf(ktx.getMasv()));
        tfName.setText(ktx.getName());
        tfLop.setText(String.valueOf(ktx.getLop()));
        tfSdt.setText(String.valueOf(ktx.getSdt()));
        tfSoPhong.setText(String.valueOf(ktx.getSophong()));
        tfTinhTrang.setText(String.valueOf(ktx.getTinhtrang()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}