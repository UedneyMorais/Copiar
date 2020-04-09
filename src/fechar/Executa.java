/* Criado por Uedney Cristiano de Morais em 29/08/2019
 * Função do sistema: Copiar arquivos de uma pasta para outra,
 * fazendo assim o trabalho de copiar automaticamente.*/
package fechar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import br.control.Tray;

public class Executa {
	static String TEMP = "";
	static String ORIGEM = "";
	static String DESTINO = "";
	static String EXTENSAO = "";

	public static void main(String[] args) {
	
		JSONObject jsonObject;

		// Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		// Variaveis que irao armazenar os dados do arquivo JSON

		try {
			// Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Concretize\\Scripts\\copiar\\config.json"));

			// Salva nas variaveis os dados retirados do arquivo
			ORIGEM = "\\"+(String) jsonObject.get("origem");
			DESTINO = (String) jsonObject.get("destino");
			EXTENSAO = (String) jsonObject.get("extensao");
			TEMP = (String) jsonObject.get("tempo");
			
			System.out.println(ORIGEM+DESTINO+EXTENSAO+TEMP);

		}
		// Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Tray.iniciaTray(ORIGEM,DESTINO,EXTENSAO);
	}
}