package cn.pp.service;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * test：在build过程中，如果找不到对应的符号，则在对应的.gradle文件中增加对应的依赖
 * 特别要注意spring-jdbc这个包的引入
 */
public class Test {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("spring.xml"); // <1>
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>
		reader.loadBeanDefinitions(resource);

		//要将新建的模块spring-wxj加入到根目录下的build.gradle中，不然会报找不到符号
		LoginService loginService = factory.getBean("loginService", LoginService.class);
		loginService.login("wxj");
	}
}
