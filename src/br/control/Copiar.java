package br.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;


public class Copiar {
		
	// método que copia as imagens
	public static void copiar(String ORIGEM,String DESTINO,String EXTENSAO) {

		File source = new File(ORIGEM + "\\");
		File destination = new File(DESTINO+"\\");
		File extension = new File(EXTENSAO);
		String ext = String.valueOf(extension);
		
		
		copyFiles(source, destination,ext);
		System.out.println(ORIGEM+DESTINO+EXTENSAO);

	}

	public static void copyFiles(File source, File destination,final String ext) {
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(ext);
			}

		};

		File[] files = source.listFiles(filter);
		for (File file : files) {

			InputStream input = null;
			OutputStream output = null;

			try {
				input = new BufferedInputStream(new FileInputStream(file));
				output = new BufferedOutputStream(new FileOutputStream(new File(destination, file.getName())));
				
				int result = -1;
				while ((result = input.read()) != -1) {
					output.write(result);
				}

				output.flush();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				close(input, output);
				
			}

		}

	}

	public static void close(Closeable... items) {
		for (Closeable c : items) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

}
