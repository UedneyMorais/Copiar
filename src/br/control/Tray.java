package br.control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Tray {
	public static void iniciaTray(String ORIGEM,String DESTINO,String EXTENSAO) {
		Runnable runer = new Runnable() {

			public void run() {
				if (SystemTray.isSupported()) {
					SystemTray tray = SystemTray.getSystemTray();
					Image image = Toolkit.getDefaultToolkit().getImage("C:\\Concretize\\Scripts\\copiar\\bulb.gif");
					PopupMenu popup = new PopupMenu();
					MenuItem item = new MenuItem("Copiar imagens");
					MenuItem item2 = new MenuItem("Sobre");
					MenuItem item3 = new MenuItem("Fechar");
					item.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					item.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Copiar.copiar(ORIGEM, DESTINO, EXTENSAO);
						}
					});
					
					item2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {	
							JOptionPane.showMessageDialog(null,
									"Desenvolvido por Uedney Morais\n Versão: 2.0 Data da versão: 30/08/2019");
						}
					});
					
					item3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});

					popup.add(item);
					popup.add(item2);
					popup.add(item3);
					TrayIcon trayIcon = new TrayIcon(image, "Mantenha aberto para copiar as imagens", popup);
					trayIcon.setImageAutoSize(true);
					try {
						tray.add(trayIcon);
					} catch (AWTException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("tray Indisponivel");
				}

			}
		};
		EventQueue.invokeLater(runer);
	}
}
