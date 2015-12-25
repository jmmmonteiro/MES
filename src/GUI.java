import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI {

	private JFrame frame;
	Interface inter=Interface.getInstance();
	private JTextField txtHoraDeChegada;
	private JTextField txtHoraDeChegada_1;
	private JTextField txtHoraDeChegada_2;
	private JTextField txtClula;
	private JTextField txtMquinaA;
	private JTextField txtMquinaC;
	private JTextField txtP;
	private JTextField txtP_1;
	private JTextField txtP_2;
	private JTextField txtTs;
	private JTextField txtTotal;
	private JTextField textField_4;
	private JTextField txtP_3;
	private JTextField txtP_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtClula_1;
	private JTextField textField_3;
	private JTextField txtMquinaB;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField txtP_5;
	private JTextField txtP_6;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField txtClula_2;
	private JTextField textField_5;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField txtClula_3;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField txtTotalDePeas;
	private JPanel panel;
	private JTextField txtTotalDePeas_1;
	private JTextField txtTotalDePeas_2;
	private JButton btnActualizar_1;
	private JTextField txtZonaDeDescarga;
	private JTextField txtZonaDeDescarga_1;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 781, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 745, 353);
		frame.getContentPane().add(tabbedPane);
		JList ls_ac = new JList(inter.vetorPedidosAcabados);
		JList ls_pen = new JList(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
		JList ls_exe = new JList(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
		
		ls_ac.setVisibleRowCount(40);
		ls_ac.setBounds(10, 34, 720, 240);
		JPanel Pend = new JPanel();
		Pend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_pen.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		tabbedPane.addTab("Pedidos Pendentes", null, Pend, null);
		Pend.setLayout(null);
		
		txtHoraDeChegada_2 = new JTextField();
		txtHoraDeChegada_2.setText("Hora de Chegada\tPedido");
		txtHoraDeChegada_2.setColumns(10);
		txtHoraDeChegada_2.setBounds(10, 11, 720, 20);
		Pend.add(txtHoraDeChegada_2);
		
		ls_pen.setBounds(10, 37, 720, 248);
		Pend.add(ls_pen);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_pen.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		btnNewButton.setBounds(317, 296, 96, 23);
		Pend.add(btnNewButton);
		
		JPanel Exe = new JPanel();
		Exe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_exe.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		tabbedPane.addTab("Pedidos em Execu\u00E7\u00E3o", null, Exe, null);
		Exe.setLayout(null);
		
		txtHoraDeChegada_1 = new JTextField();
		txtHoraDeChegada_1.setText("Hora de Chegada\tPedido\tHora de Arranque");
		txtHoraDeChegada_1.setColumns(10);
		txtHoraDeChegada_1.setBounds(10, 11, 720, 20);
		Exe.add(txtHoraDeChegada_1);
		
		
		ls_exe.setBounds(10, 36, 720, 247);
		Exe.add(ls_exe);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_exe.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		btnNewButton_1.setBounds(320, 291, 103, 23);
		Exe.add(btnNewButton_1);
		
		JPanel Acabados = new JPanel();
		Acabados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_ac.setListData(inter.vetorPedidosAcabados);
			}
		});
		tabbedPane.addTab("Pedidos Acabados", null, Acabados, null);
		Acabados.setLayout(null);
		
		
		Acabados.add(ls_ac);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ls_ac.setListData(inter.vetorPedidosAcabados);
			}
		});
		btnActualizar.setBounds(321, 285, 98, 23);
		Acabados.add(btnActualizar);
		
		txtHoraDeChegada = new JTextField();
		txtHoraDeChegada.setText("Hora de Chegada\tPedido\tHora de Arranque\tHora de Fim");
		txtHoraDeChegada.setBounds(10, 11, 720, 20);
		Acabados.add(txtHoraDeChegada);
		txtHoraDeChegada.setColumns(10);
		
		JPanel Stats = new JPanel();
		tabbedPane.addTab("Estat\u00EDsticas de Produ\u00E7\u00E3o", null, Stats, null);
		Stats.setLayout(null);
		
		txtClula = new JTextField();
		txtClula.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtClula.setText("C\u00E9lula 1");
		txtClula.setBounds(10, 11, 70, 20);
		Stats.add(txtClula);
		txtClula.setColumns(10);
		
		txtMquinaA = new JTextField();
		txtMquinaA.setText("M\u00E1quina A");
		txtMquinaA.setBounds(20, 42, 63, 20);
		Stats.add(txtMquinaA);
		txtMquinaA.setColumns(10);
		
		txtMquinaC = new JTextField();
		txtMquinaC.setText("M\u00E1quina C");
		txtMquinaC.setBounds(20, 85, 63, 20);
		Stats.add(txtMquinaC);
		txtMquinaC.setColumns(10);
		
		txtP = new JTextField();
		txtP.setText("P1");
		txtP.setBounds(90, 21, 20, 20);
		Stats.add(txtP);
		txtP.setColumns(10);
		
		txtP_1 = new JTextField();
		txtP_1.setText("P2");
		txtP_1.setColumns(10);
		txtP_1.setBounds(120, 21, 20, 20);
		Stats.add(txtP_1);
		
		txtP_2 = new JTextField();
		txtP_2.setText("P6");
		txtP_2.setColumns(10);
		txtP_2.setBounds(148, 21, 20, 20);
		Stats.add(txtP_2);
		
		txtTs = new JTextField();
		txtTs.setText("Tempo de Opera\u00E7\u00E3o");
		txtTs.setColumns(10);
		txtTs.setBounds(178, 21, 106, 20);
		Stats.add(txtTs);
		
		txtTotal = new JTextField();
		txtTotal.setText("Total");
		txtTotal.setColumns(10);
		txtTotal.setBounds(294, 21, 35, 20);
		Stats.add(txtTotal);
		
		textField_4 = new JTextField();
		textField_4.setText("P1");
		textField_4.setColumns(10);
		textField_4.setBounds(90, 63, 20, 20);
		Stats.add(textField_4);
		
		txtP_3 = new JTextField();
		txtP_3.setText("P3");
		txtP_3.setColumns(10);
		txtP_3.setBounds(120, 63, 20, 20);
		Stats.add(txtP_3);
		
		txtP_4 = new JTextField();
		txtP_4.setText("P8");
		txtP_4.setColumns(10);
		txtP_4.setBounds(148, 63, 20, 20);
		Stats.add(txtP_4);
		
		textField = new JTextField();
		textField.setText("Tempo de Opera\u00E7\u00E3o");
		textField.setColumns(10);
		textField.setBounds(178, 63, 106, 20);
		Stats.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Total");
		textField_1.setColumns(10);
		textField_1.setBounds(294, 63, 35, 20);
		Stats.add(textField_1);
		
		txtClula_1 = new JTextField();
		txtClula_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtClula_1.setText("C\u00E9lula 2");
		txtClula_1.setColumns(10);
		txtClula_1.setBounds(366, 11, 63, 20);
		Stats.add(txtClula_1);
		
		textField_3 = new JTextField();
		textField_3.setText("M\u00E1quina A");
		textField_3.setColumns(10);
		textField_3.setBounds(376, 42, 63, 20);
		Stats.add(textField_3);
		
		txtMquinaB = new JTextField();
		txtMquinaB.setText("M\u00E1quina B");
		txtMquinaB.setColumns(10);
		txtMquinaB.setBounds(376, 85, 63, 20);
		Stats.add(txtMquinaB);
		
		textField_6 = new JTextField();
		textField_6.setText("P1");
		textField_6.setColumns(10);
		textField_6.setBounds(456, 21, 20, 20);
		Stats.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("P2");
		textField_7.setColumns(10);
		textField_7.setBounds(486, 21, 20, 20);
		Stats.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("P6");
		textField_8.setColumns(10);
		textField_8.setBounds(514, 21, 20, 20);
		Stats.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("Tempo de Opera\u00E7\u00E3o");
		textField_9.setColumns(10);
		textField_9.setBounds(544, 21, 106, 20);
		Stats.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("Total");
		textField_10.setColumns(10);
		textField_10.setBounds(660, 21, 35, 20);
		Stats.add(textField_10);
		
		txtP_5 = new JTextField();
		txtP_5.setText("P5");
		txtP_5.setColumns(10);
		txtP_5.setBounds(456, 63, 20, 20);
		Stats.add(txtP_5);
		
		txtP_6 = new JTextField();
		txtP_6.setText("P8");
		txtP_6.setColumns(10);
		txtP_6.setBounds(486, 63, 20, 20);
		Stats.add(txtP_6);
		
		textField_14 = new JTextField();
		textField_14.setText("Tempo de Opera\u00E7\u00E3o");
		textField_14.setColumns(10);
		textField_14.setBounds(516, 63, 106, 20);
		Stats.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("Total");
		textField_15.setColumns(10);
		textField_15.setBounds(632, 63, 35, 20);
		Stats.add(textField_15);
		
		txtClula_2 = new JTextField();
		txtClula_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtClula_2.setText("C\u00E9lula 3");
		txtClula_2.setColumns(10);
		txtClula_2.setBounds(10, 140, 70, 20);
		Stats.add(txtClula_2);
		
		textField_5 = new JTextField();
		textField_5.setText("M\u00E1quina A");
		textField_5.setColumns(10);
		textField_5.setBounds(20, 171, 63, 20);
		Stats.add(textField_5);
		
		textField_11 = new JTextField();
		textField_11.setText("M\u00E1quina B");
		textField_11.setColumns(10);
		textField_11.setBounds(20, 214, 63, 20);
		Stats.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("P1");
		textField_12.setColumns(10);
		textField_12.setBounds(100, 150, 20, 20);
		Stats.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("P5");
		textField_13.setColumns(10);
		textField_13.setBounds(100, 192, 20, 20);
		Stats.add(textField_13);
		
		textField_16 = new JTextField();
		textField_16.setText("P2");
		textField_16.setColumns(10);
		textField_16.setBounds(130, 150, 20, 20);
		Stats.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("P8");
		textField_17.setColumns(10);
		textField_17.setBounds(130, 192, 20, 20);
		Stats.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("P6");
		textField_18.setColumns(10);
		textField_18.setBounds(158, 150, 20, 20);
		Stats.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("Tempo de Opera\u00E7\u00E3o");
		textField_19.setColumns(10);
		textField_19.setBounds(160, 192, 106, 20);
		Stats.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("Tempo de Opera\u00E7\u00E3o");
		textField_20.setColumns(10);
		textField_20.setBounds(188, 150, 106, 20);
		Stats.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setText("Total");
		textField_21.setColumns(10);
		textField_21.setBounds(276, 192, 35, 20);
		Stats.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setText("Total");
		textField_22.setColumns(10);
		textField_22.setBounds(304, 150, 35, 20);
		Stats.add(textField_22);
		
		txtClula_3 = new JTextField();
		txtClula_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtClula_3.setText("C\u00E9lula 4");
		txtClula_3.setColumns(10);
		txtClula_3.setBounds(366, 140, 45, 20);
		Stats.add(txtClula_3);
		
		textField_24 = new JTextField();
		textField_24.setText("M\u00E1quina A");
		textField_24.setColumns(10);
		textField_24.setBounds(376, 171, 63, 20);
		Stats.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setText("M\u00E1quina B");
		textField_25.setColumns(10);
		textField_25.setBounds(376, 214, 63, 20);
		Stats.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setText("P1");
		textField_26.setColumns(10);
		textField_26.setBounds(456, 150, 20, 20);
		Stats.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setText("P5");
		textField_27.setColumns(10);
		textField_27.setBounds(456, 192, 20, 20);
		Stats.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setText("P2");
		textField_28.setColumns(10);
		textField_28.setBounds(486, 150, 20, 20);
		Stats.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setText("P8");
		textField_29.setColumns(10);
		textField_29.setBounds(486, 192, 20, 20);
		Stats.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setText("P6");
		textField_30.setColumns(10);
		textField_30.setBounds(514, 150, 20, 20);
		Stats.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setText("Tempo de Opera\u00E7\u00E3o");
		textField_31.setColumns(10);
		textField_31.setBounds(516, 192, 106, 20);
		Stats.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setText("Tempo de Opera\u00E7\u00E3o");
		textField_32.setColumns(10);
		textField_32.setBounds(544, 150, 106, 20);
		Stats.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setText("Total");
		textField_33.setColumns(10);
		textField_33.setBounds(632, 192, 35, 20);
		Stats.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setText("Total");
		textField_34.setColumns(10);
		textField_34.setBounds(660, 150, 35, 20);
		Stats.add(textField_34);
		
		txtTotalDePeas = new JTextField();
		txtTotalDePeas.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDePeas.setText("Total de Pe\u00E7as Produzidas");
		txtTotalDePeas.setBounds(276, 245, 181, 20);
		Stats.add(txtTotalDePeas);
		txtTotalDePeas.setColumns(10);
		
		btnActualizar_1 = new JButton("Actualizar");
		btnActualizar_1.setBounds(322, 302, 89, 23);
		Stats.add(btnActualizar_1);
		
		panel = new JPanel();
		tabbedPane.addTab("Estat\u00EDsticas de Montagem e Descarga", null, panel, null);
		panel.setLayout(null);
		
		txtTotalDePeas_1 = new JTextField();
		txtTotalDePeas_1.setText("Total de Pe\u00E7as Montadas");
		txtTotalDePeas_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDePeas_1.setColumns(10);
		txtTotalDePeas_1.setBounds(21, 11, 163, 20);
		panel.add(txtTotalDePeas_1);
		
		txtTotalDePeas_2 = new JTextField();
		txtTotalDePeas_2.setText("Total de Pe\u00E7as Descarregadas");
		txtTotalDePeas_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDePeas_2.setColumns(10);
		txtTotalDePeas_2.setBounds(457, 11, 163, 20);
		panel.add(txtTotalDePeas_2);
		
		txtZonaDeDescarga = new JTextField();
		txtZonaDeDescarga.setText("Zona de Descarga 1");
		txtZonaDeDescarga.setHorizontalAlignment(SwingConstants.CENTER);
		txtZonaDeDescarga.setColumns(10);
		txtZonaDeDescarga.setBounds(31, 42, 163, 20);
		panel.add(txtZonaDeDescarga);
		
		txtZonaDeDescarga_1 = new JTextField();
		txtZonaDeDescarga_1.setText("Zona de Descarga 2");
		txtZonaDeDescarga_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtZonaDeDescarga_1.setColumns(10);
		txtZonaDeDescarga_1.setBounds(31, 85, 163, 20);
		panel.add(txtZonaDeDescarga_1);
		
		button = new JButton("Actualizar");
		button.setBounds(323, 291, 89, 23);
		panel.add(button);
	}
}
