package br.ce.aquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@Test
	public void deveSalvarTarefaComSuce() {
		WebDriver driver = acessarAplicacao();
		try {
		//clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2023");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		//fechar o browser
		
	}finally {
		driver.quit();

	}
	}
		
		@Test
		public void naoDeveSalvarTarefaSemDescricao() {
			WebDriver driver = acessarAplicacao();
			try {
			//clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2023");
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
			//fechar o browser
			
		}finally {
			driver.quit();
		}
		}
			@Test
			public void deveSalvarTarefaSemData() {
				WebDriver driver = acessarAplicacao();
				try {
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();
				//escrever descrição
				driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				//clicar em salvar
				driver.findElement(By.id("saveButton")).click();
				//validar mensagem de sucesso
				String message = driver.findElement(By.id("message")).getText();
				Assert.assertEquals("Fill the due date", message);
				//fechar o browser
				
			}finally {
				driver.quit();

			}
			}
			
			@Test
			public void deveSalvarTarefaComDataPassada() {
				WebDriver driver = acessarAplicacao();
				try {
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();
				//escrever descrição
				driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				//escrever a data
				driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
				//clicar em salvar
				driver.findElement(By.id("saveButton")).click();
				//validar mensagem de sucesso
				String message = driver.findElement(By.id("message")).getText();
				Assert.assertEquals("Due date must not be in past", message);
				//fechar o browser
				
			}finally {
				driver.quit();

			}
			}
}

