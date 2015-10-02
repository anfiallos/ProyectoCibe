

import net.sourceforge.jFuzzyLogic.FIS;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;


 
/**
 * Test parsing an FCL file

 */  




	
	public class FuzzyCibe {
	
	 public static void main(String[] args) throws Exception {
	        // Load from 'FCL' file
	        String fileName = "cibe.fcl";
	        FIS fis = FIS.load(fileName,true);
	        // Error while loading?
	        if( fis == null ) { 
	            System.err.println("Can't load file: '" 
	                                   + fileName + "'");
	            return;
	        }

	        // Show 
	        fis.chart();
 
	        // Set inputs
	        fis.setVariable("volumen_importaciones",10);
	        fis.setVariable("exitos_hallazgos_origen", 10);
	        fis.setVariable("exitos_hallazgos_tipo_producto", 60);
	        // Evaluate
	        fis.evaluate();

	        // Show output variable's chart 
	        fis.getVariable("riesgo_transgenico").chartDefuzzifier(true);
	        double tip = fis.getVariable("riesgo_transgenico").getValue();
	        System.out.println(tip);
	        // Print ruleSet
	        System.out.println(fis);
	    }

}
