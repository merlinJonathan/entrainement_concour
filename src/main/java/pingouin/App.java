package pingouin;

import pingouin.enums.StrategyEnums;

public class App {

	public final static StrategyEnums strategy = StrategyEnums.BASE;
	
	public static void main(String[] args) {
		switch(strategy) {
			case BASE: {
				break;
			}
			default: {
				break;
			}
		}
		System.out.println("programme lancé");
	}
}
