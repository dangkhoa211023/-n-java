package View;

import DAO.LoginDao;
import Model.Taikhoan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JLabel  lbUser, lbpassword;
    private JTextField tfUser, tfpassword;
    private JButton btnSingnUp, btnSingIn;
    public  Login ()
    {
        lbUser = new JLabel( "Tài khoản");
        lbpassword = new JLabel("Mật Khẩu");
        tfUser = new JTextField();
        tfpassword = new JTextField();
        btnSingIn = new JButton( "Đăng nhập");
        btnSingnUp = new JButton("Đăng kí");
        lbUser.setBounds(36, 69, 176, 41);
        tfUser.setBounds(250, 69 ,314, 42);
        lbpassword.setBounds(36, 170, 160, 40);
        tfpassword.setBounds(250, 170, 314, 42);
        btnSingIn.setBounds(144, 304, 119, 43);
        btnSingnUp.setBounds(330, 304, 119, 43);
        btnSingnUp.addActionListener(this);
        btnSingIn.addActionListener(this);
        this.add(lbUser); this.add(lbpassword);
        this.add(tfUser); this.add(tfpassword);
        this.add(btnSingnUp);
        this.add(btnSingIn);
        this.setLayout(null);
        this.setTitle("Login quản lí ký túc xá");
        this.setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void dangnhap()
    {

        Taikhoan taikhoan= LoginDao.getData(tfUser.getText(),tfpassword.getText()) ;

        if(taikhoan==null)
        {
            JOptionPane.showMessageDialog(this, "Tài khoản và mật khẩu không đúng");

        }else{
            new QuanLiView();
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSingIn){
            dangnhap();
            this.dispose();
        }
    }
}

