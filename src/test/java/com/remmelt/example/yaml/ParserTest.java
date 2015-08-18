package com.remmelt.example.yaml;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.net.URL;

import static org.fest.assertions.Assertions.assertThat;

@Slf4j
public class ParserTest {

	@Test
	public void testParse() throws Exception {
		URL resource = this.getClass().getResource("/test.yml");
		InputStream inputStream = resource.openStream();

		Yaml parser = new Yaml(new Constructor(DockerComposeYaml.class));
		DockerComposeYaml load = (DockerComposeYaml) parser.load(inputStream);

		assertThat(load.getImage()).isEqualTo("helloworld:12345678");
		assertThat(load.getBuild()).isEqualTo("/path/to/build/dir");
		assertThat(load.getLinks()).containsExactly("db", "db:database", "redis");
		assertThat(load.getExpose()).containsExactly("3000", "8000");
		log.debug(String.valueOf(load));
	}

}
