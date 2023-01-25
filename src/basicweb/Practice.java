package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice {

	public static void main(String[] args) {
		//Classe criada para praticar selenium
		
		//String com URL da página a ser utilizada
		String baseUrl ="https://learn.letskodeit.com";
		
		//Cria a variavel WebDriver que vai ser utilizado para fazer ações na página
		WebDriver driver;
		
		//Seta o caminho do driver que será utilizado(nesse utilizei firefox)
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\geckodriver.exe");
		
		// cria novo driver
		driver = new FirefoxDriver();
		
		//Maximiza a Janela
		driver.manage().window().maximize();
		
		//indica ao driver qual a página utilizar
		driver.get(baseUrl);
		
		//Daqui em diante são as ações feitas na página 
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/**
		//Clicando em todos os radios buttons examples
		driver.findElement(By.id("bmwradio")).click();
		driver.findElement(By.id("benzradio")).click();
		driver.findElement(By.id("hondaradio")).click();
		
		//selecionando valores em combobox
		WebElement selectElement = driver.findElement(By.id("carselect"));
		final Select combobox = new Select(selectElement);
		combobox.selectByVisibleText("Honda");
		combobox.selectByVisibleText("BMW");
		combobox.selectByVisibleText("Benz");
		
		//selecionando valores multiplas seleção
		selectElement = driver.findElement(By.id("multiple-select-example"));
		final Select multipleElement = new Select(selectElement);
		multipleElement.selectByValue("apple");
		multipleElement.selectByValue("orange");
		multipleElement.selectByValue("peach");
		multipleElement.deselectAll();
		
		//clicando em checkbox
		driver.findElement(By.id("bmwcheck")).click();
		driver.findElement(By.id("benzcheck")).click();
		driver.findElement(By.id("hondacheck")).click();
		
		//Selecionando campo pelo CSSSelector
		
		driver.findElement(By.cssSelector("input[id='hide-textbox']")).click();
		driver.findElement(By.cssSelector("#show-textbox")).click();

		
		//Exemplo de XPath absoluto e relativo
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div[3]/fieldset/input[1]")).sendKeys("XPath Absoluto");
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Xpath Relativo");

	
		
		//Exemplo de Contains
		
		//um contains
		driver.findElement(By.xpath("//div[@class='block large-row-spacer']//button[contains(text(),'Open Window')]")).click();
		
		//Combinação de 2 contains
		driver.findElement(By.xpath("//div[@class='right-align']//input[contains(@class,'btn-style class2')and contains(@value,'Hide')]")).click();

		
		//Utilizando Starts-With para encontrar elementos
		//driver.findElement(By.xpath("//input[starts-with(@value,'Hide')]")).click();
		
		//utilizando nós 
		// parent procura nó pai
		// preceding-sinbling procura os nós irmãos acima
		//following-sibling procura os nós irmãos abaixo
		 
		
		driver.findElement(By.xpath("//input[@id='hide-textbox']//parent::fieldset//following-sibling::input[@id='displayed-text']")).sendKeys("Teste");;

		**/
	}

}
