package com.remmelt.example.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DockerComposeYaml {
	private String image;
	private String build;

	private String dockerfile;
	private String command;

	private List<String> links;
	private List<String> ports;
	private List<String> expose;
	private List<String> volumes;
	private List<String> environment;
}
