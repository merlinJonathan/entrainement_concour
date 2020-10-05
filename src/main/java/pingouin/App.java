package pingouin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import pingouin.enums.StrategyEnums;
import pingouin.models.City;
import pingouin.models.Output;
import pingouin.services.FileService;

public class App {
	private static final List<String> INPUT_FILES = Arrays.asList(
            "src/main/resources/dataset/ctsten0244_input_1.txt",
            "src/main/resources/dataset/ctsten0244_input_2.txt",
            "src/main/resources/dataset/ctsten0244_input_3.txt",
            "src/main/resources/dataset/ctsten0244_input_4.txt",
            "src/main/resources/dataset/ctsten0244_input_5.txt",
			"src/main/resources/dataset/ctsten0244_input_6.txt",
			"src/main/resources/dataset/ctsten0244_input_7.txt",
			"src/main/resources/dataset/ctsten0244_input_8.txt",
			"src/main/resources/dataset/ctsten0244_input_9.txt",
			"src/main/resources/dataset/ctsten0244_input_10.txt"
    );
	
	public final static StrategyEnums strategy = StrategyEnums.BASE;
	
	
	
	
	
	// revoir la fonction de score pour quelle se fasse au fur et a mesure dans les fonction apply au lieu d'etre calculé a la fin
	
	
	
	
	public static void main(String[] args) throws IOException {
		City city = FileService.initData(INPUT_FILES.get(0));
		Output output = null;
		
		switch(strategy) {
			case BASE: {
				output = city.start();
				break;
			}
			default: {
				break;
			}
		}
		output.generateFile("./src/main/resources/result.txt");
		System.out.println("Score => " + City.getScore());
	}
}
