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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class GUI {

	private JFrame frame;
	Interface inter=Interface.getInstance();
	private JTextField P1_C1A;
	private JTextField P2_C1A;
	private JTextField P6_C1A;
	private JTextField tC1A;
	private JTextField nTAC1;
	private JTextField P1_C1C;
	private JTextField P3_C1C;
	private JTextField P8_C1C;
	private JTextField tC1C;
	private JTextField nTCC1;
	private JPanel Stats_MU;
	private JTextField MTotal;
	private JTextField DTotal;
	private JButton btnActualizar_1;
	private JTextField Dz1;
	private JTextField Dz2;
	private JButton button;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextField P1_C2A;
	private JTextField P5_C2B;
	private JTextField P2_C2A;
	private JTextField P8_C2B;
	private JTextField P6_C2A;
	private JTextField tC2B;
	private JTextField tC2A;
	private JTextField nTC2B;
	private JTextField nTAC2;
	private JTextField nTOTAL;
	private JTextField P1_C3A;
	private JTextField P5_C3B;
	private JTextField P2_C3A;
	private JTextField P8_C3B;
	private JTextField P6_C3A;
	private JTextField tC3B;
	private JTextField tC3A;
	private JTextField nTC3B;
	private JTextField nTC3A;
	private JTextField P1_C4A;
	private JTextField P5_C4B;
	private JTextField P2_C4A;
	private JTextField P8_C4B;
	private JTextField P6_C4A;
	private JTextField tC4B;
	private JTextField tC4A;
	private JTextField nTC4B;
	private JTextField nTC4A;
	private JTextField emMont;
	private JTextField emDesc;
	private JTextField emTransf;
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
		frame.setBounds(100, 100, 842, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 806, 409);
		frame.getContentPane().add(tabbedPane);
		JList ls_pen = new JList(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
		JPanel Pend = new JPanel();
		Pend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_pen.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		tabbedPane.addTab("Pedidos Pendentes", null, Pend, null);
		Pend.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 781, 287);
		Pend.add(scrollPane);
		
		scrollPane.setViewportView(ls_pen);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_pen.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		btnNewButton.setBounds(337, 335, 96, 23);
		Pend.add(btnNewButton);
		
		JLabel lblHoraDeChegada = new JLabel("Hora de Chegada");
		lblHoraDeChegada.setBounds(21, 12, 121, 14);
		Pend.add(lblHoraDeChegada);
		
		JLabel label = new JLabel("Pedido");
		label.setBounds(174, 12, 121, 14);
		Pend.add(label);
		JList ls_exe = new JList(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
		JPanel Exe = new JPanel();
		Exe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_exe.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		tabbedPane.addTab("Pedidos em Execu\u00E7\u00E3o", null, Exe, null);
		Exe.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 781, 285);
		Exe.add(scrollPane_2);
		
		scrollPane_2.setViewportView(ls_exe);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_exe.setListData(inter.vetorPedidosAcabados);//TESTE PASSAR PARA PENDENTES
			}
		});
		btnNewButton_1.setBounds(347, 332, 103, 23);
		Exe.add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("Hora de Chegada");
		label_1.setBounds(10, 11, 121, 14);
		Exe.add(label_1);
		
		JLabel label_2 = new JLabel("Pedido");
		label_2.setBounds(163, 11, 121, 14);
		Exe.add(label_2);
		
		JLabel label_3 = new JLabel("Hora de Arranque");
		label_3.setBounds(291, 11, 121, 14);
		Exe.add(label_3);
		
		JPanel Acabados = new JPanel();
		JList ls_ac = new JList(inter.vetorPedidosAcabados);
		Acabados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ls_ac.setListData(inter.vetorPedidosAcabados);
			}
		});
		tabbedPane.addTab("Pedidos Acabados", null, Acabados, null);
		Acabados.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 34, 781, 287);
		Acabados.add(scrollPane_1);
		
		scrollPane_1.setViewportView(ls_ac);
		
		ls_ac.setVisibleRowCount(40);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ls_ac.setListData(inter.vetorPedidosAcabados);
			}
		});
		btnActualizar.setBounds(333, 332, 98, 23);
		Acabados.add(btnActualizar);
		
		JLabel label_4 = new JLabel("Hora de Chegada");
		label_4.setBounds(10, 11, 121, 14);
		Acabados.add(label_4);
		
		JLabel label_5 = new JLabel("Pedido");
		label_5.setBounds(163, 11, 121, 14);
		Acabados.add(label_5);
		
		JLabel label_6 = new JLabel("Hora de Arranque");
		label_6.setBounds(291, 11, 121, 14);
		Acabados.add(label_6);
		
		JLabel label_7 = new JLabel("Hora de Fim");
		label_7.setBounds(436, 11, 121, 14);
		Acabados.add(label_7);
		
		JPanel Stats_Trans = new JPanel();
		tabbedPane.addTab("Estat\u00EDsticas de Produ\u00E7\u00E3o", null, Stats_Trans, null);
		Stats_Trans.setLayout(null);
		
		P1_C1A = new JTextField();
		P1_C1A.setBounds(86, 42, 20, 20);
		Stats_Trans.add(P1_C1A);
		P1_C1A.setColumns(10);
		
		P2_C1A = new JTextField();
		P2_C1A.setColumns(10);
		P2_C1A.setBounds(116, 42, 20, 20);
		Stats_Trans.add(P2_C1A);
		
		P6_C1A = new JTextField();
		P6_C1A.setColumns(10);
		P6_C1A.setBounds(144, 42, 20, 20);
		Stats_Trans.add(P6_C1A);
		
		tC1A = new JTextField();
		tC1A.setColumns(10);
		tC1A.setBounds(174, 42, 106, 20);
		Stats_Trans.add(tC1A);
		
		nTAC1 = new JTextField();
		nTAC1.setColumns(10);
		nTAC1.setBounds(315, 42, 35, 20);
		Stats_Trans.add(nTAC1);
		
		P1_C1C = new JTextField();
		P1_C1C.setColumns(10);
		P1_C1C.setBounds(86, 84, 20, 20);
		Stats_Trans.add(P1_C1C);
		
		P3_C1C = new JTextField();
		P3_C1C.setColumns(10);
		P3_C1C.setBounds(116, 84, 20, 20);
		Stats_Trans.add(P3_C1C);
		
		P8_C1C = new JTextField();
		P8_C1C.setColumns(10);
		P8_C1C.setBounds(144, 84, 20, 20);
		Stats_Trans.add(P8_C1C);
		
		tC1C = new JTextField();
		tC1C.setColumns(10);
		tC1C.setBounds(174, 84, 106, 20);
		Stats_Trans.add(tC1C);
		
		nTCC1 = new JTextField();
		nTCC1.setColumns(10);
		nTCC1.setBounds(315, 84, 35, 20);
		Stats_Trans.add(nTCC1);
		
		P1_C2A = new JTextField();
		P1_C2A.setColumns(10);
		P1_C2A.setBounds(498, 43, 20, 20);
		Stats_Trans.add(P1_C2A);
		
		P5_C2B = new JTextField();
		P5_C2B.setColumns(10);
		P5_C2B.setBounds(498, 89, 20, 20);
		Stats_Trans.add(P5_C2B);
		
		P2_C2A = new JTextField();
		P2_C2A.setColumns(10);
		P2_C2A.setBounds(528, 43, 20, 20);
		Stats_Trans.add(P2_C2A);
		
		P8_C2B = new JTextField();
		P8_C2B.setColumns(10);
		P8_C2B.setBounds(528, 89, 20, 20);
		Stats_Trans.add(P8_C2B);
		
		P6_C2A = new JTextField();
		P6_C2A.setColumns(10);
		P6_C2A.setBounds(556, 43, 20, 20);
		Stats_Trans.add(P6_C2A);
		
		tC2B = new JTextField();
		tC2B.setColumns(10);
		tC2B.setBounds(567, 88, 106, 20);
		Stats_Trans.add(tC2B);
		
		tC2A = new JTextField();
		tC2A.setColumns(10);
		tC2A.setBounds(596, 43, 106, 20);
		Stats_Trans.add(tC2A);
		
		nTC2B = new JTextField();
		nTC2B.setColumns(10);
		nTC2B.setBounds(702, 89, 35, 20);
		Stats_Trans.add(nTC2B);
		
		nTAC2 = new JTextField();
		nTAC2.setColumns(10);
		nTAC2.setBounds(730, 43, 35, 20);
		Stats_Trans.add(nTAC2);

		P1_C3A = new JTextField();
		P1_C3A.setColumns(10);
		P1_C3A.setBounds(89, 168, 20, 20);
		Stats_Trans.add(P1_C3A);
		
		P5_C3B = new JTextField();
		P5_C3B.setColumns(10);
		P5_C3B.setBounds(89, 214, 20, 20);
		Stats_Trans.add(P5_C3B);
		
		P2_C3A = new JTextField();
		P2_C3A.setColumns(10);
		P2_C3A.setBounds(119, 168, 20, 20);
		Stats_Trans.add(P2_C3A);
		
		P8_C3B = new JTextField();
		P8_C3B.setColumns(10);
		P8_C3B.setBounds(119, 214, 20, 20);
		Stats_Trans.add(P8_C3B);
		
		P6_C3A = new JTextField();
		P6_C3A.setColumns(10);
		P6_C3A.setBounds(147, 168, 20, 20);
		Stats_Trans.add(P6_C3A);
		
		tC3B = new JTextField();
		tC3B.setColumns(10);
		tC3B.setBounds(158, 213, 106, 20);
		Stats_Trans.add(tC3B);
		
		tC3A = new JTextField();
		tC3A.setColumns(10);
		tC3A.setBounds(187, 168, 106, 20);
		Stats_Trans.add(tC3A);
		
		nTC3B = new JTextField();
		nTC3B.setColumns(10);
		nTC3B.setBounds(293, 214, 35, 20);
		Stats_Trans.add(nTC3B);
		
		nTC3A = new JTextField();
		nTC3A.setColumns(10);
		nTC3A.setBounds(321, 168, 35, 20);
		Stats_Trans.add(nTC3A);

		P1_C4A = new JTextField();
		P1_C4A.setColumns(10);
		P1_C4A.setBounds(498, 173, 20, 20);
		Stats_Trans.add(P1_C4A);
		
		P5_C4B = new JTextField();
		P5_C4B.setColumns(10);
		P5_C4B.setBounds(498, 219, 20, 20);
		Stats_Trans.add(P5_C4B);
		
		P2_C4A = new JTextField();
		P2_C4A.setColumns(10);
		P2_C4A.setBounds(528, 173, 20, 20);
		Stats_Trans.add(P2_C4A);
		
		P8_C4B = new JTextField();
		P8_C4B.setColumns(10);
		P8_C4B.setBounds(528, 219, 20, 20);
		Stats_Trans.add(P8_C4B);
		
		P6_C4A = new JTextField();
		P6_C4A.setColumns(10);
		P6_C4A.setBounds(556, 173, 20, 20);
		Stats_Trans.add(P6_C4A);
		
		tC4B = new JTextField();
		tC4B.setColumns(10);
		tC4B.setBounds(567, 218, 106, 20);
		Stats_Trans.add(tC4B);
		
		tC4A = new JTextField();
		tC4A.setColumns(10);
		tC4A.setBounds(596, 173, 106, 20);
		Stats_Trans.add(tC4A);
		
		nTC4B = new JTextField();
		nTC4B.setColumns(10);
		nTC4B.setBounds(702, 219, 35, 20);
		Stats_Trans.add(nTC4B);
		
		nTC4A = new JTextField();
		nTC4A.setColumns(10);
		nTC4A.setBounds(730, 173, 35, 20);
		Stats_Trans.add(nTC4A);

		nTOTAL = new JTextField();
		nTOTAL.setBounds(157, 299, 66, 20);
		Stats_Trans.add(nTOTAL);
		nTOTAL.setColumns(10);
		
		btnActualizar_1 = new JButton("Actualizar");
		btnActualizar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//celula 1 Máquina A
				P1_C1A.setText(Integer.toString(inter.np1_mA_c1));
				P2_C1A.setText(Integer.toString(inter.np2_mA_c1));
				P6_C1A.setText(Integer.toString(inter.np6_mA_c1));
				tC1A.setText(Integer.toString(inter.t_mA_c1));
				nTAC1.setText(Integer.toString(inter.np1_mA_c1+inter.np2_mA_c1+inter.np6_mA_c1));
				//celula 1 Máquina C
				P1_C1C.setText(Integer.toString(inter.np1_mC_c1));
				P3_C1C.setText(Integer.toString(inter.np3_mC_c1));
				P8_C1C.setText(Integer.toString(inter.np8_mC_c1));
				tC1C.setText(Integer.toString(inter.t_mC_c1));
				nTCC1.setText(Integer.toString(inter.np1_mC_c1+inter.np3_mC_c1+inter.np8_mC_c1));
				//celula 2 Máquina A
				P1_C2A.setText(Integer.toString(inter.np1_mA_c2));
				P2_C2A.setText(Integer.toString(inter.np2_mA_c2));
				P6_C2A.setText(Integer.toString(inter.np6_mA_c2));
				tC2A.setText(Integer.toString(inter.t_mA_c2));
				nTAC2.setText(Integer.toString(inter.np1_mA_c2+inter.np2_mA_c2+inter.np6_mA_c2));
				//celula 2 Máquina B
				P5_C2B.setText(Integer.toString(inter.np5_mB_c2));
				P8_C2B.setText(Integer.toString(inter.np8_mB_c2));
				tC2B.setText(Integer.toString(inter.t_mB_c2));
				nTC2B.setText(Integer.toString(inter.np5_mB_c2+inter.np8_mB_c2));
				//celula 3 Máquina A
				P1_C3A.setText(Integer.toString(inter.np1_mA_c3));
				P2_C3A.setText(Integer.toString(inter.np2_mA_c3));
				P6_C3A.setText(Integer.toString(inter.np6_mA_c3));
				tC3A.setText(Integer.toString(inter.t_mA_c3));
				nTC3A.setText(Integer.toString(inter.np1_mA_c3+inter.np2_mA_c3+inter.np6_mA_c3));
				//celula 3 Máquina B
				P5_C3B.setText(Integer.toString(inter.np5_mB_c3));
				P8_C3B.setText(Integer.toString(inter.np8_mB_c3));
				tC3B.setText(Integer.toString(inter.t_mB_c3));
				nTC3B.setText(Integer.toString(inter.np5_mB_c3+inter.np8_mB_c3));
				//celula 4 Máquina A
				P1_C4A.setText(Integer.toString(inter.np1_mA_c4));
				P2_C4A.setText(Integer.toString(inter.np2_mA_c4));
				P6_C4A.setText(Integer.toString(inter.np6_mA_c4));
				tC4A.setText(Integer.toString(inter.t_mA_c4));
				nTC4A.setText(Integer.toString(inter.np1_mA_c4+inter.np2_mA_c4+inter.np6_mA_c4));
				//celula 4 Máquina B
				P5_C4B.setText(Integer.toString(inter.np5_mB_c4));
				P8_C4B.setText(Integer.toString(inter.np8_mB_c4));
				tC4B.setText(Integer.toString(inter.t_mB_c4));
				nTC4B.setText(Integer.toString(inter.np5_mB_c4+inter.np8_mB_c4));
				//TOTAL
				nTOTAL.setText(Integer.toString(inter.nproduzidas));
				emTransf.setText(Integer.toString(inter.emTransf));
			}
		});
		btnActualizar_1.setBounds(322, 332, 89, 23);
		Stats_Trans.add(btnActualizar_1);
		
		JLabel lblClula = new JLabel("C\u00E9lula 1");
		lblClula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClula.setBounds(10, 15, 73, 16);
		Stats_Trans.add(lblClula);
		
		JLabel label_8 = new JLabel("C\u00E9lula 2");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(408, 18, 73, 16);
		Stats_Trans.add(label_8);
		
		JLabel label_9 = new JLabel("C\u00E9lula 3");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(10, 144, 73, 16);
		Stats_Trans.add(label_9);
		
		JLabel lblClula_1 = new JLabel("C\u00E9lula 4");
		lblClula_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClula_1.setBounds(415, 147, 73, 16);
		Stats_Trans.add(lblClula_1);
		
		JLabel lblMquinaA = new JLabel("M\u00E1quina A");
		lblMquinaA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMquinaA.setBounds(10, 45, 73, 14);
		Stats_Trans.add(lblMquinaA);
		
		JLabel label_11 = new JLabel("M\u00E1quina A");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_11.setBounds(408, 45, 73, 14);
		Stats_Trans.add(label_11);
		
		JLabel label_12 = new JLabel("M\u00E1quina A");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_12.setBounds(10, 171, 73, 14);
		Stats_Trans.add(label_12);
		
		JLabel label_13 = new JLabel("M\u00E1quina A");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_13.setBounds(408, 174, 73, 14);
		Stats_Trans.add(label_13);
		
		JLabel label_14 = new JLabel("M\u00E1quina C");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_14.setBounds(10, 88, 73, 14);
		Stats_Trans.add(label_14);
		
		JLabel label_15 = new JLabel("M\u00E1quina B");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_15.setBounds(10, 217, 73, 14);
		Stats_Trans.add(label_15);
		
		JLabel label_16 = new JLabel("M\u00E1quina B");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_16.setBounds(408, 221, 73, 14);
		Stats_Trans.add(label_16);
		
		JLabel label_17 = new JLabel("M\u00E1quina B");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_17.setBounds(408, 92, 73, 14);
		Stats_Trans.add(label_17);
		
		
		
		JLabel label_23 = new JLabel("P1");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_23.setBounds(491, 15, 30, 26);
		Stats_Trans.add(label_23);
		
		JLabel label_24 = new JLabel("P2");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_24.setBounds(520, 15, 30, 26);
		Stats_Trans.add(label_24);
		
		JLabel label_25 = new JLabel("P6");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_25.setBounds(549, 15, 30, 26);
		Stats_Trans.add(label_25);
		
		JLabel label_30 = new JLabel("P8");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_30.setBounds(521, 62, 30, 26);
		Stats_Trans.add(label_30);
		
		JLabel label_31 = new JLabel("P5");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_31.setBounds(492, 62, 30, 26);
		Stats_Trans.add(label_31);
		
		JLabel label_37 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_37.setHorizontalAlignment(SwingConstants.CENTER);
		label_37.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_37.setBounds(583, 16, 129, 26);
		Stats_Trans.add(label_37);
		
		JLabel label_39 = new JLabel("Total");
		label_39.setHorizontalAlignment(SwingConstants.CENTER);
		label_39.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_39.setBounds(712, 16, 59, 26);
		Stats_Trans.add(label_39);
		
		JLabel label_40 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_40.setHorizontalAlignment(SwingConstants.CENTER);
		label_40.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_40.setBounds(553, 63, 129, 26);
		Stats_Trans.add(label_40);
		
		JLabel label_41 = new JLabel("P1");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_41.setBounds(79, 11, 30, 26);
		Stats_Trans.add(label_41);
		
		JLabel label_42 = new JLabel("P2");
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
		label_42.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_42.setBounds(108, 11, 30, 26);
		Stats_Trans.add(label_42);
		
		JLabel label_43 = new JLabel("P6");
		label_43.setHorizontalAlignment(SwingConstants.CENTER);
		label_43.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_43.setBounds(137, 11, 30, 26);
		Stats_Trans.add(label_43);
		
		JLabel label_44 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_44.setHorizontalAlignment(SwingConstants.CENTER);
		label_44.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_44.setBounds(171, 12, 129, 26);
		Stats_Trans.add(label_44);
		
		JLabel label_45 = new JLabel("Total");
		label_45.setHorizontalAlignment(SwingConstants.CENTER);
		label_45.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_45.setBounds(300, 12, 59, 26);
		Stats_Trans.add(label_45);
		
		JLabel label_46 = new JLabel("P1");
		label_46.setHorizontalAlignment(SwingConstants.CENTER);
		label_46.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_46.setBounds(81, 60, 30, 26);
		Stats_Trans.add(label_46);
		
		JLabel label_47 = new JLabel("P3");
		label_47.setHorizontalAlignment(SwingConstants.CENTER);
		label_47.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_47.setBounds(110, 60, 30, 26);
		Stats_Trans.add(label_47);
		
		JLabel label_48 = new JLabel("P8");
		label_48.setHorizontalAlignment(SwingConstants.CENTER);
		label_48.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_48.setBounds(139, 60, 30, 26);
		Stats_Trans.add(label_48);
		
		JLabel label_49 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_49.setHorizontalAlignment(SwingConstants.CENTER);
		label_49.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_49.setBounds(173, 61, 129, 26);
		Stats_Trans.add(label_49);
		
		JLabel label_50 = new JLabel("Total");
		label_50.setHorizontalAlignment(SwingConstants.CENTER);
		label_50.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_50.setBounds(302, 61, 59, 26);
		Stats_Trans.add(label_50);
		
		JLabel lblTotalDePeas = new JLabel("Total de Pe\u00E7as Transformadas");
		lblTotalDePeas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalDePeas.setBounds(74, 269, 254, 32);
		Stats_Trans.add(lblTotalDePeas);
		
		JLabel label_55 = new JLabel("Total");
		label_55.setHorizontalAlignment(SwingConstants.CENTER);
		label_55.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_55.setBounds(689, 62, 59, 26);
		Stats_Trans.add(label_55);
		
		JLabel label_18 = new JLabel("P1");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_18.setBounds(82, 140, 30, 26);
		Stats_Trans.add(label_18);
		
		JLabel label_19 = new JLabel("P2");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_19.setBounds(111, 140, 30, 26);
		Stats_Trans.add(label_19);
		
		JLabel label_26 = new JLabel("P6");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_26.setBounds(140, 140, 30, 26);
		Stats_Trans.add(label_26);
		
		JLabel label_27 = new JLabel("P8");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_27.setBounds(112, 187, 30, 26);
		Stats_Trans.add(label_27);
		
		JLabel label_32 = new JLabel("P5");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_32.setBounds(83, 187, 30, 26);
		Stats_Trans.add(label_32);
		
		JLabel label_33 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_33.setBounds(174, 141, 129, 26);
		Stats_Trans.add(label_33);
		
		JLabel label_34 = new JLabel("Total");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_34.setBounds(303, 141, 59, 26);
		Stats_Trans.add(label_34);
		
		JLabel label_54 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_54.setHorizontalAlignment(SwingConstants.CENTER);
		label_54.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_54.setBounds(144, 188, 129, 26);
		Stats_Trans.add(label_54);
		
		JLabel label_56 = new JLabel("Total");
		label_56.setHorizontalAlignment(SwingConstants.CENTER);
		label_56.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_56.setBounds(280, 187, 59, 26);
		Stats_Trans.add(label_56);
		
		JLabel label_20 = new JLabel("P1");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_20.setBounds(491, 145, 30, 26);
		Stats_Trans.add(label_20);
		
		JLabel label_21 = new JLabel("P2");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_21.setBounds(520, 145, 30, 26);
		Stats_Trans.add(label_21);
		
		JLabel label_22 = new JLabel("P6");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_22.setBounds(549, 145, 30, 26);
		Stats_Trans.add(label_22);
		
		JLabel label_28 = new JLabel("P8");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_28.setBounds(521, 192, 30, 26);
		Stats_Trans.add(label_28);
		
		JLabel label_29 = new JLabel("P5");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_29.setBounds(492, 192, 30, 26);
		Stats_Trans.add(label_29);
		
		JLabel label_35 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_35.setBounds(583, 146, 129, 26);
		Stats_Trans.add(label_35);
		
		JLabel label_36 = new JLabel("Total");
		label_36.setHorizontalAlignment(SwingConstants.CENTER);
		label_36.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_36.setBounds(712, 146, 59, 26);
		Stats_Trans.add(label_36);
		
		JLabel label_38 = new JLabel("Tempo de Opera\u00E7\u00E3o");
		label_38.setHorizontalAlignment(SwingConstants.CENTER);
		label_38.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_38.setBounds(553, 193, 129, 26);
		Stats_Trans.add(label_38);
		
		JLabel label_57 = new JLabel("Total");
		label_57.setHorizontalAlignment(SwingConstants.CENTER);
		label_57.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_57.setBounds(689, 192, 59, 26);
		Stats_Trans.add(label_57);
		
		emTransf = new JTextField();
		emTransf.setColumns(10);
		emTransf.setBounds(561, 299, 66, 20);
		Stats_Trans.add(emTransf);
		
		JLabel lblTotalDePeas_4 = new JLabel("Total de Pe\u00E7as em Transforma\u00E7\u00E3o");
		lblTotalDePeas_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalDePeas_4.setBounds(455, 269, 274, 32);
		Stats_Trans.add(lblTotalDePeas_4);
		
		Stats_MU = new JPanel();
		tabbedPane.addTab("Estat\u00EDsticas de Montagem e Descarga", null, Stats_MU, null);
		Stats_MU.setLayout(null);
		
		MTotal = new JTextField();
		MTotal.setHorizontalAlignment(SwingConstants.CENTER);
		MTotal.setColumns(10);
		MTotal.setBounds(221, 40, 97, 20);
		Stats_MU.add(MTotal);
		
		DTotal = new JTextField();
		DTotal.setHorizontalAlignment(SwingConstants.CENTER);
		DTotal.setColumns(10);
		DTotal.setBounds(618, 40, 99, 20);
		Stats_MU.add(DTotal);
		
		Dz1 = new JTextField();
		Dz1.setHorizontalAlignment(SwingConstants.CENTER);
		Dz1.setColumns(10);
		Dz1.setBounds(633, 89, 73, 20);
		Stats_MU.add(Dz1);
		
		Dz2 = new JTextField();
		Dz2.setHorizontalAlignment(SwingConstants.CENTER);
		Dz2.setColumns(10);
		Dz2.setBounds(633, 147, 73, 20);
		Stats_MU.add(Dz2);
		
		emDesc = new JTextField();
		emDesc.setHorizontalAlignment(SwingConstants.CENTER);
		emDesc.setColumns(10);
		emDesc.setBounds(632, 196, 73, 20);
		Stats_MU.add(emDesc);
		
		emMont = new JTextField();
		emMont.setHorizontalAlignment(SwingConstants.CENTER);
		emMont.setColumns(10);
		emMont.setBounds(243, 106, 97, 20);
		Stats_MU.add(emMont);
		
		button = new JButton("Actualizar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Dz1.setText(Integer.toString(inter.num_descarga_d1_total));
				Dz2.setText(Integer.toString(inter.num_descarga_d2_total));
				DTotal.setText(Integer.toString(inter.num_descarga_d1_total+inter.num_descarga_d2_total));
				MTotal.setText(Integer.toString(inter.num_montagens_total));
				emDesc.setText(Integer.toString(inter.emDesc));
				emMont.setText(Integer.toString(inter.emMont));
			}
		});
		button.setBounds(323, 291, 89, 23);
		Stats_MU.add(button);
		
		JLabel label_51 = new JLabel("Total de Pe\u00E7as Montadas");
		label_51.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_51.setBounds(21, 42, 207, 16);
		Stats_MU.add(label_51);
		
		JLabel label_52 = new JLabel("Total de Pe\u00E7as Descarregadas");
		label_52.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_52.setBounds(389, 40, 207, 16);
		Stats_MU.add(label_52);
		
		JLabel label_53 = new JLabel("Zona de Descarga 1");
		label_53.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_53.setBounds(444, 89, 145, 16);
		Stats_MU.add(label_53);
		
		JLabel lblTotalDePeas_1 = new JLabel("Zona de Descargas 2");
		lblTotalDePeas_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDePeas_1.setBounds(444, 147, 163, 16);
		Stats_MU.add(lblTotalDePeas_1);
		
		JLabel lblTotalDePeas_2 = new JLabel("Total de Pe\u00E7as em Montagem");
		lblTotalDePeas_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDePeas_2.setBounds(21, 107, 207, 16);
		Stats_MU.add(lblTotalDePeas_2);
		
		
		JLabel lblTotalDePeas_3 = new JLabel("Total de Pe\u00E7as em Descarga");
		lblTotalDePeas_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDePeas_3.setBounds(389, 201, 207, 16);
		Stats_MU.add(lblTotalDePeas_3);
		
		
	}
}
