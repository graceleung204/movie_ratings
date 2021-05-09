package edu.sjsu.movie;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/*
	tconst (string) - alphanumeric unique identifier of the title
	ordering (integer) – a number to uniquely identify rows for a given titleId
	nconst (string) - alphanumeric unique identifier of the name/person
	category (string) - the category of job that person was in
	job (string) - the specific job title if applicable, else '\N'
	characters (string) - the name of the character played if applicable, else '\N'
*/

@Data
// @NoArgsConstructor  // required by Hibernate for Entity creation?
@RequiredArgsConstructor
// @Entity
// @Table()
public class Principals {

    // private @Id String id;
    private String tconst;
	private int ordering;
	private String nconst;
	private String category;
	private String job;
	private String characters;
}
